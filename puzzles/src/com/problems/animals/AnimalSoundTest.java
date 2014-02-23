package com.problems.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalSoundTest {
	
	public static void main(String[] args) {
		
		// Test our animals for sounds
		List <AnimalSound> animalList = new ArrayList<AnimalSound>();
		animalList.add(AnimalSoundFactory.getAnimal("dog"));
		animalList.add(AnimalSoundFactory.getAnimal("cat"));
		animalList.add(AnimalSoundFactory.getAnimal("parrot"));
		animalList.add(AnimalSoundFactory.getAnimal("mockingbird"));
		
		ServiceLocator.load(new ServiceLocator(new Dog()));
		AnimalSoundFactory asf = new AnimalSoundFactory();
		System.out.println("asf: "+asf.makeSound());
		
		testSounds(animalList);

   }	
   
   public static void testSounds(List <AnimalSound> animalList) {
	   
	   for (int i=0; animalList != null && i<animalList.size(); i++) {
		   
		   testSound(animalList.get(i));
	   }
	   
   }
   
   public static void testSound(AnimalSound animalSound) {
	   System.out.println(animalSound.makeSound());
   }

}

