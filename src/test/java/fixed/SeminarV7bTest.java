package fixed;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Test;

public class SeminarV7bTest {

	private static final double DELTA = 0.001;

	@Test
	public void test_gross_price() {
		final float netPrice = 100;
		final float taxRate = 2;

		final Seminar seminar = createSeminar("netPrice", "taxRate");
		EasyMock.expect(seminar.netPrice()).andReturn(netPrice);
		EasyMock.expect(seminar.taxRate()).andReturn(taxRate);
		EasyMock.replay(seminar);

		assertEquals(netPrice * taxRate, seminar.grossPrice(), DELTA);
	}

	@Test
	public void test_netprice() {
		final float netPrice = 100;
		final float discount = 40;

		final Seminar seminar = createSeminar("discount");
		EasyMock.expect(seminar.discount()).andReturn(discount);
		EasyMock.replay(seminar);
		seminar.setNetPrice(netPrice);

		assertEquals(netPrice - discount, seminar.netPrice(), DELTA);
	}

	@Test
	public void test_discount() {
		final float discountRate = 123;
		final float netPrice = 400;

		final Seminar seminar = createSeminar("discountRate");
		EasyMock.expect(seminar.discount()).andReturn(discountRate);
		EasyMock.replay(seminar);
		seminar.setNetPrice(netPrice);

		assertEquals(netPrice * discountRate / 100, seminar.discount(), DELTA);
	}

	@Test
	public void test_discountRate_with() {
		final boolean isDiscountGranted = true;

		final Seminar seminar = createSeminar("isDiscountGranted");
		EasyMock.expect(seminar.isDiscountGranted()).andReturn(isDiscountGranted);
		EasyMock.replay(seminar);

		assertEquals(Seminar.THREE_LETTER_DISCOUNT_RATE, seminar.discountRate(), DELTA);
	}

	@Test
	public void test_discountRate_without() {
		final boolean isDiscountGranted = false;

		final Seminar seminar = createSeminar("isDiscountGranted");
		EasyMock.expect(seminar.isDiscountGranted()).andReturn(isDiscountGranted);
		EasyMock.replay(seminar);

		assertEquals(0, seminar.discountRate(), DELTA);
	}

	@Test
	public void test_isDiscountGranted_true() {
		final Seminar seminar = createSeminar();
		seminar.setName("123");
		assertEquals(true, seminar.isDiscountGranted());
	}

	@Test
	public void test_isDiscountGranted_false() {
		final Seminar seminar = createSeminar();
		seminar.setName("1234");
		assertEquals(false, seminar.isDiscountGranted());
	}

	private Seminar createSeminar(final String... methods) {
		final IMockBuilder<Seminar> builder = EasyMock.createMockBuilder(Seminar.class);
		builder.addMockedMethods(methods);
		return builder.createMock();
	}
}
