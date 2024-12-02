package ie.atu.testpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main content node
        Label welcomeLabel = new Label("Welcome, Diana!");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Get the current date and time
        String currentDateTime = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' hh:mm:ss a").format(new Date());
        Label dateLabel = new Label("Current Date and Time: " + currentDateTime);
        dateLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: gray;");

        // Load an image
        Image image = new Image("file:resources/image.jpg"); // Replace with the path to your image
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); // Set the width of the image
        imageView.setPreserveRatio(true); // Maintain the aspect ratio

        // Create a container to hold our labels and image
        VBox root = new VBox(10); // Spacing of 10 between elements
        root.getChildren().addAll(imageView, welcomeLabel, dateLabel);
        root.setStyle("-fx-alignment: center; -fx-padding: 20;");

        // Create and configure the scene
        Scene scene = new Scene(root, 400, 300);

        // Configure and show the stage
        primaryStage.setTitle("Welcome Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
