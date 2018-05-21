package by.gsu.course_project.database;

import by.gsu.course_project.ClientFactory;
import by.gsu.course_project.beans.*;
import by.gsu.course_project.beans.payment_methods.Payment;
import by.gsu.course_project.gui.AddPayMenu;
import by.gsu.course_project.gui.PayMenu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.gsu.course_project.beans.BeansConstants.COLUMN_INDEX_1;
import static by.gsu.course_project.database.DBConstants.*;

public class DBMethods {
    public static void  searchNotPaidClients(String name){
        try (PreparedStatement preparedStatement = ConnectorDB.getConnection()
                .prepareStatement(REQUEST_FOR_SEARCH_NOT_PAID_CLIENT)){
            preparedStatement.setString(PARAMETER_INDEX_1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            NotPaidClient client = (NotPaidClient) ClientFactory.getClientFromFactory(DBConstants.NOT_PAID_CLIENTS, resultSet);
            Bill bill = Payment.paymentMethod(client);
            PayMenu payMenu = new PayMenu(bill, client);
            payMenu.construct();
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void searchRepayClients(String name){
        try (PreparedStatement preparedStatement = ConnectorDB.getConnection()
                .prepareStatement(REQUEST_FOR_SEARCH_REPAY_CLIENT)){
            preparedStatement.setString(PARAMETER_INDEX_1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            RepayClient client = (RepayClient) ClientFactory.getClientFromFactory(REPAY_CLIENTS, resultSet);
            AddPayMenu addPayMenu = new AddPayMenu(client);
            addPayMenu.construct();
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void searchFreeClients(String name){
        try (PreparedStatement preparedStatement = ConnectorDB.getConnection()
                .prepareStatement(REQUEST_FOR_CHECK_FREE_CLIENT)){
            preparedStatement.setString(PARAMETER_INDEX_1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            int check = resultSet.getInt(COLUMN_INDEX_1);
            if (check == CHECK_NUMBER){
                JOptionPane.showMessageDialog(null, YOU_ARE_FREE);
            }else {
                JOptionPane.showMessageDialog(null, TRY_TO_LOOK);
            }
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }

    }
    private static void insertInFreeClient(Connection connection, String name) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_FOR_INSERT_IN_FREE_CLIENT);
        preparedStatement.setString(PARAMETER_INDEX_1, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    private static void insertInRepayClient(Connection connection, String name, int remainingPay)throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_FOR_INSERT_IN_REPAY_CLIENT);
        preparedStatement.setString(PARAMETER_INDEX_1, name);
        preparedStatement.setString(PARAMETER_INDEX_2, String.valueOf(remainingPay));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public static void removeClient(Connection connection, String name, String tableName) throws SQLException{
            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_FOR_REMOVE_1 + tableName + REQUEST_FOR_REMOVE_2);
            preparedStatement.setString(PARAMETER_INDEX_1, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
    }
    public static void paymentForBill(String name, int introducedPay, int totalBill){
        try(Connection connection = ConnectorDB.getConnection()) {
            DBMethods.removeClient(connection, name, NOT_PAID_CLIENTS_TABLE);
            if (introducedPay >= totalBill) {
                DBMethods.insertInFreeClient(connection, name);
            } else{
                DBMethods.insertInRepayClient(connection, name, totalBill - introducedPay);
            }
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void repaymentForBill(String name, int introducedPay, int remainingPay){
        try(Connection connection = ConnectorDB.getConnection()) {
            if (introducedPay >= remainingPay){
                DBMethods.removeClient(connection, name, REPAY_CLIENTS_TABLE);
                DBMethods.insertInFreeClient(connection, name);
            }else {
                DBMethods.removeClient(connection, name, REPAY_CLIENTS_TABLE);
                DBMethods.insertInRepayClient(connection, name, (remainingPay - introducedPay));
            }
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void existenceCheckNotPaidClients(String name){
        try(PreparedStatement preparedStatement = ConnectorDB.getConnection()
                .prepareStatement(REQUEST_FOR_CHECK_NOT_PAID_CLIENT)) {
            preparedStatement.setString(PARAMETER_INDEX_1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            int check = resultSet.getInt(COLUMN_INDEX_1);
            if (check == CHECK_NUMBER){
                DBMethods.searchNotPaidClients(name);
            }else {
                JOptionPane.showMessageDialog(null, TRY_AGAIN);
            }
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void existenceCheckRepayClients(String name){
        try(PreparedStatement preparedStatement = ConnectorDB.getConnection()
                .prepareStatement(REQUEST_FOR_CHECK_REPAY_CLIENT)) {
            preparedStatement.setString(PARAMETER_INDEX_1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            int check = resultSet.getInt(COLUMN_INDEX_1);
            if (check == CHECK_NUMBER){
                DBMethods.searchRepayClients(name);
            }else {
                JOptionPane.showMessageDialog(null, TRY_AGAIN);
            }
        }catch (SQLException e){
            System.err.println(CONNECTION_PROBLEM + e.getMessage());
            e.printStackTrace();
        }
    }
}
