package javadesignpatterns.creational.builder;

public abstract class ColdDrink implements Item{

	@Override
	public Packing packing() {
		return new Bottel();
	}
	
	@Override
	public abstract float price();
	
}
