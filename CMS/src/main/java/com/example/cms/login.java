package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class login {
    public static void log(){
        Stage s2=new Stage();
        Button patient=new Button("Patient info");
        patient.setPrefSize(150,30);
        patient.setLayoutX(40);
        patient.setLayoutY(200);
        patient.setPrefSize(100,30);
        Button doctor=new Button("Doctor info");
        doctor.setPrefSize(150,30);
        doctor.setLayoutX(200);
        doctor.setLayoutY(200);
        doctor.setPrefSize(100,30);
        Button returnBtn=new Button("return");
        returnBtn.setLayoutX(280);
        returnBtn.setLayoutY(330);
        returnBtn.setPrefSize(100,30);
        returnBtn.setOnAction(e->{
            Admin.admin();
        });
        Group gg2=new Group();
        gg2.getChildren().addAll(patient,doctor,returnBtn);
        Scene se2=new Scene(gg2,400,400);
        se2.setFill(Color.web("#FFDACC"));
        patient.setOnAction(e->{
            Patient.patientPage();
            s2.close();
        });
        doctor.setOnAction(e->{
            doctorPage.doctoP();
            s2.close();
        });
        s2.setScene(se2);
        s2.setTitle("Clinic Management System");
        s2.show();
    }
}
