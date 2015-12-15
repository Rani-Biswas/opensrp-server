package org.ei.drishti.dto;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
public class MonthSummaryDatumTest {
 
	private MonthSummaryDatum monthsummary;
	
	@Before
	public void setUp(){
		monthsummary = new MonthSummaryDatum();
	}
	
	@Test
	public void monthTest(){
		String w= monthsummary.month();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void yearTest(){
		String w= monthsummary.year();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void currentprogressTest(){
		String w= monthsummary.currentProgress();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void aggregatedProgressTest(){
		String w= monthsummary.aggregatedProgress();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void externalIDsTest(){
		List<String> w= monthsummary.externalIDs();
		String a=null;
		assertEquals(w,a);
	}
	
}
