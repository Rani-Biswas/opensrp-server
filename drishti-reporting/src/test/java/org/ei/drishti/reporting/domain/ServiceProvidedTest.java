/*package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ServiceProvidedTest {
	
	private ServiceProvided serviceProvided;
	
	@Before
	public void setUp(){
		ServiceProvider serviceProvider = null;
		String externalId = null;
		Indicator indicator = null;
		Date date = null;
		Location location = null;
		String dristhiEntityId = null;
		serviceProvided = new ServiceProvided(serviceProvider, externalId, indicator, date,
				location, dristhiEntityId);
	}
	
	@Test
	public void idTest(){
		String s = null;
		String w = serviceProvided.id();
		assertEquals(w,s);
	}
	
	@Test
	public void serviceProviderTypeTest(){
		String s = null;
		String w = serviceProvided.serviceProviderType();
		assertEquals(w,s);
	}
	
	@Test
	public void indicatorTest(){
		String s = null;
		String w = serviceProvided.indicator();
		assertEquals(w,s);
	}
	
	@Test
	public void dateTest(){
		String s = null;
		String w = serviceProvided.date();
		assertEquals(w,s);
	}
	
	@Test
	public void dristhiEntityIdTest(){
		String s = null;
		String w = serviceProvided.dristhiEntityId();
		assertEquals(w,s);
	}
	
	@Test
	public void locationTest(){
		String s = null;
		org.ei.drishti.domain.Location w = serviceProvided.location();
		assertEquals(w,s);
	}

}
*/