package com.problems.animals;

public class AnimalSoundNotifier {
	
	AnimalSound as;
	
	AnimalSoundNotifier(AnimalSound as){
		this.as = as;
	}
	
	public void notifySound(){
		if(this.as instanceof Dog){
			doPet();
		}
	}

	private void doPet() {
		//Pet the dog
	}
}
