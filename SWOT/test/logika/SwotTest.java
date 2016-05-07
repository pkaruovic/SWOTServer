package logika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwotTest {
	private Swot s;
	@Before
	public void setUp() throws Exception {
		s = new Swot("swot", 1);
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testSetNazivOk() {
		s.setNaziv("naziv");
		assertEquals("naziv", s.getNaziv());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivNijeOk() {
		s.setNaziv("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivNijeOk2() {
		s.setNaziv(null);
	}
	
	@Test
	public void testSetPonderOk() {
		s.setPonder(0);
		assertEquals(0, s.getPonder(), 0);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPonderNijeOk() {
		s.setPonder(-1);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPonderNijeOk2() {
		s.setPonder(2);
	}

	@Test
	public void testEquals() {
		if(!s.equals(new Swot("swot", 1)))
			fail();
	}
	
	@Test
	public void testEquals2() {
		if(s.equals(new Swot("greska", 1)))
			fail();
	}
	
	@Test
	public void testEquals3() {
		if(s.equals(new Swot("swot", 0)))
			fail();
	}
	
	@Test
	public void testEquals4() {
		if(s.equals(new Swot("greska", 0)))
			fail();
	}
	
	@Test
	public void testEquals5() {
		if(s.equals(null))
			fail();
	}
	
	@Test
	public void testEquals6() {
		if(s.equals("test"))
			fail();
	}
}
