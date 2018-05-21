package by.gsu.course_project.database;

public class DBConstants {
    public static final String DATABASE_FILE = "database";
    public static final String URL = "url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String REQUEST_FOR_SEARCH_NOT_PAID_CLIENT = "SELECT * FROM NotPaidClients WHERE Name= ?;";
    public static final String REQUEST_FOR_SEARCH_REPAY_CLIENT = "SELECT * FROM RepayClients WHERE Name= ?;";
    public static final String REQUEST_FOR_CHECK_FREE_CLIENT = "SELECT EXISTS (SELECT * FROM FreeClients WHERE Name= ?);";
    public static final String REQUEST_FOR_CHECK_REPAY_CLIENT = "SELECT EXISTS (SELECT * FROM RepayClients WHERE Name= ? );";
    public static final String REQUEST_FOR_CHECK_NOT_PAID_CLIENT = "SELECT EXISTS (SELECT * FROM NotPaidClients WHERE Name= ? );";
    public static final String REQUEST_FOR_INSERT_IN_FREE_CLIENT = "INSERT INTO FreeClients (Name) VALUES (?);";
    public static final String REQUEST_FOR_INSERT_IN_REPAY_CLIENT = "INSERT INTO RepayClients (Name, Sum) VALUES (?, ?);";
    public static final String REQUEST_FOR_REMOVE_1 = "DELETE FROM ";
    public static final String REQUEST_FOR_REMOVE_2 = " WHERE Name = ?;";
    public static final String NOT_PAID_CLIENTS = "NOT_PAID_CLIENTS";
    public static final String NOT_PAID_CLIENTS_TABLE = "NotPaidClients";
    public static final String REPAY_CLIENTS = "REPAY_CLIENTS";
    public static final String REPAY_CLIENTS_TABLE = "RepayClients";
    public static final int PARAMETER_INDEX_1 = 1;
    public static final int PARAMETER_INDEX_2 = 2;
    public static final int CHECK_NUMBER = 1;
    public static final String CONNECTION_PROBLEM = "Problem with connection ";
    public static final String YOU_ARE_FREE = "You are free !!!";
    public static final String TRY_TO_LOOK = "Try to look for yourself in NotPaidClient or RepayClient group.";
    public static final String TRY_AGAIN = "Try again or look for in another group.";
}
