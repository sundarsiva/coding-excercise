package com.problems.animals;

public class ExMockingbird extends com.problems.animals.thirdparty.animal.Mockingbird implements AnimalSound{

	private String volume;
	private String type;
	
	@Override
	public String getName() {
		return "ExMockingbird ("+this.volume+") ("+this.type+")";
	}
	
	ExMockingbird (){
		this.volume = "LOUD";
		this.type = "mocking";
	}
	
	@Override
	public String makeSound() {
		return super.talk();
	}

	@Override
	public String getVolume() {
		return this.volume;
	}

}
