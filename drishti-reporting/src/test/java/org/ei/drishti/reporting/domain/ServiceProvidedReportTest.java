package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ServiceProvidedReportTest {
	
	private ServiceProvidedReport serviceProvidedReport;
	
	@Before 
	public void setUp(){
		serviceProvidedReport = new ServiceProvidedReport();
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = serviceProvidedReport.id();
		assertEquals(w,s);
	}
	
	@Test
	public void anmIdentifierTest(){
		String s = null;
		String w = serviceProvidedReport.anmIdentifier();
		assertEquals(w,s);
	}
	
	@Test
	public void typeTest(){
		String s = null;
		String w = serviceProvidedReport.type();
		assertEquals(w,s);
	}
	
	@Test
	public void indicatorTest(){
		String s = null;
		String w = serviceProvidedReport.indicator();
		assertEquals(w,s);
	}
			
	@Test
	public void villageTest(){
		String s = null;
		String w = serviceProvidedReport.village();
		assertEquals(w,s);
	}
	
	@Test
	public void subCenterTest(){
		String s = null;
		String w = serviceProvidedReport.subCenter();
		assertEquals(w,s);
	}
	
	@Test
	public void phcTest(){
		String s = null;
		String w = serviceProvidedReport.phc();
		assertEquals(w,s);
	}
	
	@Test
	public void talukaTest(){
		String s = null;
		String w = serviceProvidedReport.taluka();
		assertEquals(w,s);
	}
	
	@Test
	public void districtTest(){
		String s = null;
		String w = serviceProvidedReport.district();
		assertEquals(w,s);
	}
	
	@Test
	public void stateTest(){
		String s = null;
		String w = serviceProvidedReport.state();
		assertEquals(w,s);
	}
		
}
