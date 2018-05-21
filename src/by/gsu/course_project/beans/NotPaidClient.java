package by.gsu.course_project.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.gsu.course_project.beans.BeansConstants.*;

public class NotPaidClient extends Client {
    private double area;
    private int personNumb;
    private int waterCount;
    private int gasCount;
    private int electroCount;

    public NotPaidClient(){}
    public NotPaidClient(ResultSet resultSet) throws SQLException{
        super(resultSet);
        this.area = resultSet.getDouble(COLUMN_INDEX_3);
        this.personNumb = resultSet.getInt(COLUMN_INDEX_4);
        this.waterCount = resultSet.getInt(COLUMN_INDEX_5);
        this.gasCount = resultSet.getInt(COLUMN_INDEX_6);
        this.electroCount = resultSet.getInt(COLUMN_INDEX_7);
    }
    public NotPaidClient(String name, double area, int personNumb, int waterCount, int gasCount, int electroCount) {
        super(name);
        this.area = area;
        this.personNumb = personNumb;
        this.waterCount = waterCount;
        this.gasCount = gasCount;
        this.electroCount = electroCount;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPersonNumb() {
        return personNumb;
    }

    public void setPersonNumb(int personNumb) {
        this.personNumb = personNumb;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    public int getGasCount() {
        return gasCount;
    }

    public void setGasCount(int gasCount) {
        this.gasCount = gasCount;
    }

    public int getElectroCount() {
        return electroCount;
    }

    public void setElectroCount(int electroCount) {
        this.electroCount = electroCount;
    }
}
