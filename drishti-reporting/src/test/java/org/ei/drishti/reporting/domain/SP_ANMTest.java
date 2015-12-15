package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SP_ANMTest {
	
	private SP_ANM sp_ANM;
	
	@Before
	public void setUp(){
		String identifier = null;
		String name = null;
		String subCenter = null;
		Integer phcId = null;
		sp_ANM = new SP_ANM(identifier, name, subCenter, phcId);
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = sp_ANM.id();
		assertEquals(w,s);
	}
	
	@Test
	public void identifierTest(){
		String s = null;
		String w = sp_ANM.identifier();
		assertEquals(w,s);
	}
	
	@Test
	public void nameTest(){
		String s = null;
		String w = sp_ANM.name();
		assertEquals(w,s);
	}
	
	@Test
	public void subCenterTest(){
		String s = null;
		String w = sp_ANM.subCenter();
		assertEquals(w,s);
	}

}
