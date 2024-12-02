package ie.atu.testpackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Counter extends Application {
    private int count = 0;
    
    @Override
    public void start(Stage primaryStage) {
        // Create display
        Label countLabel = new Label("0");
        
        // Create buttons
        Button incrementButton = new Button("+");
        Button decrementButton = new Button("-");
        
        // Inline styling
incrementButton.setStyle("-fx-background-color: #4CAF50; " +
"-fx-text-fill: white;");

// Style class
decrementButton.getStyleClass().add("success-button");

        // Add event handlers
        incrementButton.setOnAction(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });
        
        decrementButton.setOnAction(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });
        
        // Create layout
        HBox layout = new HBox(10);
        layout.getChildren().addAll(decrementButton, 
                                  countLabel, 
                                  incrementButton);
        
        // Show the stage
        Scene scene = new Scene(layout, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

        
        // External stylesheet
        //scene.getStylesheets().add(getClass().getResource("../resources/styles.css").toExternalForm()); 

    }

    public static void main(String[] args) {
        launch(args);
    }
}
