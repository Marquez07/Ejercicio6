package expresionlambda;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ExpresionLambda extends Application { 
    Label l1=new Label("Annual Interest Rate");
        TextField tf1=new TextField();
        Label l2=new Label("Number of Years");
        TextField tf2=new TextField();
        Label l3=new Label("Loan Amount");
        TextField tf3=new TextField();
        Label l4=new Label("Monthly Payment");
        TextField tf4=new TextField();
        Label l5=new Label("Total Payment");
        TextField tf5=new TextField();
        
        Button boton=new Button("Calcular");
    @Override
    public void start(Stage primaryStage) {
        

        boton.setOnAction(e->{
            calcular();
        });
        
        GridPane root = new GridPane();
        
        root.setConstraints(l1, 0, 0);
        root.setConstraints(tf1, 1, 0);
        root.setConstraints(l2, 0, 1);
        root.setConstraints(tf2, 1, 1);
        root.setConstraints(l3, 0, 2);
        root.setConstraints(tf3, 1, 2);
        root.setConstraints(l4, 0, 3);
        root.setConstraints(tf4, 1, 3);
        root.setConstraints(l5, 0, 4);
        root.setConstraints(tf5, 1, 4);
        root.setConstraints(boton, 1, 5);
        
        root.getChildren().add(l1);
        root.getChildren().add(tf1);
        root.getChildren().add(l2);
        root.getChildren().add(tf2);
        root.getChildren().add(l3);
        root.getChildren().add(tf3);
        root.getChildren().add(l4);
        root.getChildren().add(tf4);
        root.getChildren().add(l5);
        root.getChildren().add(tf5);
        root.getChildren().add(boton);
        
        root.setHgap(25);
        root.setVgap(5);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Calcula tu Hipoteca");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public double calcular(){
        try{
            double interes=Double.parseDouble(tf1.getText());
            double num_anio=Double.parseDouble(tf2.getText());
            double hipoteca=Double.parseDouble(tf3.getText());
            double r= interes/1200;
            double m=(hipoteca*r)/(1-Math.pow((1+r), -(12*num_anio)));
            double total=m*num_anio*12;
            
            tf4.setText(String.format("%.2f", m));
            tf5.setText(String.format("%.2f", total));
        }
        catch(NumberFormatException ev){
            tf1.setText("No es un numero");
            tf2.setText("No es un numero");
            tf3.setText("No es un numero");
        }

        
        
        return 0;
    }
    
}
