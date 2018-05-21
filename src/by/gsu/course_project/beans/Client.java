package by.gsu.course_project.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.gsu.course_project.beans.BeansConstants.COLUMN_INDEX_2;

public class Client {
    private String name;

    public Client(){}
    public Client(ResultSet resultSet) throws SQLException{
        this.name = resultSet.getString(COLUMN_INDEX_2);
    }
    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
