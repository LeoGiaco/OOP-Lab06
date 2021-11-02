package it.unibo.oop.lab.exception2;

public class NotEnoughFundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7513571833731461152L;
	public final double funds;
	public final double fundsNeeded;	
	
	public NotEnoughFundsException(double funds, double fundsNeeded) {
		super();
		this.funds = funds;
		this.fundsNeeded = fundsNeeded;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Could not complete transaction due to insufficient funds: available: " + this.funds + ", needed: " + this.fundsNeeded + ".";
	}
}
