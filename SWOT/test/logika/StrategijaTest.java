package logika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StrategijaTest {
	private Strategija s;

	@Before
	public void setUp() throws Exception {
		s = new Strategija("strategija");
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testDodajSnaguOk() {
		SwotStrat snaga = new SwotStrat("snaga", 0.5, 1);
		s.dodajSnagu(snaga, snaga.getAtraktivnost());
		
		assertEquals(s.getSnage().get(0), snaga);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajSnaguNijeOk() {
		SwotStrat snaga = null;
		
		s.dodajSnagu(snaga, 0);
		
		assertEquals(s.getSnage().get(0), snaga);
	}
	
	@Test
	public void testDodajSlabostOk() {
		SwotStrat slabost = new SwotStrat("slabost", 0.5, 1);
		s.dodajSlabost(slabost, slabost.getAtraktivnost());
		
		assertEquals(s.getSlabosti().get(0), slabost);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajSlabostNijeOk() {
		SwotStrat slabost = null;
		
		s.dodajSlabost(slabost, 0);
		
		assertEquals(s.getSlabosti().get(0), slabost);
	}
	
	@Test
	public void testDodajSansuOk() {
		SwotStrat sansa = new SwotStrat("sansa", 0.5, 1);
		s.dodajSansu(sansa, sansa.getAtraktivnost());
		
		assertEquals(s.getSanse().get(0), sansa);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajSansuNijeOk() {
		SwotStrat sansa = null;
		
		s.dodajSansu(sansa, 0);
		
		assertEquals(s.getSnage().get(0), sansa);
	}
	
	@Test
	public void testDodajPretnjuOk() {
		SwotStrat pretnja = new SwotStrat("pretnja", 0.5, 1);
		s.dodajPretnju(pretnja, pretnja.getAtraktivnost());
		
		assertEquals(s.getPretnje().get(0), pretnja);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajPretnjuNijeOk() {
		SwotStrat pretnja = null;
		
		s.dodajPretnju(pretnja, 0);
		
		assertEquals(s.getPretnje().get(0), pretnja);
	}
	
	@Test
	public void testEqualsSveOk() {
		Strategija strat = new Strategija("strategija");
		
		if(!s.equals(strat))
			fail();
	}
	
	@Test
	public void testEqualsNijeSveOk() {
		Strategija strat = new Strategija("test");
		
		if(s.equals(strat))
			fail();
	}
	
	@Test
	public void testEqualsNijeSveOk2() {
		if(s.equals(null))
			fail();
	}
	
	@Test
	public void testEqualsNijeSveOk3() {
		if(s.equals("test"))
			fail();
	}
	
	

}
