package FigureView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FigureView extends JFrame{

    private JComboBox<String> comboBoxFigure = new JComboBox<>();
    private JTextField a = new JTextField(5);
    private JTextField b = new JTextField(5);
    private JTextField c = new JTextField(5);
    private JTextField d = new JTextField(5);
    private JLabel p = new JLabel();
    private JLabel s = new JLabel();

    private JButton buttonVerify = new JButton("Verify");

    public FigureView() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setSize(200,250);
        this.setMinimumSize(new Dimension(200, 250));
        this.setTitle("SP");
        this.setLocationRelativeTo(null);  // to center the app

        setComboItemListener();
        comboBoxFigure.addItem("triangle");
        comboBoxFigure.addItem("square");

        JPanel inputs = new JPanel();
        inputs.setBackground(new Color(222, 255, 235));

        inputs.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.fill = GridBagConstraints.NONE;

        gbc.ipadx = 10;
        inputs.add(new JLabel("Choose figure"), gbc);
        gbc.gridx++;
        inputs.add(comboBoxFigure, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 10;
        inputs.add(new JLabel("a = "), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("b = "), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("c = "), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("d = "), gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputs.add(a, gbc);
        gbc.gridy++;
        inputs.add(b, gbc);
        gbc.gridy++;
        inputs.add(c, gbc);
        gbc.gridy++;
        inputs.add(d, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputs.add(buttonVerify, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 10;
        inputs.add(new JLabel("Perimeter = "), gbc);
        gbc.gridy++;
        inputs.add(new JLabel("Square = "), gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        inputs.add(s, gbc);
        gbc.gridy--;
        inputs.add(p, gbc);

        this.add(inputs);

    }

    private void setComboItemListener() {

        comboBoxFigure.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (comboBoxFigure.getSelectedItem().toString().toLowerCase().equals("triangle")) {
                    d.setEditable(false);
                }
                else {
                    d.setEditable(true);
                }
            }
        });
    }

    public String getA() {

        return a.getText();
    }

    public String getB() {

        return b.getText();
    }

    public String getC() {

        return c.getText();
    }

    public String getD() {

        return d.getText();
    }

    public String getComboSelected() {

        return comboBoxFigure.getSelectedItem().toString();
    }

    public void setP(String str) {

        p.setText(str.length() <=5 ? str : str.substring(0, 5));
    }

    public void setS(String str) {

        s.setText(str.length() <=5 ? str : str.substring(0, 5));
    }

    public void setActionButtonVerify(ActionListener listener) {

        buttonVerify.addActionListener(listener);
    }

    public void showErrorMessage(String message) {

        JOptionPane.showMessageDialog(this, message,"Error!", 0);
    }
}
