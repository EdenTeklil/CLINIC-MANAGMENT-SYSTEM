package com.example.cms;



import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
    public static void admin() {
        Stage s = new Stage();
        Label l1 = new Label("Clinic Management System");
        Label l2 = new Label("Username");
        l2.setLayoutX(40);
        l2.setLayoutY(50);
        TextField tf1 = new TextField();
        tf1.setLayoutX(100);
        tf1.setLayoutY(50);
        Label l3 = new Label("Password");
        l3.setLayoutX(40);
        l3.setLayoutY(100);
        PasswordField p1 = new PasswordField();
        p1.setLayoutX(100);
        p1.setLayoutY(100);
        Button b1 = new Button("Home");
        b1.setLayoutX(60);
        b1.setLayoutY(250);
        b1.setPrefSize(100,30);
        Button b2 = new Button("login");
        b2.setLayoutX(250);
        b2.setLayoutY(250);
        b2.setPrefSize(100,30);

        b1.setOnAction(e -> {
            logAs.logas();
            s.close();
        });
        Group gg = new Group();
        gg.getChildren().addAll(l2, tf1, l3, p1, b1, b2);
        Scene se = new Scene(gg, 400, 400);
        b2.setOnAction(e -> {
            Alert al=new Alert(Alert.AlertType.ERROR);
            String usernames,passwords;
            usernames=tf1.getText();
            passwords=p1.getText();
            String query = "select * from ADMIN where USERNAME='"+usernames+"' and PASSWORD='"+passwords+"'";
            ConnectionDb db = new ConnectionDb();
            Connection connection = db.conMethod();
            Statement stm;
            ResultSet re;
            try {
                stm=connection.createStatement();
                re= stm.executeQuery(query);
                try {
                    if(re.next()){
                       login.log();
                       s.close();
                    }
                    else{
                        al.setContentText("Check username or password and try again");
                        al.show();
                    }
                } catch (SQLException ex) {
                    al.setContentText("Check username or password and try again");
                    al.show();
                }
            } catch (SQLException ex) {
                al.setContentText("ERR IN DATABASE");
                al.show();
            }
        });
        se.setFill(Color.web("#FFDACC"));
        s.setScene(se);
        s.setTitle("Clinic Management System");
        s.show();


    }
}

