package com.problems.animals;

public class AnimalSoundFactory {
	
	public static AnimalSound getAnimal(String animal){
		AnimalSound as = createAnimalFactory(animal);
		return as;
	}

	private static AnimalSound createAnimalFactory(String animal) {
		if("dog".equals(animal))
			return new Dog();
		if("cat".equals(animal))
			return new Cat();
		if("parrot".equals(animal))
			return new ExParrot();
		if("mockingbird".equals(animal))
			return new ExMockingbird();
		return null;
	}
	
	AnimalSound as = ServiceLocator.getAnimal();
	
	public String makeSound(){
		return as.makeSound();
	}
}
