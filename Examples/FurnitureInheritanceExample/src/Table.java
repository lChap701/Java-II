
public class Table extends Furniture {
	
	//properties
	private int numLegs;
	private boolean extendable;
	private double surfaceArea;
	/**
	 * @return the numLegs
	 */
	public int getNumLegs() {
		return numLegs;
	}
	/**
	 * @param numLegs the numLegs to set
	 */
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	/**
	 * @return the extendable
	 */
	public boolean isExtendable() {
		return extendable;
	}
	/**
	 * @param extendable the extendable to set
	 */
	public void setExtendable(boolean extendable) {
		this.extendable = extendable;
	}
	/**
	 * @return the surfaceArea
	 */
	public double getSurfaceArea() {
		return surfaceArea;
	}
	/**
	 * @param surfaceArea the surfaceArea to set
	 */
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	/**
	 * contructor with all possible settings for a table
	 * @param material
	 * @param height
	 * @param length
	 * @param width
	 * @param design
	 * @param color
	 * @param price
	 * @param legs
	 * @param ext
	 * @param area
	 */
	public Table(String material, double height, double length, double width, String design, String color,
			double price, int legs, boolean ext, double area) {
		//must call base class constructor first
		super(material, height, length, width, design, color, price);	
		//set the Table values
		this.setNumLegs(legs);
		this.setExtendable(ext);
		this.setSurfaceArea(area);
	}
	
	public Table() {
		//must call base class constructor first
		super();
		numLegs = 4;
		extendable = false;
		surfaceArea = 200;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " Number of legs: " + numLegs;
	}

}
