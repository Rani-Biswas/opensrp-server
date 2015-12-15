package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class AnnualTargetTest {
	
private AnnualTarget annualTarget;
	
	@Before
	public void setUp(){
		Date endDate = null;
		Date startDate = null;
		String target = null;
		Integer anmIdentifier = null;
		Integer indicator = null;
		annualTarget = new AnnualTarget(anmIdentifier, indicator, target, startDate, endDate );
	}
	
	@Test
	public void targetTest(){
		String s = null;
		String w = annualTarget.target();
		assertEquals(w,s);
	}

}
