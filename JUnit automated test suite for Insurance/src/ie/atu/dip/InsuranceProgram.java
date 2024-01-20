package ie.atu.dip;

import java.util.Scanner;

/**
 * The `InsuranceProgram` class is the entry point of the insurance program. It
 * calculates the insurance premium based on the user's age and number of
 * accidents.
 * 
 * @author Dragana
 * @version 14/12/2023
 * 
 */
public class InsuranceProgram {

	/**
	 * The main method is the entry point of the program. It prompts the user for
	 * input, calculates the insurance premium, and prints the insurance details.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		InsuranceCalculator insuranceCalculator = new InsuranceCalculator();
		InsuranceUtilities insuranceUtilities = new InsuranceUtilities();

		// Prompt the user for their age and validate it using the
		// PositiveNumberValidator.
		int age = InsuranceUtilities.getInput("Enter your age: ", input, new PositiveNumberValidator());

		// Calculate the surcharge based on the user's age.
		int surcharge = insuranceCalculator.calculateSurcharge(age);

		// Calculate the basic insurance premium.
		int basicInsurance = 500 + surcharge;

		// Prompt the user for the number of accidents and validate it using the
		// NonNegativeNumberValidator.
		int accidents = InsuranceUtilities.getInput("\nHow many accidents did you have? ", input,
				new NonNegativeNumberValidator());

		// Print the insurance details including the basic insurance premium, number of
		// accidents, surcharge, and insurance calculator details.
		insuranceUtilities.printInsuranceDetails(basicInsurance, accidents, surcharge, insuranceCalculator);
	}
}
