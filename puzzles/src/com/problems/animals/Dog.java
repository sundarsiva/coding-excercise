package com.problems.animals;

public class Dog implements AnimalSound {

	protected String nameSeparator = ": ";

	private String volume;
	
	public Dog(){
		this.volume = "LOUD";
	}
	
	public String getName() {
		return "Dog ("+this.getVolume()+")";
	}

	@Override
	public String makeSound() {
		return getName() + nameSeparator + "Woof! Woof!";
	}

	@Override
	public String getVolume() {
		return this.volume;
	}

}
