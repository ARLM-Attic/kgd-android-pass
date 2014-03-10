package com.kdg.passwordgenerator;

import com.kdg.passwordgenerator.Generator.Randomize;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Boolean letters = false;
	private Boolean numbers = false;
	private Boolean symbols = false;
	private int pSize;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Get listview from view.
		ListView lv =  (ListView) findViewById(R.id.listView);
	
		//Set listview to array adapter,
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, 
				getResources().getStringArray(R.array.password_types)));
		
		//Set selection mode.
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lv.setItemsCanFocus(false);
		lv.setItemChecked(3, true);
		
		//Set onclick listener
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> l, View v, int position,
					long id) {
				String selectedItem = l.getItemAtPosition(position).toString();
				
				//Set bools for application.
				if(selectedItem.equals("Letters")) {
					if(letters) {
						letters = false;
					}else {
						letters = true;
					}
				}
				if(selectedItem.equals("Numbers")) {
					if(numbers) {
						numbers = false;
					} else {
						numbers = true;
					}
				}
				if(selectedItem.equals("Symbols")) {
					if(symbols) {
						symbols = false;
					} else {
						symbols = true;
					}
				}
				
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId()==R.id.play) {
			
			//Get text field from view.
			EditText et = (EditText) findViewById(R.id.editText);
			TextView tv = (TextView)findViewById(R.id.txtResults);
			
			tv.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ClipboardManager clippy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
					TextView tv2= (TextView) findViewById(R.id.txtResults);
					String savedPass = tv2.getText().toString();
					ClipData c = ClipData.newPlainText("Saved_Password", savedPass);
					clippy.setPrimaryClip(c);
					Toast.makeText(getApplicationContext(), "Password copied to clipboard", Toast.LENGTH_SHORT).show();
					
				}
			});
			
			
			
			
			try {
				pSize = Integer.parseInt(et.getText().toString());
				et.setTypeface(null, Typeface.NORMAL);
				et.setTextColor(Color.BLACK);
				
			} catch (NumberFormatException nfe) {
				et.setText("!!!");
				et.setTextColor(Color.RED);
				et.setTypeface(null, Typeface.BOLD);				
			}
			
			Randomize rpg = new Randomize(pSize, letters, numbers, symbols);
			tv.setText(rpg.rndPass());
			
		
	} else if (item.getItemId() == R.id.action_settings) {
		Intent intent = new Intent(this, AppSettings.class);
		startActivity(intent);
	}
			

		return super.onOptionsItemSelected(item);
	}
	
}
