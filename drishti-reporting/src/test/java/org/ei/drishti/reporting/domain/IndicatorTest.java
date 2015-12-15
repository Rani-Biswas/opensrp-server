package org.ei.drishti.reporting.domain;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IndicatorTest {
	
	private Indicator indicator;
	
	@Before
	public void setUp(){
		indicator = new Indicator(null, null);	
	}
	
	@Test
	public void idtest() {
		Integer s = null;
		Integer w = indicator.id();
		assertEquals(w,s);
	}
	
	@Test
	public void indicatortest() {
		String s = null;
		String w = indicator.indicator();
		assertEquals(w,s);
	}

}
