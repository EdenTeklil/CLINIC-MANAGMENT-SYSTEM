package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Dletepa {
    public static void delpat(){
        Stage stt=new Stage();
        Label l1=new Label("Enter id");
        Button del=new Button("DELETE");
        del.setPrefSize(100,30);
        Button ret=new Button("RETURN");
        ret.setPrefSize(100,30);
        TextField tf1=new TextField();
        l1.setLayoutX(50);
        l1.setLayoutY(30);
        tf1.setLayoutX(160);
        tf1.setLayoutY(30);
        del.setLayoutX(60);
        del.setLayoutY(70);
        ret.setLayoutX(290);
        ret.setLayoutY(330);


        ret.setOnAction(e->{
            Patient.patientPage();
            stt.close();
        });
        del.setOnAction(e->{
            String id= tf1.getText();
            boolean status=false;
            String query = "DELETE FROM CLINIC WHERE ID='"+id+"'";

            ConnectionDb db = new ConnectionDb();
            Connection connection = db.conMethod();
            Statement statement;
            statement = null;
            Alert al=new Alert(Alert.AlertType.INFORMATION);
            Alert al2=new Alert(Alert.AlertType.INFORMATION);
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                al.setContentText("Something went Wrong ");
                al.show();
            }
            status = false;
            try {
                status = ((Statement) statement).execute(query);
                al2.setContentText("Successfully Inserted");


            } catch (SQLException ex) {
                al.setContentText("Error occurred while executing");
                al.show();
            }

            if (!status) {
                al2.setContentText("successfully inserted");
                al2.showAndWait();
            } else {
                al.setContentText("Not successfully inserted");
                al.showAndWait();
            }
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("not coused");
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("not coused toooo");
            }

        });





        Group gro=new Group();
        gro.getChildren().addAll(l1,del,ret,tf1);
        Scene see=new Scene(gro,400,400);
        see.setFill(Color.web("#FFDACC"));
        stt.setScene(see);
        stt.setTitle("Clinic Management System");
        stt.show();



    }
}
