package com.example.cms;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class doctorPage {


    public static void doctoP(){
        Stage s8=new Stage();
        Button adDoctor=new Button("Add Doctor");
        adDoctor.setLayoutX(200);
        adDoctor.setLayoutY(50);
        adDoctor.setPrefSize(100,30);
        Button upDoctor=new Button("Update Doctor");
        upDoctor.setLayoutX(200);
        upDoctor.setLayoutY(150);
        upDoctor.setPrefSize(100,30);
        Button deDoctor=new Button("Delete Doctor");
        deDoctor.setLayoutX(200);
        deDoctor.setLayoutY(250);
        deDoctor.setPrefSize(100,30);

        Button returnBtn=new Button("return");
        returnBtn.setLayoutX(370);
        returnBtn.setLayoutY(440);
        returnBtn.setPrefSize(100,30);
        returnBtn.setOnAction(e->{
            login.log();
            s8.close();
        });



        Group gg5=new Group();
        gg5.getChildren().addAll(adDoctor,upDoctor,deDoctor,returnBtn);
        Scene se8=new Scene(gg5,500,500);
        adDoctor.setOnAction(e->{
            addDoctor.addoc();
            s8.close();
        });
        deDoctor.setOnAction(e->{
            DelDoc.deldoctor();
            s8.close();

        });
        upDoctor.setOnAction(e->{
            UpdateD.updated();
            s8.close();
        });
        se8.setFill(Color.web("#FFDACC"));
        s8.setScene(se8);
        s8.setTitle("Clinic Management System");
        s8.show();


    }
}
