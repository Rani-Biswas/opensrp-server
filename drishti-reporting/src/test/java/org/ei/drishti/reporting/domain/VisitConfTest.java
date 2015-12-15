package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VisitConfTest {
	
	private VisitConf visitConf;
	
	@Before
	public void setUp(){
		String anc_visit1_from_week = null;
		String anc_visit2_from_week = null;
		String anc_visit3_from_week = null;
		String anc_visit4_from_week = null;
		visitConf = new VisitConf(anc_visit1_from_week, anc_visit2_from_week,
				anc_visit3_from_week, anc_visit4_from_week);
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = visitConf.id();
		assertEquals(w,s);
	}
	
	@Test
	public void anc_visit1_from_weekTest(){
		String s = null;
		String w = visitConf.anc_visit1_from_week();
		assertEquals(w,s);
	}
	
	@Test
	public void anc_visit2_from_weekTest(){
		String s = null;
		String w = visitConf.anc_visit2_from_week();
		assertEquals(w,s);
	}
	
	@Test
	public void anc_visit3_from_weekTest(){
		String s = null;
		String w = visitConf.anc_visit3_from_week();
		assertEquals(w,s);
	}
	
	@Test
	public void anc_visit4_from_weekTest(){
		String s = null;
		String w = visitConf.anc_visit4_from_week();
		assertEquals(w,s);
	}

}
