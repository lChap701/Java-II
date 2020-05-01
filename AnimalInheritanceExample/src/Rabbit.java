/**
 * Rabbit class extends (inherits) from the Animal class.
 * Rabbits get weight and height from Animal, and add earLength.
 * Rabbits also "move".
 */

public class Rabbit extends Animal {
	//instance variables
	private double earLength;
	
	//getters
	public double getEarLength(){
		return earLength;
	}
	
	//setters
	public void setEarLength(double l) {
		if(l <= 0) {
			earLength = 2.76;
		}
		else {
			earLength = l;
		}
	}
		
	//constructors
	public Rabbit() {
		super();		//parent constructor MUST be called first
		earLength = 2.76;
	}
	
	/**
	 * 
	 * @param w
	 * @param l
	 * @param earL
	 */
	public Rabbit(double w, double l, double earL) {
		super(w, l);	//parent constructor MUST be called first
		setEarLength(earL);
	}
	
	//override toString
	@Override
	public String toString() {
		//common to call the parent toString method for reusability
		return super.toString() + "Ear length: " + earLength;
	}

	//implement move method inherited from Animal class
	public String move() {
		return "Rabbits hop";
	}

}
