package ie.atu.dip;

/**
 * The `InsuranceCalculator` class calculates the surcharge for an insurance
 * policy based on the age of the policyholder.
 */
public class InsuranceCalculator {

	InsuranceProgram insurance = new InsuranceProgram();

	/**
	 * Calculates the surcharge for an insurance policy based on the age of the
	 * policyholder.
	 *
	 * @param age The age of the policyholder. Should be a non-negative integer.
	 * @return Returns the surcharge amount.
	 * @throws IllegalArgumentException if the age is invalid (negative or greater
	 *                                  than 100).
	 */
	public int calculateSurcharge(int age) {

		// Create an instance of the NonNegativeNumberValidator class to validate the
		// age.
		NonNegativeNumberValidator nonNegativeValidator = new NonNegativeNumberValidator();

		// Check if the age is valid using the nonNegativeValidator.
		if (!nonNegativeValidator.isValid(age) || age > 100) {
			System.out.println("Invalid age detected.");
			throw new IllegalArgumentException("Invalid age.");
		}

		// Check if the age is less than 25.
		if (age < 25) {
			System.out.println("Additional surcharge 100.");
			return 100;
		} else {
			// No surcharge for age 25 and above.
			System.out.println("No additional surcharge.");
			return 0;
		}
	}

	/**
	 * Calculates the additional surcharge for an insurance policy based on the
	 * number of accidents.
	 *
	 * @param accidents The number of accidents. Should be a non-negative integer.
	 * @return Returns the additional surcharge amount.
	 */
	public int calculateAdditionalSurcharge(int accidents) {
		if (accidents < 0) {
			// Invalid number of accidents.
			throw new IllegalArgumentException("Invalid number of accidents.");
		}

		switch (accidents) {
		case 1:
			return 50;
		case 2:
			return 125;
		case 3:
			return 225;
		case 4:
			return 375;
		case 5:
			return 575;
		default:
			return 0;
		}
	}
}
