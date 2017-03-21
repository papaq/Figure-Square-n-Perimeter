package Figures;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Triangle extends Figure {

    private double a, b, c;
    private double p, s;

    @Override
    public double getPerimeter() { return p; }

    @Override
    public double getSquare() { return s; }

    public Triangle(double a, double b, double c) throws IllegalArgumentException {
        this.a = a;
        this.b = b;
        this.c = c;

        if (!valid())
            throw new IllegalArgumentException();

        this.p = perimeter();
        this.s = square();
    }

    @Override
    protected double perimeter() {

        return a+b+c;
    }

    @Override
    protected double square() {

        double hp = perimeter()/2;
        return Math.sqrt(hp*(hp-a)*(hp-b)*(hp-c));
    }

    @Override
    protected boolean valid() {

        if (a <= 0 || b <= 0 || c <= 0)
            return false;

        if (a+b <= c || a+c <= b || b+c <= a)
            return false;

        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Triangle with sides: a=").append(a)
                .append(", b=").append(b)
                .append(", c=").append(c);

        return sb.toString();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(29, 91).
                append(a)
                .append(b)
                .append(c)
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

        Triangle other = (Triangle)obj;

        return new EqualsBuilder()
                .append(a, other.a)
                .append(b, other.b)
                .append(c, other.c)
                .isEquals();
    }

    @Override
    public Triangle clone() throws CloneNotSupportedException {

        return (Triangle) super.clone();
    }
}
