package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class APPReportTest {
	
private APPReport appReport;
	
	@Before
	public void setUp(){
		String visitentityid = null;
		String entityidec = null;
		String patient_name = null;
		String anm_id = null;
		String activity = null;
		String indicator = null;
		Integer indicator_count = null;
		String date = null;
		String location = null;
		Integer child_weight = null;
		String other_date = null;
		String visit_location = null;
		appReport = new APPReport(visitentityid, entityidec, patient_name, anm_id, activity, 
				indicator, indicator_count, date, location, child_weight, other_date, 
				visit_location);
	}
	
	@Test
	public void idTest(){
		String s = null;
		Integer w = appReport.id();
		assertEquals(w,s);
	}
	
	@Test
	public void visitentityidTest(){
		String s = null;
		String w = appReport.visitentityid();
		assertEquals(w,s);
	}
	
	@Test
	public void entityidecTest(){
		String s = null;
		String w = appReport.entityidec();
		assertEquals(w,s);
	}
	
	@Test
	public void patient_nameTest(){
		String s = null;
		String w = appReport.patient_name();
		assertEquals(w,s);
	}
	
	@Test
	public void anm_idTest(){
		String s = null;
		String w = appReport.anm_id();
		assertEquals(w,s);
	}
	
	@Test
	public void activityTest(){
		String s = null;
		String w = appReport.activity();
		assertEquals(w,s);
	}
	
	@Test
	public void indicatorTest(){
		String s = null;
		String w = appReport.indicator();
		assertEquals(w,s);
	}
	
	@Test
	public void indicator_countTest(){
		String s = null;
		Integer w = appReport.indicator_count();
		assertEquals(w,s);
	}
	
	@Test
	public void dateTest(){
		String s = null;
		String w = appReport.date();
		assertEquals(w,s);
	}
	
	@Test
	public void locationTest(){
		String s = null;
		String w = appReport.location();
		assertEquals(w,s);
	}
	
	@Test
	public void child_weightTest(){
		String s = null;
		Integer w = appReport.child_weight();
		assertEquals(w,s);
	}
	
	@Test
	public void other_dateTest(){
		String s = null;
		String w = appReport.other_date();
		assertEquals(w,s);
	}
	
	@Test
	public void visit_locationTest(){
		String s = null;
		String w = appReport.visit_location();
		assertEquals(w,s);
	}

}
