package com.example.cms;

import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class ConnectionDb {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "CMS";
    private static final String PASSWORD = "eden";

    Connection connection = null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public Connection conMethod(){

        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if(connection !=null) {
             alert.setContentText("sucess");
            }
            else {
                alert.setContentText("Not sucess");

            }

        } catch (Exception e){
            alert.setContentText(e.toString());

        }
        //alert.showAndWait();
        return connection;
    }

}