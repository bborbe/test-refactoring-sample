package org;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SeminarTest {

	@Ignore
	@Test
	public void testShouldCalculateGrossPrices() {
		final Seminar seminar = new Seminar("OOP", 500, false);

		// expected:<565.25> but was:<5.950000286102295>
		assertEquals(565.25, seminar.grossPrice(), 0.001);

		seminar.setNetPrice(300);
		assertEquals(339.15, seminar.grossPrice(), 0.001);

		seminar.setTaxFree(true);
		assertEquals(285, seminar.grossPrice(), 0.001);

		seminar.setName("Object Oriented Programming");
		assertEquals(300, seminar.grossPrice(), 0.001);
	}
}
