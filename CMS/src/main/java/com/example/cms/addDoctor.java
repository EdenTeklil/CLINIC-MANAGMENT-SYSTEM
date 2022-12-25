package com.example.cms;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class addDoctor {
    public static void addoc(){
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
        Label ds=new Label("Email");
        ds.setLayoutX(290);
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

            String joiningD,id,name,age,se,bloodT,phoneN,he,email,roomN,depart;
            joiningD = jd1.getText();
            se="H";
            he="F";
            id=id1.getText();
            name=na1.getText();
            age=ag1.getText();
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

            bloodT=bl1.getText();
            depart=dep.getText();


            phoneN=id1.getText();


            email=ds1.getText();
            roomN=rn1.getText();



            boolean status=false;
            String query = "Insert into DOCTOR(JOINING_DATE,ID,NAME,AGE,GENDER,BLOOD_TYPE,DEPARTMENT,PHONE_NO,MARTIAL_STATUS,EMAIL,ROOM_NO) VALUES('" + joiningD + "','"
                    + id + "','" + name + "','" + age + "','" + se + "','" + bloodT + "','"+depart+"','" + phoneN + "','" + he + "','" + email + "','" + roomN + "')";

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
            doctorPage.doctoP();
            s10.close();
        });
        returnBtn.setPrefSize(100,30);

        Group gg7=new Group();
        gg7.getChildren().addAll(jd,jd1,idd,id1,na,na1,ag,ag1,ge,rbtn1,rbtn2,bl,bl1,dep,deplab,p,p1,ms,rbt1,rbt2,rbt3,ds,ds1,rn,rn1,ba,returnBtn);
        Scene se9=new Scene(gg7,700,700);
        se9.setFill(Color.web("#FFDACC"));
        s10.setScene(se9);
        s10.setTitle("Clinic Management System");
        s10.show();

    }
}
