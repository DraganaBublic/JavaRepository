package ie.atu.dip;

/**
 * The `PositiveNumberValidator` class is an implementation of the
 * `InputValidator` interface. It validates whether an input is a positive
 * number or not.
 */
public class PositiveNumberValidator implements InputValidator {

	/**
	 * Checks if the given input is a positive number.
	 *
	 * @param input The input to be validated.
	 * @return Returns `true` if the input is a positive number, `false` otherwise.
	 */
	@Override
	public boolean isValid(int input) {
		return input > 0;
	}

	/**
	 * Gets the error message to be displayed when the input is not a positive
	 * number.
	 *
	 * @return Returns the error message as a string.
	 */
	@Override
	public String getErrorMessage() {
		return "Please enter a positive number.";
	}
}