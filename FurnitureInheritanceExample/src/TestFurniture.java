
public class TestFurniture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Furniture f = new Furniture();
		
		f.setPrice(27);
		System.out.println(f.toString());
		
		
		Table t = new Table();
		t.setPrice(51);
		System.out.println(t.toString());
		
		Table t2 = new Table("Metal", 50, 60, 70, "Chic", "Burgundy", 2500, 6, true, 575 );
		System.out.println(t2.toString());
		
		t2.setNumLegs(8);
		System.out.println(t2.toString());
	}

}
