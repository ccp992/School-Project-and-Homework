
public class Term {
	private double coefficient;
	private int exponent;

	public Term() {
		// TODO Auto-generated constructor stub
		this.coefficient = 0.0d;
		this.exponent = 0;
	}
	public void setCoefficient(double coef) {
		this.coefficient = coef;
	}
	public double getCoefficient() {
		return this.coefficient;
	}
	public void setExponent(int expon) {
		this.exponent = expon;
	}
	public int getExponent() {
		return this.exponent;
	}
	public String toString() {
		String temp = "";
		temp = Double.toString(coefficient) + " " + Integer.toString(exponent);
		return temp;
	}
}
