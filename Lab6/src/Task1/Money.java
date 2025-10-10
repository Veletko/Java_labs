package Task1;

public class Money {
    private long rubls;
    private byte kopeika;

    public Money(long rubls, byte kopeika) {
        this.rubls = rubls;
        this.kopeika = kopeika;
        normalize();
    }

    public long getRubls() {
        return rubls;
    }

    public void setRubls(long rubls) {
        this.rubls = rubls;
    }

    public byte getKopeika() {
        return kopeika;
    }

    public void setKopeika(byte kopeika) {
        this.kopeika = kopeika;
        normalize();
    }

    public void printMoney() {
        System.out.println(rubls + "," + (kopeika < 10 ? "0" + kopeika : kopeika));
    }

    // Нормализация копеек
    private void normalize() {
        if (kopeika >= 100) {
            rubls += kopeika / 100;
            kopeika = (byte) (kopeika % 100);
        }
    }

    // Сложение
    public Money add(Money other) {
        long newRubls = this.rubls + other.rubls;
        byte newKopeika = (byte) (this.kopeika + other.kopeika);
        return new Money(newRubls, newKopeika);
    }

    // Вычитание
    public Money subtract(Money other) {
        long newRubls = this.rubls - other.rubls;
        byte newKopeika = (byte) (this.kopeika - other.kopeika);
        return new Money(newRubls, newKopeika);
    }

    // Умножение на дробное число
    public Money multiply(double factor) {
        double total = (this.rubls + this.kopeika / 100.0) * factor;
        long newRubls = (long) total;
        byte newKopeika = (byte) Math.round((total - newRubls) * 100);
        return new Money(newRubls, newKopeika);
    }

    // Деление на дробное число
    public Money divide(double divisor) {
        double total = (this.rubls + this.kopeika / 100.0) / divisor;
        long newRubls = (long) total;
        byte newKopeika = (byte) Math.round((total - newRubls) * 100);
        return new Money(newRubls, newKopeika);
    }

    // Деление сумм
    public double divide(Money other) {
        double thisTotal = this.rubls + this.kopeika / 100.0;
        double otherTotal = other.rubls + other.kopeika / 100.0;
        return thisTotal / otherTotal;
    }

    // Операции сравнения
    public boolean equals(Money other) {
        return this.rubls == other.rubls && this.kopeika == other.kopeika;
    }

    public boolean greaterThan(Money other) {
        if (this.rubls != other.rubls) {
            return this.rubls > other.rubls;
        }
        return this.kopeika > other.kopeika;
    }

    public boolean lessThan(Money other) {
        if (this.rubls != other.rubls) {
            return this.rubls < other.rubls;
        }
        return this.kopeika < other.kopeika;
    }
}