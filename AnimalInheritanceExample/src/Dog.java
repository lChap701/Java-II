/**
 * Dog class extends (inherits) from the Animal class.
 * Dogs get weight and height from Animal, and add hairColor.
 * Dogs can also "move".
 */
public class Dog extends Animal {
	//instance variables
	private String hairColor;
	
	//getters
	public String getHairColor(){
		return hairColor;
	}
	
	//setters
	public void setHairColor(String c) {
		if(c.isEmpty()) {
			hairColor = "brown"; 
		}
		else {
			hairColor = c;
		}
	}
		
	//constructors
	public Dog() {
		super();	//parent constructor MUST be called first
		hairColor = "brown";
	}

	/**
	 *
	 * @param w
	 * @param l
	 * @param c
	 */
	public Dog(double w, double l, String c) {
		super(w, l);	//parent constructor MUST be called first
		setHairColor(c);
	}
	
	//override toString
	@Override
	public String toString() {
		//common to call the parent toString method for reusability
		return super.toString() + "Hair color: " + hairColor;
	}
	
	//implement move method inherited from Animal class
	public String move() {
		return "Dogs walk";
	}

}
