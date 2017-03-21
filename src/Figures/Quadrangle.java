package Figures;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Quadrangle extends Figure {

    double a, b, c, d;
    private double p;
    double s;

    @Override
    public double getPerimeter() {
        return p;
    }

    public double getSquare() {
        return s;
    }

    Quadrangle(double a, double b, double c, double d)
            throws IllegalArgumentException {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        if (!valid())
            throw new IllegalArgumentException();

        p = perimeter();
        s = square();
    }

    @Override
    protected double perimeter() {

        return a+b+c+d;
    }

    @Override
    protected boolean valid() {

        if (a <= 0 || b <= 0 || c <= 0 || d <= 0)
            return false;

        if (a+b+d <= c || a+c+b <= b || b+c+d <= a || a+b+c <= d)
            return false;

        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Quadrangle with sides: a=").append(a)
                .append(", b=").append(b)
                .append(", c=").append(c)
                .append(", d=").append(d);

        return sb.toString();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(29, 91).
                append(a)
                .append(b)
                .append(c)
                .append(d)
                .append(s)
                .append(p)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Quadrangle other = (Quadrangle)obj;

        return new EqualsBuilder()
                .append(a, other.a)
                .append(b, other.b)
                .append(c, other.c)
                .append(d, other.d)
                .isEquals();
    }
}
