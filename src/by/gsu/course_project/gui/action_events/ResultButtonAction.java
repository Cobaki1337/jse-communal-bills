package by.gsu.course_project.gui.action_events;

import by.gsu.course_project.database.DBMethods;
import by.gsu.course_project.gui.ActionsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultButtonAction implements ActionListener {
    public void actionPerformed(ActionEvent e){
        DBMethods.searchFreeClients(ActionsGUI.requestWindow());
    }
}
