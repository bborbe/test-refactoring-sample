package org;

public class Seminar {

	public final static float TAX_RATE = (float) 1.19;

	public final static int THREE_LETTER_DISCOUNT_RATE = 5;

	private float netPrice;

	private boolean taxFree;

	private String name;

	public Seminar(final String name, final float netPrice, final boolean taxFree) {
		this.name = name;
		this.netPrice = netPrice;
		this.taxFree = taxFree;
	}

	public void setNetPrice(final float netPrice) {
		this.netPrice = netPrice;
	}

	public void setTaxFree(final boolean taxFree) {
		this.taxFree = taxFree;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public float grossPrice() {
		return netPrice() * taxRate();
	}

	public float netPrice() {
		return netPrice - discount();
	}

	public float taxRate() {
		return taxFree ? 1 : TAX_RATE / 100;
	}

	public float discount() {
		return netPrice * discountRate() / 100;
	}

	public float discountRate() {
		return isDiscountGranted() ? THREE_LETTER_DISCOUNT_RATE : 0;
	}

	public boolean isDiscountGranted() {
		return name.length() < 3;
	}

}
