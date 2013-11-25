package fixed;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarV3aTest {

	@Test
	public void testShouldCalculateGrossPrices() {
		final Seminar seminar = new Seminar("Object Oriented Programming", 500, true);

		assertEquals(500, seminar.grossPrice(), 0.001);

		seminar.setName("OOP");
		assertEquals(475, seminar.grossPrice(), 0.001);

		seminar.setTaxFree(false);
		assertEquals(565.25, seminar.grossPrice(), 0.001);
	}

	// Aufspalten der Testmethoden, nur ein Ding pro Test testen
	// Arrange Act Assert: AAA-Pattern
}
