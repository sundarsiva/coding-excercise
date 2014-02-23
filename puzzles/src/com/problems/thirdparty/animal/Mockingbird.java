package com.problems.thirdparty.animal;

public class Mockingbird implements Talkable {

	protected String nameSeparator = ": ";
	
	public String getName() {
		return "ExMockingbird";
	}

	@Override
	public String talk() {
		return getName() + nameSeparator + "What did you expect?  A chirp?";

	}
}
