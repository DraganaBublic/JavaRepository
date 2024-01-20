package ie.atu.dip;

/**
 * The `NonNegativeNumberValidator` class is an implementation of the
 * `InputValidator` interface. It validates whether an input is a non-negative
 * number.
 */
public class NonNegativeNumberValidator implements InputValidator {

	/**
	 * Checks if the input is a non-negative number.
	 *
	 * @param input The input to be validated.
	 * @return Returns `true` if the input is a non-negative number, `false`
	 *         otherwise.
	 */
	@Override
	public boolean isValid(int input) {
		return input >= 0;
	}

	/**
	 * Gets the error message to be displayed when the input is invalid.
	 *
	 * @return Returns the error message for an invalid input.
	 */
	@Override
	public String getErrorMessage() {
		return "Please enter a non-negative number.";
	}
}