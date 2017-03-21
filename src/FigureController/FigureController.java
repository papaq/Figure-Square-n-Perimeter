package FigureController;

import FigureView.FigureView;
import Figures.Figure;
import Figures.Square;
import Figures.Triangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigureController {

    FigureView view;

    public FigureController(FigureView view) {

        this.view = view;
        view.setActionButtonVerify(new VerifyFigure());
    }


    private class VerifyFigure implements ActionListener {

        double a, b, c, d;
        boolean three;


        @Override
        public void actionPerformed(ActionEvent e) {

            three = view.getComboSelected().toLowerCase().equals("triangle");

            try {

                getValuesFromTextFields();
            }
            catch (NumberFormatException ex) {

                view.showErrorMessage("Check sides' values!");
                return;
            }

            Figure figure;
            try {

                figure = three ? new Triangle(a, b, c) : new Square(a, b, c, d);
            }
            catch (IllegalArgumentException ex) {

                view.showErrorMessage("Such figure cannot exist!");
                return;
            }

            view.setP(String.valueOf(figure.getPerimeter()));
            view.setS(String.valueOf(figure.getSquare()));
        }

        private void getValuesFromTextFields() throws NumberFormatException{

            a = Double.parseDouble(view.getA());
            b = Double.parseDouble(view.getB());
            c = Double.parseDouble(view.getC());

            if (!three)
                d = Double.parseDouble(view.getD());
        }
    }

}
