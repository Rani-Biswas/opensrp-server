package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PHCTest {
	
	private PHC phc;
	
	@Before
	public void setUp(){
		Integer id = 0;
		String phcIdentifier = null;
		String name = null;
		phc = new PHC(id, phcIdentifier, name);
	}
	
	@Test
	public void idTest(){
		Integer s = 0;
		Integer w = phc.id();
		assertEquals(w,s);
	}
	
	@Test
	public void phcIdentifierTest(){
		String s = null;
		String w = phc.phcIdentifier();
		assertEquals(w,s);
	}
	
	@Test
	public void nameTest(){
		String s = null;
		String w = phc.name();
		assertEquals(w,s);
	}

}
