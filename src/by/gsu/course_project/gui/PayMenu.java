package by.gsu.course_project.gui;

import by.gsu.course_project.Converter;
import by.gsu.course_project.beans.Bill;
import by.gsu.course_project.beans.NotPaidClient;
import by.gsu.course_project.database.DBMethods;

import javax.swing.*;
import java.awt.*;

import static by.gsu.course_project.beans.BeansConstants.*;
import static by.gsu.course_project.gui.GuiConstants.*;

public class PayMenu extends JFrame{
    private JLabel head1 = new JLabel(SERVANTS_NAME);
    private JLabel head2 = new JLabel(METERS_DATA);
    private JLabel head3 = new JLabel(TARIFF_FOR_1);
    private JLabel head4 = new JLabel(FOR_PAY);
    private JLabel redecorate1 = new JLabel(REDECORATE);
    private JLabel redecorate2 = new JLabel();
    private JLabel redecorate3 = new JLabel();
    private JLabel redecorate4 = new JLabel();
    private JLabel lift1 = new JLabel(LIFT_SERVICE);
    private JLabel lift2 = new JLabel();
    private JLabel lift3 = new JLabel();
    private JLabel lift4 = new JLabel();
    private JLabel additionalElectricity1 = new JLabel(ADDITIONAL_ELECTRICITY);
    private JLabel additionalElectricity2 = new JLabel();
    private JLabel additionalElectricity3 = new JLabel();
    private JLabel additionalElectricity4 = new JLabel();
    private JLabel water1 = new JLabel(WATER);
    private JLabel water2 = new JLabel();
    private JLabel water3 = new JLabel();
    private JLabel water4 = new JLabel();
    private JLabel gas1 = new JLabel(GAS);
    private JLabel gas2 = new JLabel();
    private JLabel gas3 = new JLabel();
    private JLabel gas4 = new JLabel();
    private JLabel electricity1 = new JLabel(ELECTRICITY);
    private JLabel electricity2 = new JLabel();
    private JLabel electricity3 = new JLabel();
    private JLabel electricity4 = new JLabel();
    private JLabel totalSum1 = new JLabel(TOTAL_SUM);
    private JLabel totalSum2 = new JLabel(EMPTY_FIELD);
    private JLabel totalSum3 = new JLabel(EMPTY_FIELD);
    private JLabel totalSum4 = new JLabel();
    private JLabel dash1 = new JLabel(DELIMITER);
    private JLabel dash2 = new JLabel(DELIMITER);
    private JLabel dash3 = new JLabel(DELIMITER);
    private JLabel dash4 = new JLabel(DELIMITER);
    private JLabel payment1 = new JLabel(PAYMENT);
    private JLabel payment2 = new JLabel();
    private JTextField payField = new JTextField();
    private JButton payButton = new JButton(PAY);
    private int enteringPay;
    private Bill bill;
    private NotPaidClient client;

    public PayMenu(Bill bill, NotPaidClient client){
        this.bill = bill;
        this.client = client;
    }

    public void construct() {
        Container container = this.getContentPane();
        setTitle(PAY_MENU);
        setSize(SIZE_615_WIDTH, SIZE_600_HEIGHT);
        setLocation(PAY_MENU_COORDINATE_X, PAY_MENU_COORDINATE_Y);
        setResizable(false);
        setVisible(true);
        container.setLayout(new GridLayout(ROWS_OR_COLS_10, ROWS_OR_COLS_4));
        container.add(head1);
        container.add(head2);
        container.add(head3);
        container.add(head4);
        redecorate2.setText(String.valueOf(client.getArea()) + AREA_MEASURE);
        redecorate3.setText(Converter.convertIn(REDECORATE_TARIFF) + BYN);
        redecorate4.setText(Converter.convertIn(bill.getRedecorate()) + BYN);
        container.add(redecorate1);
        container.add(redecorate2);
        container.add(redecorate3);
        container.add(redecorate4);
        lift2.setText(String.valueOf(client.getPersonNumb()) + HUMAN_MEASURE);
        lift3.setText(Converter.convertIn(LIFT_SERVICE_TARIFF) + BYN);
        lift4.setText(Converter.convertIn(bill.getLiftService()) + BYN);
        container.add(lift1);
        container.add(lift2);
        container.add(lift3);
        container.add(lift4);
        additionalElectricity2.setText(String.valueOf(client.getPersonNumb()) + HUMAN_MEASURE);
        additionalElectricity3.setText(Converter.convertIn(ADDITIONAL_ELECTRICITY_TARIFF) + BYN);
        additionalElectricity4.setText(Converter.convertIn(bill.getAdditionalElectricity()) + BYN);
        container.add(additionalElectricity1);
        container.add(additionalElectricity2);
        container.add(additionalElectricity3);
        container.add(additionalElectricity4);
        water2.setText(String.valueOf(client.getWaterCount()) + VOLUME_MEASURE);
        water3.setText(Converter.convertIn(WATER_TARIFF_BEFORE_LIMIT) + SLASH + Converter.convertIn(WATER_TARIFF_AFTER_LIMIT) + BYN);
        water4.setText(Converter.convertIn(bill.getWater()) + BYN);
        container.add(water1);
        container.add(water2);
        container.add(water3);
        container.add(water4);
        gas2.setText(String.valueOf(client.getGasCount()) + VOLUME_MEASURE);
        gas3.setText(Converter.convertIn(GAS_TARIFF));
        gas4.setText(Converter.convertIn(bill.getGas()) + BYN);
        container.add(gas1);
        container.add(gas2);
        container.add(gas3);
        container.add(gas4);
        electricity2.setText(String.valueOf(client.getElectroCount() + ELECTRICITY_MEASURE));
        electricity3.setText(Converter.convertIn(ELECTRICITY_TARIFF) + BYN);
        electricity4.setText(Converter.convertIn(bill.getElectricity()) + BYN);
        container.add(electricity1);
        container.add(electricity2);
        container.add(electricity3);
        container.add(electricity4);
        totalSum4.setText(Converter.convertIn(bill.getTotalSum()) + BYN);
        container.add(totalSum1);
        container.add(totalSum2);
        container.add(totalSum3);
        container.add(totalSum4);
        container.add(dash1);
        container.add(dash2);
        container.add(dash3);
        container.add(dash4);
        container.add(payment1);
        container.add(payment2);
        container.add(payField);
        container.add(payButton);
        payButton.addActionListener(e -> {
            try {
                enteringPay = Converter.convertOut(Double.parseDouble(payField.getText()));
                if (enteringPay <= 0) {
                    throw new NumberFormatException();
                }else {
                    DBMethods.paymentForBill(client.getName(), enteringPay, bill.getTotalSum());
                }
                setVisible(false);
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, ENTER_CORRECT_AMOUNT);
            }
        });
    }
}
