package com.problems.animals;

public class ServiceLocator {
	
	private static ServiceLocator soleInstance;
    private AnimalSound as;
    
    public static void load(ServiceLocator arg) {
        soleInstance = arg;
    }

    public ServiceLocator(AnimalSound as) {
        this.as = as;
    }

    public static AnimalSound getAnimal() {
        return soleInstance.as;
    }
    
}
