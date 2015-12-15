package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ANMVillagesTest {
	
	private ANMVillages anmVillages;
	
	@Before
	public void setUp(){
		Integer id = null;
		String villages = null;
		String user_role = null;
		String user_id = null;
		String phone_number = null;
		String name = null;
		Integer country = null;
		Integer county = null;
		Integer district = null;
		Integer subdistrict = null;
		Integer subcenter = null;
		Integer hospital = null;
		anmVillages = new ANMVillages(id, villages, user_role, user_id, name, phone_number,
	            country, county, district, subdistrict, subcenter, hospital);
	}
	
	@Test
	public void idTest(){
		String s = null;
		Integer w = anmVillages.id();
		assertEquals(w,s);
	}
	
	@Test
	public void user_roleTest(){
		String s = null;
		String w = anmVillages.user_role();
		assertEquals(w,s);
	}
	
	@Test
	public void user_idTest(){
		String s = null;
		String w = anmVillages.user_id();
		assertEquals(w,s);
	}
	
	@Test
	public void villagesTest(){
		String s = null;
		String w = anmVillages.villages();
		assertEquals(w,s);
	}
	
	@Test
	public void nameTest(){
		String s = null;
		String w = anmVillages.name();
		assertEquals(w,s);
	}
	
	@Test
	public void phone_numberTest(){
		String s = null;
		String w = anmVillages.phone_number();
		assertEquals(w,s);
		}
	
	@Test
	public void countryTest(){
		String s = null;
		Integer w = anmVillages.county();
		assertEquals(w,s);
	}
	
	@Test
	public void countyTest(){
		String s = null;
		Integer w = anmVillages.county();
		assertEquals(w,s);
	}
	
	@Test
	public void districtTest(){
		String s = null;
		Integer w = anmVillages.district();
		assertEquals(w,s);
	}
	
	@Test
	public void subdistrictTest(){
		String s = null;
		Integer w = anmVillages.subdistrict();
		assertEquals(w,s);
	}
	
	@Test
	public void subcenterTest(){
		String s = null;
		Integer w = anmVillages.subcenter();
		assertEquals(w,s);
	}
	
	@Test
	public void hospitalTest(){
		String s = null;
		Integer w = anmVillages.hospital();
		assertEquals(w,s);
	}

}
