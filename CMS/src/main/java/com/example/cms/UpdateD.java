package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateD {
    public static void updated(){
            Stage s10=new Stage();
            Label jd=new Label("Joining Date");
            jd.setLayoutX(20);
            jd.setLayoutY(50);
            TextField jd1=new TextField();
            jd1.setLayoutX(100);
            jd1.setLayoutY(50);
            Label idd=new Label("Id");
            idd.setLayoutX(40);
            idd.setLayoutY(100);
            TextField id1=new TextField();
            id1.setLayoutX(100);
            id1.setLayoutY(100);
            Label na=new Label("Name");
            na.setLayoutX(40);
            na.setLayoutY(150);
            TextField na1=new TextField();
            na1.setLayoutX(100);
            na1.setLayoutY(150);
            Label ag=new Label("Age");
            ag.setLayoutX(40);
            ag.setLayoutY(200);
            TextField ag1=new TextField();
            ag1.setLayoutX(100);
            ag1.setLayoutY(200);




            Label bl=new Label("Blood type");
            bl.setLayoutX(40);
            bl.setLayoutY(350);
            TextField bl1=new TextField();
            bl1.setLayoutX(100);
            bl1.setLayoutY(350);
            Label deplab=new Label("department");
            deplab.setLayoutX(280);
            deplab.setLayoutY(50);
            TextField dep=new TextField();
            dep.setLayoutX(380);
            dep.setLayoutY(50);
            Label p=new Label("Phone No");
            p.setLayoutX(280);
            p.setLayoutY(100);
            TextField p1=new TextField();
            p1.setLayoutX(350);
            p1.setLayoutY(100);
            Label ds=new Label("Email");
            ds.setLayoutX(290);
            ds.setLayoutY(350);
            TextField ds1=new TextField();
            ds1.setLayoutX(350);
            ds1.setLayoutY(350);


            Button ba=new Button("Update");
            ba.setLayoutX(400);
            ba.setLayoutY(600);
            ba.setPrefSize(100,30);

            ba.setOnAction(e->{

                String joiningD,id,name,age,bloodT,depart,phoneN,email;
                joiningD = jd1.getText();
                id=id1.getText();
                name=na1.getText();
                age=ag1.getText();
                bloodT=bl1.getText();
                depart=dep.getText();
                phoneN=id1.getText();
                email=ds1.getText();



                boolean status=false;
                String query =  "UPDATE DOCTOR SET JOINING_DATE='" + joiningD + "',NAME='" + name + "',AGE='" + age +"',BLOOD_TYPE='"+bloodT+
                        "',DEPARTMENT='"+depart+"',PHONE_NO='" + phoneN + "',EMAIL='" + email+ "' WHERE ID='"+ id + "'";
                System.out.println(query);

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

                }
                try {
                    connection.close();
                } catch (SQLException ex) {

                }

            });

            Button returnBtn=new Button("return");
            returnBtn.setLayoutX(570);
            returnBtn.setLayoutY(630);
            returnBtn.setPrefSize(100,30);
            returnBtn.setOnAction(e->{
                doctorPage.doctoP();
                s10.close();
            });

            Group gg7=new Group();
            gg7.getChildren().addAll(jd,jd1,idd,id1,na,na1,ag,ag1,bl,bl1,dep,deplab,p,p1,ds,ds1,ba,returnBtn);
            Scene se9=new Scene(gg7,700,700);
            se9.setFill(Color.web("#FFDACC"));
            s10.setScene(se9);
            s10.setTitle("Clinic Management System");
            s10.show();


        }
}
