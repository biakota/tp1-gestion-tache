package TP1;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTache {

	@Test
	public void test() {
		Tache testTache = new Tache();
		boolean output = testTache.afficher();
		assertEquals(true,output);
	}

}
