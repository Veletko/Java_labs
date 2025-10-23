package Task3;

public class ComplexNumber {
    private double real; // Вещественная часть
    private double imaginary; // Мнимая часть

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(
                this.real + other.real,
                this.imaginary + other.imaginary
        );
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(
                this.real - other.real,
                this.imaginary - other.imaginary
        );
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = this.real * other.real - this.imaginary * other.imaginary;
        double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof ComplexNumber)) return false;
        ComplexNumber other = (ComplexNumber) obj;

        final double EPSILON = 1e-10;
        return Math.abs(this.real - other.real) < EPSILON &&
                Math.abs(this.imaginary - other.imaginary) < EPSILON;
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}
