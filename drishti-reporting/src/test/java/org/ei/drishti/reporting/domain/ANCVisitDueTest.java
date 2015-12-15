package org.ei.drishti.reporting.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ANCVisitDueTest {
	
	private ANCVisitDue ancVisitDue;

	@Before
	public void setUp() {
		int id = 0;
		Integer visitno = null;
		String entityid = null;
		String patientnum = null;
		String anmnum = null;
		String visittype = null;
		String lmpdate = null;
		String visitdate = null;
		String anmid = null;
		String womenname = null;
		ancVisitDue = new ANCVisitDue(id, entityid, patientnum, anmnum, visittype, visitno, lmpdate, womenname,
				visitdate, anmid);
	}
	
	@Test
	public void idTest(){
		Integer s = 0;
		Integer w = ancVisitDue.id();
		assertEquals(w,s);
	}

	@Test
	public void setentityidTest() {
		ancVisitDue.setentityid("entityid");
	}
	
	@Test
	public void entityidTest() {
		String s = null;
		String w = ancVisitDue.entityid();
		assertEquals(w,s);
	}
	
	@Test
	public void patientnumTest() {
		String s = null;
		String w = ancVisitDue.patientnum();
		assertEquals(w,s);
	}
	
	@Test
	public void setpatientnumTest() {
		ancVisitDue.setpatientnum("patientnum");
	}
	
	@Test
	public void anmnumTest() {
		String s = null;
		String w = ancVisitDue.anmnum();
		assertEquals(w,s);
	}
	
	@Test
	public void visittypeTest() {
		String s = null;
		String w = ancVisitDue.visittype();
		assertEquals(w,s);
	}
	
	@Test
	public void visitnoTest() {
		String s = null;
		Integer w = ancVisitDue.visitno();
		assertEquals(w,s);
	}
	
	@Test
	public void setvisitnoTest() {
		ancVisitDue.setvisitno(123);
	}
	
	@Test
	public void lmpdateTest() {
		String s = null;
		String w = ancVisitDue.lmpdate();
		assertEquals(w,s);
	}
	
	@Test
	public void setvisitdateTest() {
		ancVisitDue.setvisitdate("visitdate");
	}
	
	@Test
	public void womenNameTest() {
		String s = null;
		String w = ancVisitDue.womenName();
		assertEquals(w,s);
	}
	
	@Test
	public void visitdateTest() {
		String s = null;
		String w = ancVisitDue.visitdate();
		assertEquals(w,s);
	}
	
	@Test
	public void anmidTest() {
		String s = null;
		String w = ancVisitDue.anmid();
		assertEquals(w,s);
	}

}
