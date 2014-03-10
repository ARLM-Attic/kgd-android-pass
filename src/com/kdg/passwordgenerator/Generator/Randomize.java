package com.kdg.passwordgenerator.Generator;

import java.util.Random;

import android.util.Log;

public class Randomize {

	private int pSize;
	private boolean lOption;
	private boolean nOption;
	private boolean sOption;
	private final boolean DEBUG = true;

	public Randomize(int limit, boolean l, boolean n, boolean s) {

		pSize = limit;
		lOption = l;
		nOption = n;
		sOption = s;

	}

	public String rndPass() {

		Random rand = new Random();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZacbdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "`~!@#$%^&*()-_=+{}[]:;'?.>,<|";

		int limit = this.pSize;
		StringBuilder password = new StringBuilder();
		StringBuilder complex = new StringBuilder();

		int randomResult = 0;

		if (DEBUG) {
			Log.i("Password_Size", Integer.toString(limit));
		}
		
		for (int count = 0; count <limit; count++) {
			if(lOption && nOption && sOption) {
				
				// get random letter
				randomResult = rand.nextInt(letters.length());
				complex.append(letters.charAt(randomResult));

				// get random number
				randomResult = rand.nextInt(numbers.length());
				complex.append(numbers.charAt(randomResult));

				// get random symbol
				randomResult = rand.nextInt(symbols.length());
				complex.append(symbols.charAt(randomResult));

				// randomize from all three.
				password.append(complex.charAt(rand.nextInt(complex
						.length())));
				
			}
			else if (lOption && nOption && !sOption) {
				
				// get random letter
				randomResult = rand.nextInt(letters.length());
				complex.append(letters.charAt(randomResult));

				// get random number
				randomResult = rand.nextInt(numbers.length());
				complex.append(numbers.charAt(randomResult));

				// randomize from all three.
				password.append(complex.charAt(rand.nextInt(complex
						.length())));
				
			}
			else if (lOption && !nOption && sOption) {
				
				// get random letter
				randomResult = rand.nextInt(letters.length());
				complex.append(letters.charAt(randomResult));

				// get random symbol
				randomResult = rand.nextInt(symbols.length());
				complex.append(symbols.charAt(randomResult));

				// randomize from all three.
				password.append(complex.charAt(rand.nextInt(complex
						.length())));
			}
			else if (!lOption && nOption && sOption) {
				
				// get random number
				randomResult = rand.nextInt(numbers.length());
				complex.append(numbers.charAt(randomResult));

				// get random symbol
				randomResult = rand.nextInt(symbols.length());
				complex.append(symbols.charAt(randomResult));

				// randomize from all three.
				password.append(complex.charAt(rand.nextInt(complex
						.length())));
			} 
			else if(lOption && !nOption && !sOption) {
				// get random letter
				randomResult = rand.nextInt(letters.length());
				password.append(letters.charAt(randomResult));

			}
			else if (!lOption && nOption && !sOption) {

				// get random number
				randomResult = rand.nextInt(numbers.length());
				password.append(numbers.charAt(randomResult));

			}
			else if (!lOption && !nOption && sOption) {
				
				// get random symbol
				randomResult = rand.nextInt(symbols.length());
				password.append(symbols.charAt(randomResult));

			}
			
			// Debugging
			if (DEBUG) {
				Log.i("Password", password.toString());

			}
			

			

		}
		
		return password.toString();
		
		

		
		
	}

}
