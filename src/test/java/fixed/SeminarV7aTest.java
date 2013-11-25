package fixed;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarV7aTest {

	private static final double DELTA = 0.001;

	private static final int DEFAULT_NET_PRICE = 500;

	@Test
	public void test_a_tax_free_seminar_should_return_a_gross_price_without_tax() {
		final Seminar seminar = createSeminar();
		seminar.setTaxFree(true);
		assertEquals(DEFAULT_NET_PRICE, seminar.grossPrice(), DELTA);
	}

	@Test
	public void test_a_not_tax_free_seminar_should_return_gross_price_with_correct_tax() {
		final Seminar seminar = createSeminar();
		seminar.setTaxFree(false);
		assertEquals(DEFAULT_NET_PRICE * Seminar.TAX_RATE, seminar.grossPrice(), DELTA);
	}

	@Test
	public void test_a_3letter_seminar_should_return_a_gross_price_with_discount() {
		final Seminar seminar = createSeminar();
		seminar.setName("OOP");
		assertEquals(DEFAULT_NET_PRICE - DEFAULT_NET_PRICE * Seminar.THREE_LETTER_DISCOUNT_RATE / 100, seminar.grossPrice(), DELTA);
	}

	@Test
	public void test_a_more_letters_seminar_should_return_a_net_price_without_discount() {
		final Seminar seminar = createSeminar();
		seminar.setName("OOP");
		seminar.setTaxFree(false);
		assertEquals((DEFAULT_NET_PRICE - DEFAULT_NET_PRICE * Seminar.THREE_LETTER_DISCOUNT_RATE / 100) * Seminar.TAX_RATE, seminar.grossPrice(), DELTA);
	}

	private static Seminar createSeminar() {
		return new Seminar("Object Oriented Programming", DEFAULT_NET_PRICE, true);
	}

	// Defekt-Lokalisierung verbessern
}
