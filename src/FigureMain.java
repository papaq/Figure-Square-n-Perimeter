import FigureController.FigureController;
import FigureView.FigureView;

public final class FigureMain {

    public static void main(String[] args) {

        FigureView theView = new FigureView();
        FigureController theController = new FigureController(theView);

        theView.setVisible(true);
    }
}
