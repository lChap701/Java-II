/**
 * Animal is the base class for all other animal classes
 * to extend (inherit) from. It is marked as abstract because
 * it is not to be instantiated, only inherited.
 * All animals have a weight and length property. It also contains
 * an abstract method called move, that must be implemented in classes
 * that extend the Animal class.
 * Other generic properties can be added as appropriate.
 * Specific animals will extend the Animal class,
 * and add additional properties that apply only to that particular animal.
 */
public abstract class Animal {
	//instance variables
	private double weight;
	private double length;

	//getters
	public double getWeight(){
		return weight;
	}
	public double getLength(){
		return length;
	}
	
	//setters
	public void setWeight(double w) {
		if(w > 0) {
			weight = w;
		}
		else {
			weight = 145;
		}
	}
	public void setLength(double l) {
		if(l > 0) {
			length = l;
		}
		else {
			length = 6;
		}
	}
	
	//constructors
	public Animal() {
		weight = 145;
		length = 6;
	}

	public Animal(double w, double l) {
		setWeight(w);
		setLength(l);
	}
	
	//override toString
	@Override
	public String toString() {
		return "Weight: " + weight + "   Length: " + length + "\n";
	}
	
	//abstract methods - all child classes must implement move method
	protected abstract String move();


}
