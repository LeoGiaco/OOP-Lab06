package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 944577823094791111L;

	private final int invalidID;
	
	public WrongAccountHolderException(final int invalidID) {
		super();
		this.invalidID = invalidID;
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "An invalid userID (" + this.invalidID + ") was used to perform a transaction.";
	}
}
