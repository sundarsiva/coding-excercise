package com.problems.animals.thirdparty.animal;

public class Parrot implements Talkable {

	protected String nameSeparator = ": ";

	public String getName() {
		return "ExParrot";
	}


	@Override
	public String talk() {

		return getName() + nameSeparator + "Polly wants a cracker!";

	}

}
