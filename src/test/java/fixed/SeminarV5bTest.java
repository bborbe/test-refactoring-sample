package fixed;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarV5bTest {

	@Test
	public void test_a_tax_free_seminar_should_return_a_gross_price_without_tax() {
		final Seminar seminar = createSeminar();
		assertEquals(500, seminar.grossPrice(), 0.001);
	}

	@Test
	public void test_a_not_tax_free_seminar_should_return_gross_price_with_correct_tax() {
		final Seminar seminar = createSeminar();
		seminar.setTaxFree(false);
		assertEquals(595, seminar.grossPrice(), 0.001);
	}

	@Test
	public void test_a_3letter_seminar_should_return_a_gross_price_with_discount() {
		final Seminar seminar = createSeminar();
		seminar.setName("OOP");
		assertEquals(475, seminar.grossPrice(), 0.001);
	}

	@Test
	public void test_a_more_letters_seminar_should_return_a_net_price_without_discount() {
		final Seminar seminar = createSeminar();
		seminar.setName("OOP");
		seminar.setTaxFree(false);
		assertEquals(565.25, seminar.grossPrice(), 0.001);
	}

	private static Seminar createSeminar() {
		return new Seminar("Object Oriented Programming", 500, true);
	}

}
