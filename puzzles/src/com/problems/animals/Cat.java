package com.problems.animals;

public class Cat implements AnimalSound {

	protected String nameSeparator = ": ";
	
	private String volume;
	
	public Cat(){
		this.volume = "quiet";
	}
	
	public String getName() {
		return "Cat ("+this.getVolume()+")";
	}

	@Override
	public String makeSound() {

		return getName() + nameSeparator + "Meow";
	}

	@Override
	public String getVolume() {
		return this.volume;
	}

}
