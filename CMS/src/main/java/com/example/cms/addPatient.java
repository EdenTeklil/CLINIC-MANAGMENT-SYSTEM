package com.example.cms;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class addPatient {
    public static void add(){
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

        Label ge=new Label("Gender");
        ge.setLayoutX(40);
        ge.setLayoutY(250);

        ToggleGroup group=new ToggleGroup();
        RadioButton rbtn1=new RadioButton("Male");
        RadioButton rbtn2=new RadioButton("Female");
        rbtn1.setToggleGroup(group);
        rbtn2.setToggleGroup(group);
        rbtn1.setLayoutX(50);
        rbtn1.setLayoutY(300);
        rbtn2.setLayoutX(130);
        rbtn2.setLayoutY(300);

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


        Label ms=new Label("Martial Status");
        ms.setLayoutX(280);
        ms.setLayoutY(150);
        ToggleGroup group1=new ToggleGroup();
        RadioButton rbt1=new RadioButton("Single");
        RadioButton rbt2=new RadioButton("Married");
        RadioButton rbt3=new RadioButton("Divorce");
        rbt1.setToggleGroup(group1);
        rbt2.setToggleGroup(group1);
        rbt3.setToggleGroup(group1);
        rbt1.setLayoutX(300);
        rbt1.setLayoutY(200);
        rbt2.setLayoutX(300);
        rbt2.setLayoutY(230);
        rbt3.setLayoutX(300);
        rbt3.setLayoutY(260);
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

        Button ba=new Button("Add");
        ba.setLayoutX(400);
        ba.setLayoutY(600);
        ba.setPrefSize(100,30);
       ba.setOnAction(e->{
           String a,b,c,d,se,f,g,he,i,j;
           se="H";
           he="F";
           a=da1.getText();
           b=id1.getText();
           c=na1.getText();
           d=ag1.getText();
           f=drr1.getText();
           g=p1.getText();
           i= ds1.getText();
           j=rn1.getText();
           if(rbtn1.isSelected()){
               se="M";
           }
           else if(rbtn2.isSelected()){
               se="F";
           }
           if(rbt1.isSelected()){
               he="S";

           }
           else if(rbt2.isSelected()){
               he="M";
           }
           else if(rbt3.isSelected()){
               he="D";
           }



           boolean status=false;
           String query = "Insert into CLINIC(NAME,ID,AGE,GENDER,ADDRESS,PHONE_NO,DAT,MARTIAL_STATUS,DISEASE_NAME,ROOM_NO) VALUES('" + c + "','"
                   + b + "','" + d + "','" + se + "','" + f + "','" + g + "','" + a + "','" + he + "','" + i + "','" + j + "')";


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
        Button returnBtn=new Button("return");
        returnBtn.setLayoutX(570);
        returnBtn.setLayoutY(650);
        returnBtn.setOnAction(e->{
            Patient.patientPage();
            s7.close();
        });
        returnBtn.setPrefSize(100,30);

        Group gg4=new Group();
        gg4.getChildren().addAll(da,da1,id,id1,na,na1,ag,ag1,ge,rbtn1,rbtn2,drr,drr1,p,p1,ms,rbt1,rbt2,rbt3,ds,ds1,rn,rn1,ba,returnBtn);
        Scene se3=new Scene(gg4,700,700);
        se3.setFill(Color.web("#FFDACC"));
        s7.setScene(se3);
        s7.setTitle("Clinic Management System");
        s7.show();
    }
}
