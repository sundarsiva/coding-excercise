package com.problems.animals;

public class ExParrot extends com.problems.animals.thirdparty.animal.Parrot implements AnimalSound{

	private String volume = "LOUD";
	
	@Override
	public String getName() {
		return "ExParrot ("+this.getVolume()+")";
	}
	
	public String makeSound() {
		return super.talk();
	}

	@Override
	public String getVolume() {
		return this.volume;
	}
	
}
