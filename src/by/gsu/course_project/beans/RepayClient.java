package by.gsu.course_project.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.gsu.course_project.beans.BeansConstants.COLUMN_INDEX_3;

public class RepayClient extends Client {
    private int sum;

    public RepayClient(){}
    public RepayClient(ResultSet resultSet) throws SQLException{
        super(resultSet);
        this.sum = resultSet.getInt(COLUMN_INDEX_3);
    }
    public RepayClient(String name, int sum) {
        super(name);
        this.sum = sum;
    }
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
