package Figures;

public class Square extends Quadrangle implements Cloneable {

    @Override
    public double getSquare() {

        return s;
    }

    public Square(double a, double b, double c, double d) {

        super(a, b, c, d);
    }

    @Override
    protected double square() {

        return a*b*c*d;
    }

    @Override
    protected boolean valid() {

        if (a > 0 || b > 0 || c > 0 || d > 0)
            return false;

        if (a != b || a != c || a != d)
            return false;

        return true;
    }

    @Override
    public Square clone() throws CloneNotSupportedException {

        return (Square) super.clone();
    }


}
