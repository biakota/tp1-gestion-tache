package TP1;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitMembre {

	@Test
	public void test() {
		Membre testMmbre =new Membre();
		boolean output = testMmbre.afficher();
		assertEquals(true,output);
	}

}
