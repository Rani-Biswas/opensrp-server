package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	private Location location;
	
	@Before
	public void setUp(){
		Integer id = 0;
		String village = null;
		String subCenter = null;
		PHC phc = null;
		String taluka = null;
		String district = null;
		String state = null;
		location = new Location(id, village, subCenter, phc, taluka, district, state);
	}
	
	@Test
	public void idTest(){
		Integer s = 0;
		Integer w = location.id();
		assertEquals(w,s);
	}
	
	@Test
	public void villageTest(){
		String s = null;
		String w = location.village();
		assertEquals(w,s);
	}
	
	@Test
	public void subCenterTest(){
		String s = null;
		String w = location.subCenter();
		assertEquals(w,s);
	}
	
	@Test
	public void phcTest(){
		String s = null;
		PHC w = location.phc();
		assertEquals(w,s);
	}
		
}
