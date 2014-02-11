package com.problems.animals;

import com.problems.animals.thirdparty.animal.Talkable;

public abstract class Animal implements AnimalSound, Talkable {
	
	String volume;
	
	public Animal(String volume){
		this.volume = volume;
	}
	
	public String getVolume() {
		return this.volume;
	}
	
	public String makeSound(){
		return talk();
	}

}
