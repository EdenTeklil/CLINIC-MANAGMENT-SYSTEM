package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UPDATEP {
    public static void updatep(){
        Stage s7=new Stage();
        Label da=new Label("Date");
        da.setLayoutX(40);
        da.setLayoutY(50);
        TextField da1=new TextField();
        da1.setLayoutX(100);
        da1.setLayoutY(50);
        Label id=new Label("Id");
        id.setLayoutX(40);
        id.setLayoutY(100);
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






        Label drr=new Label("Address");
        drr.setLayoutX(280);
        drr.setLayoutY(50);
        TextField drr1=new TextField();
        drr1.setLayoutX(350);
        drr1.setLayoutY(50);
        Label p=new Label("Phone No");
        p.setLayoutX(280);
        p.setLayoutY(100);

        TextField p1=new TextField();
        p1.setLayoutX(350);
        p1.setLayoutY(100);


        Label ds=new Label("Disease Name");
        ds.setLayoutX(250);
        ds.setLayoutY(350);
        TextField ds1=new TextField();
        ds1.setLayoutX(350);
        ds1.setLayoutY(350);
        Label rn=new Label("Room no");
        rn.setLayoutX(250);
        rn.setLayoutY(450);
        TextField rn1=new TextField();
        rn1.setLayoutX(350);
        rn1.setLayoutY(450);
        Button rtn=new Button("Return ");
        Button enter=new Button("Enter ");
        enter.setLayoutY(600);
        enter.setLayoutX(60);
        enter.setPrefSize(100,30);
        rtn.setPrefSize(100,30);


        enter.setOnAction(e->{
             String name,Id,age,address,phone,dat,disease,room;



             name=na1.getText();
             Id=id1.getText();
             age=ag1.getText();
             address=drr1.getText();
             phone=p1.getText();
             dat=da1.getText();
             disease=ds1.getText();
             room=rn1.getText();




             boolean status=false;
             String query = "UPDATE CLINIC SET NAME='" + name + "',AGE='" + age + "',ADDRESS='" + address + "',PHONE_NO='" + phone +
                     "',DAT='" + dat + "',DISEASE_NAME='" + disease + "',ROOM_NO='" + room + "' WHERE ID='"+ Id + "'";

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
                 System.out.println("not coused");
             }
             try {
                 connection.close();
             } catch (SQLException ex) {
                 System.out.println("not coused toooo");
             }

     });


        rtn.setLayoutX(570);
        rtn.setLayoutY(630);
        rtn.setOnAction(e->{
            Patient.patientPage();
            s7.close();
        });






        Group gg4=new Group();
        gg4.getChildren().addAll(da,da1,id,id1,na,na1,ag,ag1,drr,drr1,p,p1,ds,ds1,rn,rn1,rtn,enter);
        Scene se3=new Scene(gg4,700,700);
        se3.setFill(Color.web("#FFDACC"));
        s7.setScene(se3);
        s7.setTitle("Clinic Management System");
        s7.show();


    }
}
