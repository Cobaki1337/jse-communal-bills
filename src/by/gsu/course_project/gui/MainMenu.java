package by.gsu.course_project.gui;
import by.gsu.course_project.gui.action_events.AddPayButtonAction;
import by.gsu.course_project.gui.action_events.PayButtonAction;
import by.gsu.course_project.gui.action_events.ResultButtonAction;

import javax.swing.*;
import java.awt.*;

import static by.gsu.course_project.gui.GuiConstants.*;

public class MainMenu extends JFrame{
    public MainMenu(){
        JButton pay = new JButton(PAY);
        JButton addPay = new JButton(ADD_AN_AMOUNT);
        JButton result = new JButton(CHECK_FOR_COINCIDENCE);
        Container container = this.getContentPane();
        setTitle(MAIN_MENU);
        setSize(SIZE_350_WIDTH, SIZE_350_HEIGHT);
        setLocation(MAIN_MENU_COORDINATE_X, MAIN_MENU_COORDINATE_Y);
        setResizable(false);
        container.setLayout(new GridLayout(ROWS_OR_COLS_3, ROWS_OR_COLS_1));
        PayButtonAction payButtonAction = new PayButtonAction();
        AddPayButtonAction addPayButtonAction = new AddPayButtonAction();
        ResultButtonAction resultButtonAction = new ResultButtonAction();
        container.add(pay);
        container.add(addPay);
        container.add(result);
        pay.addActionListener(payButtonAction);
        addPay.addActionListener(addPayButtonAction);
        result.addActionListener(resultButtonAction);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
