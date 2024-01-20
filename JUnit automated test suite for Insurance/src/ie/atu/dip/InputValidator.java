package ie.atu.dip;

/**
 * The `InputValidator` interface defines the contract for validating input
 * values.
 */
public interface InputValidator {

	/**
	 * @param input The input value to be validated.
	 * @return Returns `true` if the input value is valid, `false` otherwise.
	 */
	boolean isValid(int input);

	/**
	 * Retrieves the error message associated with an invalid input value.
	 * 
	 * @return Returns the error message for an invalid input value.
	 */
	String getErrorMessage();
}