package by.gsu.course_project;

import by.gsu.course_project.beans.Client;
import by.gsu.course_project.beans.NotPaidClient;
import by.gsu.course_project.beans.RepayClient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientFactory {
    private static enum ClientKind{
        NOT_PAID_CLIENTS {
            @Override
            public Client getClient(ResultSet resultSet) throws SQLException {
                return new NotPaidClient(resultSet);
            }
        },
        REPAY_CLIENTS{
            @Override
            public Client getClient(ResultSet resultSet) throws SQLException {
                return new RepayClient(resultSet);
            }
        };
        public abstract Client getClient(ResultSet resultSet) throws SQLException;
    }
    public static Client getClientFromFactory(String tableName, ResultSet resultSet) throws SQLException{
        return ClientKind.valueOf(tableName).getClient(resultSet);
    }
}
