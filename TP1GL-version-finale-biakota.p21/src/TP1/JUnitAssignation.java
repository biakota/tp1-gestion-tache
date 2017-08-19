package TP1;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitAssignation {

	@Test
	public void test() {
		Assignation testAssign = new Assignation();
		boolean output = testAssign.modifier();
		assertEquals(true,output);
	}

}
