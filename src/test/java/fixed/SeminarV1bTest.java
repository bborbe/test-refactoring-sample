package fixed;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarV1bTest {

	@Test
	public void testShouldCalculateGrossPrices() {
		final Seminar seminar = new Seminar("OOP", 500, false);

		assertEquals(565.25, seminar.grossPrice(), 0.001);

		// seminar.setNetPrice(300);
		// assertEquals(339.15, seminar.grossPrice(), 0.001);

		seminar.setTaxFree(true);
		assertEquals(475, seminar.grossPrice(), 0.001);

		seminar.setName("Object Oriented Programming");
		assertEquals(500, seminar.grossPrice(), 0.001);
	}

}
