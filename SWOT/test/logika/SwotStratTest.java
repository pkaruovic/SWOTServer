package logika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwotStratTest {
	private SwotStrat s;

	@Before
	public void setUp() throws Exception {
		s = new SwotStrat("swot", 1, 2);
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testPonderOk() {
		s.setPonder(0);
		assertEquals(0, s.getPonder(), 0);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testPonderNijeOk() {
		s.setPonder(-1);
	}

	@Test
	public void testAtraktivnostOk() {
		s.setAtraktivnost(1);
		assertEquals(1, s.getAtraktivnost());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testAtraktivnostNijeOk() {
		s.setAtraktivnost(10);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testAtraktivnostNijeOk2() {
		s.setAtraktivnost(-10);
	}

	@Test
	public void testNazivOk() {
		s.setNaziv("naziv");
		assertEquals("naziv", s.getNaziv());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testNazivNijeOk() {
		s.setNaziv("");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testNazivNijeOk2() {
		s.setNaziv(null);
	}

}
