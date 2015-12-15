package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ANCRegisterDTOTest {
	
	private ANCRegisterDTO ancRegisterDTO;
	
	@Before
	public void setUp(){
		ancRegisterDTO = new ANCRegisterDTO(null);
	}
	
	@Test
	public void equalsTest(){
		Object o = false;
		boolean w=ancRegisterDTO.equals(o);
		boolean a=false;
		assertEquals(w,a);
	}
	
	@Test
	public void hashCodeTest(){
		ancRegisterDTO.hashCode();
	}
	
	@Test
	public void toStringTest(){
		ancRegisterDTO.toString();
	}

}
