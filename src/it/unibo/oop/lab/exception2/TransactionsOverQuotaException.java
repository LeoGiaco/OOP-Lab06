package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 98358271632896123L;
	public final int transactionLimit;
	
	public TransactionsOverQuotaException(int transactionLimit) {
		super();
		this.transactionLimit = transactionLimit;
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "Transaction limit reached: " + this.transactionLimit + ".";
	}	
}
