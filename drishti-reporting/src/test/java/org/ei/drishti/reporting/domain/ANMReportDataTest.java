package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ANMReportDataTest {
	
private ANMReportData anmReportData;
	
	@Before
	public void setUp(){
		ANM anm = null;
		Indicator indicator = null;
		Date date = null;
		String externalId = null;
		anmReportData = new ANMReportData(anm, externalId, indicator, date);
	}
	
	@Test
	public void indicatorTest(){
		String s = null;
		Indicator w = anmReportData.indicator();
		assertEquals(w,s);
	}
	
	@Test
	public void dateTest(){
		String s = null;
		Date w = anmReportData.date();
		assertEquals(w,s);
	}
	
	@Test
	public void externalIdTest(){
		String s = null;
		String w = anmReportData.externalId();
		assertEquals(w,s);
	}

}
