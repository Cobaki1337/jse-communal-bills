package by.gsu.course_project.gui;

import by.gsu.course_project.Converter;
import by.gsu.course_project.beans.RepayClient;
import by.gsu.course_project.database.DBMethods;

import javax.swing.*;
import java.awt.*;

import static by.gsu.course_project.gui.GuiConstants.*;

public class AddPayMenu extends JFrame {
    private JLabel resultHead1 = new JLabel(REMAINDER);
    private JLabel resultHead2 = new JLabel(EMPTY_FIELD);
    private JLabel resultHead3 = new JLabel(BYN);
    private JLabel payment = new JLabel(PAYMENT);
    private JTextField payField = new JTextField();
    private JButton payButton = new JButton(PAY_IN_ADDITION);
    private int enteringPay;
    private RepayClient client;

    public AddPayMenu(RepayClient client){
        this.client = client;
    }

    public void construct() {
        Container container = this.getContentPane();
        setTitle(REPAY_MENU);
        setSize(SIZE_550_WIDTH, SIZE_200_HEIGHT);
        setLocation(ADD_PAY_MENU_COORDINATE_X, ADD_PAY_MENU_COORDINATE_Y);
        setResizable(false);
        setVisible(true);
        container.setLayout(new GridLayout(ROWS_OR_COLS_2, ROWS_OR_COLS_3));
        container.add(resultHead1);
        resultHead2.setText(Converter.convertIn(client.getSum()) + BYN);
        container.add(resultHead2);
        container.add(resultHead3);
        container.add(payment);
        container.add(payField);
        container.add(payButton);
        payButton.addActionListener(e -> {
            try {
                enteringPay = Converter.convertOut(Double.parseDouble(payField.getText()));
                if (enteringPay <= 0) {
                    throw new NumberFormatException();
                }else {
                    DBMethods.repaymentForBill(client.getName(), enteringPay, client.getSum());
                }
                setVisible(false);
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, ENTER_CORRECT_AMOUNT);
            }
        });
    }
}
