package gov.ae.utils;

import java.util.Random;

public class Utils {

	/**
	 * Generate random phone number
	 * 
	 * @return
	 */
	public static String generateRandomPhoneNumber() {
		{
			int num1, num2, num3; // 3 numbers in area code
			int set2, set3; // sequence 2 and 3 of the phone number
			String phoneNumber;
			Random generator = new Random();

			num1 = 1; // add 1
			num2 = generator.nextInt(8); // randomize to 8 becuase 0 counts as a number in the generator
			num3 = generator.nextInt(8);

			// Sequence two of phone number
			// the plus 100 is so there will always be a 3 digit number
			// randomize to 643 because 0 starts the first placement so if i randomized up
			// to 642 it would only go up to 641 plus 100
			// and i used 643 so when it adds 100 it will not succeed 742
			set2 = generator.nextInt(643) + 100;

			// Sequence 3 of number
			// add 1000 so there will always be 4 numbers
			// 8999 so it wont success 9999 when the 1000 is added
			set3 = generator.nextInt(8999) + 1000;

			phoneNumber = num1 + "" + num2 + "" + num3 + "" + set2 + "" + set3;
			return phoneNumber;

		}



	}
}
