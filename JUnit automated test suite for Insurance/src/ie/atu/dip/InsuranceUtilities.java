package ie.atu.dip;

import java.util.Scanner;

/**
 * The `InsuranceUtilities` class provides utility methods for handling
 * insurance-related calculations and operations.
 */
public class InsuranceUtilities {

	/**
	 * Prompts the user for input, validates it using the provided `InputValidator`,
	 * and returns the valid input.
	 *
	 * @param prompt    The prompt message to display to the user.
	 * @param scanner   The `Scanner` object used for reading user input.
	 * @param validator The `InputValidator` object used for validating the input.
	 * @return Returns the valid input entered by the user.
	 */
	public static int getInput(String prompt, Scanner scanner, InputValidator validator) {

		int input;
		int defaultValue = -1;

		do {
			System.out.print(prompt);

			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next(); // consume the invalid input
			}

			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
			} else {
				input = defaultValue; // Set default value for invalid input
			}

		} while (!validator.isValid(input));

		return input;
	}

	/**
	 * Prints the insurance details based on the number of accidents and the
	 * calculated surcharge.
	 *
	 * @param basicInsurance The basic insurance amount.
	 * @param accidents      The number of accidents.
	 * @param surcharge      The surcharge amount.
	 * @param calculator     The `InsuranceCalculator` object used for calculating
	 *                       the additional surcharge.
	 */
	public void printInsuranceDetails(int basicInsurance, int accidents, int surcharge,
			InsuranceCalculator calculator) {

		switch (accidents) {
		case 0:
			System.out.println("No surcharge.");
			System.out.println("Total amount to pay: " + basicInsurance);
			break;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			int additionalSurcharge = calculator.calculateAdditionalSurcharge(accidents);
			System.out.println("Additional surcharge for accident: " + additionalSurcharge + "\nTotal amount to pay: "
					+ (basicInsurance + additionalSurcharge));
			break;
		}

		if (accidents > 6)
			System.out.println("No insurance");
	}

}
