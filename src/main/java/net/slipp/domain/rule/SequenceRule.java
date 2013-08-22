package net.slipp.domain.rule;

import net.slipp.domain.showing.Showing;

public class SequenceRule extends Rule {

	private static final String sequence = null;

	public boolean isStatisfiedBy(Showing showing){
		return showing.isSequence(sequence);
	}
	
}
