package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HealthCenterTest {
	
private HealthCenter healthCenter;
	
	@Before
	public void setUp(){
		Integer id = 0;
		String hospital_name = null;
		String hospital_type = null;
		String hospital_address = null;
		String parent_hospital = null;
		String villages = null;
		Integer country_name = null;
		Integer county_name = null;
		Integer district_name = null;
		Integer subdistrict_name = null;
		healthCenter = new HealthCenter(id, hospital_name, hospital_type, hospital_address, parent_hospital, villages,
	    		country_name, county_name, district_name, subdistrict_name);
	}
	
	@Test
	public void idTest(){
		Integer s = 0;
		Integer w = healthCenter.id();
		assertEquals(w,s);
	}
	
	@Test
	public void hospital_nameTest(){
		String s = null;
		String w = healthCenter.hospital_name();
		assertEquals(w,s);
	}
	
	@Test
	public void hospital_typeTest(){
		String s = null;
		String w = healthCenter.hospital_type();
		assertEquals(w,s);
	}
	
	@Test
	public void hospital_addressTest(){
		String s = null;
		String w = healthCenter.hospital_address();
		assertEquals(w,s);
	}
	
	@Test
	public void parent_hospitalTest(){
		String s = null;
		String w = healthCenter.parent_hospital();
		assertEquals(w,s);
	}
	
	@Test
	public void villagesTest(){
		String s = null;
		String w = healthCenter.villages();
		assertEquals(w,s);
	}
	
	@Test
	public void country_nameTest(){
		String s = null;
		Integer w = healthCenter.country_name();
		assertEquals(w,s);
	}
	
	@Test
	public void county_nameTest(){
		String s = null;
		Integer w = healthCenter.county_name();
		assertEquals(w,s);
	}
	
	@Test
	public void district_nameTest(){
		String s = null;
		Integer w = healthCenter.district_name();
		assertEquals(w,s);
	}
	
	@Test
	public void subdistrict_nameTest(){
		String s = null;
		Integer w = healthCenter.subdistrict_name();
		assertEquals(w,s);
	}

}
