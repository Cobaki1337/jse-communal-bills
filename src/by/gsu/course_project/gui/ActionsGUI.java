package by.gsu.course_project.gui;

import javax.swing.*;

import static by.gsu.course_project.gui.GuiConstants.REQUEST_FOR_DATA;

public class ActionsGUI {
    public static String requestWindow(){
        return JOptionPane.showInputDialog(REQUEST_FOR_DATA);
    }
}
