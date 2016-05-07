package logika;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogikaTest {
	Logika l;
	@Before
	public void setUp() throws Exception {
		l = new Logika();
	}

	@After
	public void tearDown() throws Exception {
		l = null;
	}

	@Test
	public void testSetStrategijePrazna() {
		ArrayList<Strategija> nova = new ArrayList<Strategija>();
		l.setStrategije(nova);
		assertTrue(l.getStrategije().isEmpty());
	}
	@Test
	public void testSetStrategijeOk() {
		ArrayList<Strategija> nova = new ArrayList<Strategija>();
		nova.add(new Strategija());
		l.setStrategije(nova);
		assertFalse(l.getStrategije().isEmpty());
	}

	@Test
	public void testSetListaSnagePrazna() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		l.setListaSnage(nova);
		assertTrue(l.getListaSnage().isEmpty());
	}
	@Test
	public void testSetListaSnageOk() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		nova.add(new Swot("naziv", 0));
		l.setListaSnage(nova);
		assertFalse(l.getListaSnage().isEmpty());
	}
	@Test
	public void testSetListaSlabostiPrazna() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		l.setListaSlabosti(nova);
		assertTrue(l.getListaSlabosti().isEmpty());
	}
	@Test
	public void testSetListaSlabostiOk() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		nova.add(new Swot("naziv", 0));
		l.setListaSlabosti(nova);
		assertFalse(l.getListaSlabosti().isEmpty());
	}
	@Test
	public void testSetListaSansePrazna() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		l.setListaSanse(nova);
		assertTrue(l.getListaSanse().isEmpty());
	}
	@Test
	public void testSetListaSanseOk() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		nova.add(new Swot("naziv", 0));
		l.setListaSanse(nova);
		assertFalse(l.getListaSanse().isEmpty());
	}

	@Test
	public void testSetListaPretnjePrazna() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		l.setListaPretnje(nova);
		assertTrue(l.getListaPretnje().isEmpty());
	}
	@Test
	public void testSetListaPretnjeOk() {
		ArrayList<Swot> nova = new ArrayList<Swot>();
		nova.add(new Swot("naziv", 0));
		l.setListaPretnje(nova);
		assertTrue(l.getListaPretnje().isEmpty());
	}

	@Test
	public void testDodajStrategijuUListu() {
		Strategija nova = new Strategija("naziv");
		l.dodajStrategijuUListu(nova);
		assertTrue(l.getStrategije().contains(nova));
	}

	@Test
	public void testDodajSnaguUListu() {
		Swot nova = new Swot("naziv", 0);
		l.dodajSnaguUListu("naziv", 0);
		assertTrue(l.getListaSnage().contains(nova));
		
	}

	@Test
	public void testDodajSansuUListu() {
		Swot nova = new Swot("naziv", 0);
		l.dodajSansuUListu("naziv", 0);
		assertTrue(l.getListaSanse().contains(nova));
	}

	@Test
	public void testDodajSlabostUListu() {
		Swot nova = new Swot("naziv", 0);
		l.dodajSlabostUListu("naziv", 0);
		assertTrue(l.getListaSlabosti().contains(nova));
	}

	@Test
	public void testDodajPretnjuUListu() {
		Swot nova = new Swot("naziv", 0);
		l.dodajPretnjuUListu("naziv", 0);
		assertTrue(l.getListaPretnje().contains(nova));
	}

	@Test
	public void testVratiPonderSnagaNaziv() {
		fail("Not yet implemented");
	}

	@Test
	public void testVratiPonderSansaNaziv() {
		fail("Not yet implemented");
	}

	@Test
	public void testVratiPonderSlabostNaziv() {
		fail("Not yet implemented");
	}

	@Test
	public void testVratiPonderPretnjaNaziv() {
		fail("Not yet implemented");
	}

}
