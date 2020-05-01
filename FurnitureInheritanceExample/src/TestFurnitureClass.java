import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFurnitureClass {

	@Test
	public void testDefaultFurniture() {
		Furniture f = new Furniture();
		
		assertEquals("Wood", f.getMaterial());
		assertEquals(50.50, f.getPrice(), 1);
	}

	@Test
	public void testFurnitureOverload() {
		Furniture f = new Furniture("Metal", 50, 60, 70, "Chic", "Burgundy", 50.49);
		
		assertEquals(50.50, f.getPrice());
	}
	
	@Test
	public void testToString() {
		Furniture f = new Furniture();
		
		assertEquals("Material is " + f.getMaterial() + " and price is " + f.getPrice(), 
				f.toString());
	}
}
