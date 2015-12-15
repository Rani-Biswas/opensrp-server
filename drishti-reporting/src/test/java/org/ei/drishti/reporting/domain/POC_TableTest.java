package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

public class POC_TableTest {
	
	private POC_Table poc_Table;
	
	@Before
	public void setUp(){
		String visitentityid = null;
		String entityidec = null;
		String anmid = null;
		String level = null;
		String clientversion = null;
		String serverversion = null;
		String visittype = null;
		String phc = null;
		String pending = null;
		String docid = null;
		Timestamp timestamp = null;
		String wifename = null;
		poc_Table = new POC_Table(visitentityid, entityidec, anmid, level, clientversion,
				serverversion, visittype, phc, pending, docid, timestamp, wifename);
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = poc_Table.id();
		assertEquals(w,s);
	}
	
	@Test
	public void visitentityidTest(){
		String s = null;
		String w = poc_Table.visitentityid();
		assertEquals(w,s);
	}
	
	@Test
	public void entityidecTest(){
		String s = null;
		String w = poc_Table.entityidec();
		assertEquals(w,s);
	}
	
	@Test
	public void anmidTest(){
		String s = null;
		String w = poc_Table.anmid();
		assertEquals(w,s);
	}
	
	@Test
	public void levelTest(){
		String s = null;
		String w = poc_Table.level();
		assertEquals(w,s);
	}
	
	@Test
	public void clientversionTest(){
		String s = null;
		String w = poc_Table.clientversion();
		assertEquals(w,s);
	}
	
	@Test
	public void serverversionTest(){
		String s = null;
		String w = poc_Table.serverversion();
		assertEquals(w,s);
	}
	
	@Test
	public void visittypeTest(){
		String s = null;
		String w = poc_Table.visittype();
		assertEquals(w,s);
	}
	
	@Test
	public void phcTest(){
		String s = null;
		String w = poc_Table.phc();
		assertEquals(w,s);
	}
	
	@Test
	public void pendingTest(){
		String s = null;
		String w = poc_Table.pending();
		assertEquals(w,s);
	}
	
	@Test
	public void docidTest(){
		String s = null;
		String w = poc_Table.docid();
		assertEquals(w,s);
	}
	
	@Test
	public void timestampTest(){
		String s = null;
		Timestamp w = poc_Table.timestamp();
		assertEquals(w,s);
	}
	
	@Test
	public void wifenameTest(){
		String s = null;
		String w = poc_Table.wifename();
		assertEquals(w,s);
	}

}
