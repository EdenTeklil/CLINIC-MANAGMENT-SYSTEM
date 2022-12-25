package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class logAs {
    public static void logas(){
        Stage stt=new Stage();
        Label ad=new Label("WELCOME TO MINI CLINIC");
        ad.setLayoutX(120);
        ad.setLayoutY(50);
        Label lo=new Label("LOG AS");
        lo.setLayoutX(50);
        lo.setLayoutY(120);
        Button ad1=new Button("Admin");
        ad1.setLayoutX(100);
        ad1.setLayoutY(170);
        ad1.setPrefSize(100,30);
        Button io1=new Button("Doctor");
        io1.setLayoutX(180);
        io1.setLayoutY(170);
        io1.setPrefSize(100,30);
        ad.setStyle("-fx-font-weight:Extra-bold;-fx-font-size:19;-fx-text-fill:#AFB83B");
        lo.setStyle("-fx-font-weight:bold-fx-font-size:17;-fx-text-fill:#AFB83B");
        ad1.setStyle("-fx-background-color:#B8B8B8");
        io1.setStyle("-fx-background-color:#B8B8B8");
        ad1.setOnAction(e->{
            Admin.admin();
            stt.close();
        });
        io1.setOnAction(e->{
            Admin.admin();
            stt.close();
        });
        Group gro=new Group();
        gro.getChildren().addAll(ad,lo,ad1,io1);
        Scene see=new Scene(gro,400,400);
        see.setFill(Color.web("#FFDACC"));
        stt.setScene(see);
        stt.setTitle("Clinic Management System");
        stt.show();
    }
}
