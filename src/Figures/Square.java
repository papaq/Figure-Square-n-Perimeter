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

        return a*a;
    }

    @Override
    protected boolean valid() {

        if (a <= 0 || b <= 0 || c <= 0 || d <= 0)
            return false;

        if ( Double.compare(a, b) != 0
                || Double.compare(b, c) != 0
                || Double.compare(c, d) != 0)
            return false;

        return true;
    }

    @Override
    public Square clone() throws CloneNotSupportedException {

        return (Square) super.clone();
    }


}
