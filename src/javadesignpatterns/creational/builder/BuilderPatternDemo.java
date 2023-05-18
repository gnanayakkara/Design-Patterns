package javadesignpatterns.creational.builder;

//reference : https://www.tutorialspoint.com/design_pattern/builder_pattern.htm

public class BuilderPatternDemo {
	
	public static void main(String[] args) {
		
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal vegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		System.out.println("Total Cost : " + vegMeal.getCost());
		
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\n\nNon-veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost : " + nonVegMeal.getCost());
	}

}
