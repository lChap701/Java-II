/*
 * Base class for instantiating Furniture objects.
 * This class may be extended for specific types of furniture.
 */
public class Furniture {
	
	//instance variables
	private String material;
	private double height;
	private double length;
	private double width;
	private String design;
	private String color;
	private double price;
	
	//Parameterized constructor
	/**
	 * @param material
	 * @param height
	 * @param length
	 * @param width
	 * @param design
	 * @param color
	 * @param price
	 */
	public Furniture(String material, double height, double length, double width, String design, String color,
			double price) {
		this.setMaterial(material);
		this.setHeight(height);
		this.setLength(length);
		this.setWidth(width);
		this.setDesign(design);
		this.setColor(color);
		this.setPrice(price);
		//this.price = price;
		
	}
	/**
	 * Default constructor
	 */
	public Furniture() {
		this.material = "Wood";
		this.height = 50;
		this.length = 50;
		this.width = 50;
		this.design = "Square";
		this.color = "Brown";
		this.price = 50.50;
	}

	
	//getters and setters
	/**
	 * 
	 * @return
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * 
	 * @param m  Set the material. Material cannot set null values.
	 */
	public void setMaterial(String m) {
		this.material = m;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double h) {
		this.height = h;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double l) {
		length = l;
	}
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @return the design
	 */
	public String getDesign() {
		return design;
	}
	/**
	 * @param design the design to set
	 */
	public void setDesign(String design) {
		this.design = design;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets the furniture objects price.
	 * @param price the price to set (minimum is $50.50)
	 */
	public void setPrice(double price) {
		
		if(price >= 50.50) {
			this.price = price;
		}
		else {
			this.price = 50.50;
		}
		
	}
	
	/**
	 * returns a string showing material and price
	 */
	@Override
	public String toString() {
		return "Material is " + this.material + " and price is " + this.price;
	}
	

}
