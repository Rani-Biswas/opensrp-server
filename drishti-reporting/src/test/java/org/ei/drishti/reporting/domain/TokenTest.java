package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TokenTest {
	
	private Token token;
	
	@Before
	public void setUp(){
		String name = null;
		String value = null;
		token = new Token(name, value);
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = token.id();
		assertEquals(w,s);
	}
	
	@Test
	public void nameTest(){
		String s = null;
		String w = token.name();
		assertEquals(w,s);
	}
	
	@Test
	public void valueTest(){
		String s = null;
		String w = token.value();
		assertEquals(w,s);
	}
	
	@Test
	public void withValueTest(){
		String s = null;
		String w = token.value();
		assertEquals(w,s);
	}

}
