package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Patient {
    public static void patientPage(){
        Button adPatient=new Button("Add Patient");
        adPatient.setPrefSize(100,30);
        adPatient.setLayoutX(200);
        adPatient.setLayoutY(50);
        Button upPatient=new Button("Update Patient");
        upPatient.setPrefSize(100,30);
        upPatient.setLayoutX(200);
        upPatient.setLayoutY(150);
        Button dePatient=new Button("Delete Patient");
        dePatient.setLayoutX(200);
        dePatient.setLayoutY(250);
        dePatient.setPrefSize(100,30);

        Stage s4=new Stage();
        Group gg3=new Group();
        Button returnBtn=new Button("return");
        returnBtn.setPrefSize(100,30);
        returnBtn.setLayoutX(380);
        returnBtn.setLayoutY(420);
        returnBtn.setOnAction(e->{
            login.log();
            s4.close();
        });
        gg3.getChildren().addAll(adPatient,upPatient,dePatient,returnBtn);
        Scene se2=new Scene(gg3,500,500);
        adPatient.setOnAction(e->{
            addPatient.add();
            s4.close();
        });
        dePatient.setOnAction(e->{
            Dletepa.delpat();
            s4.close();
        });
        upPatient.setOnAction(e->{
            UPDATEP.updatep();
            s4.close();
        });
        se2.setFill(Color.web("#FFDACC"));
        s4.setScene(se2);
        s4.setTitle("Clinic Management System");
        s4.show();
    }
}
