package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5389849780285560045L;
	private final int x;
    private final int y;

	public NotEnoughBatteryException(final int x, final int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Can not move to pos(" + this.x + ", " + this.y + "). Not enough battery.";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

}
