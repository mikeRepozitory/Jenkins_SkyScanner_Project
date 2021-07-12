package com.skyScanner.utils;

import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseHelper {
    private static Logger logger = Logger.getLogger(DataBaseHelper.class);

    private static Connection conn;

    public void createConnection(String connString,String userName, String password) throws SQLException {

        try {
            conn = DriverManager.getConnection(connString,userName, password);
        }catch (SQLException ex){
            Log4jHelper.error(logger, ex);
            throw  ex;
        }

    }

    public String getData(String sqlQuery, String tcName, String columnName) throws SQLException {
        String data = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                String testCaseName = resultSet.getString(1);
                if(testCaseName.equalsIgnoreCase(tcName)){
                    data = resultSet.getString(columnName);
                    break;
                }
            }
        }catch (SQLException ex){
            Log4jHelper.error(logger, ex);
            throw ex;
        }
          return data;
    }

    public String[] getDatas(String query, String tcName) throws SQLException {
        String[] datas = null;

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData  = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            datas = new String[columnCount];
            while(resultSet.next()){
                String testCaseName = resultSet.getString(1);
                if(testCaseName.equalsIgnoreCase(tcName)){

                    for(int i =0; i < columnCount; i++){
                        datas[i] = resultSet.getString(i+1);
                    }
                }
            }
        }catch (Exception ex){
            Log4jHelper.error(logger, ex);
            throw ex;
        }
        return datas;
    }

}
