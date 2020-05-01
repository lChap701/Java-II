
public class DemoAnimals {

	public static void main(String[] args) {
		
		//Animal a = new Animal();	//this won't work, can't instantiate an abstract class

		Dog fido = new Dog();		//default Dog object
		fido.setWeight(50);
		fido.setLength(36);
		fido.setHairColor("white");
		System.out.println("Dog Fido: " + fido.toString());

		Dog butch = new Dog(65, 48, "black");	//overloaded Dog object
		System.out.println("\nDog Butch: " + butch.toString());

		Rabbit cuddles = new Rabbit();		//default Rabbit object
		cuddles.setWeight(4.5);
		cuddles.setLength(21);
		cuddles.setEarLength(3.5);
		System.out.println("\nRabbit Cuddles: " + cuddles.toString() + "\n" + cuddles.move());

		Rabbit fluffy = new Rabbit(2, 18, 1.78);	//overloaded Rabbit object
		System.out.println("\nRabbit Fluffy: " + fluffy.toString() + "\n" +fluffy.move());

	}

}
