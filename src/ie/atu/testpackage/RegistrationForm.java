package ie.atu.testpackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane for the form layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        // Add the title
        Label titleLabel = new Label("Registration");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        grid.add(titleLabel, 0, 0, 2, 1); // span across 2 columns

        // First Name
        Label firstNameLabel = new Label("First Name:");
        grid.add(firstNameLabel, 0, 1);
        TextField firstNameField = new TextField();
        grid.add(firstNameField, 1, 1);

        // Last Name
        Label lastNameLabel = new Label("Last Name:");
        grid.add(lastNameLabel, 0, 2);
        TextField lastNameField = new TextField();
        grid.add(lastNameField, 1, 2);

        // Email
        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 3);
        TextField emailField = new TextField();
        grid.add(emailField, 1, 3);

        // Password
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 4);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 4);

        // Confirm Password
        Label confirmPasswordLabel = new Label("Confirm:");
        grid.add(confirmPasswordLabel, 0, 5);
        PasswordField confirmPasswordField = new PasswordField();
        grid.add(confirmPasswordField, 1, 5);

        // Feedback Label
        Label feedbackLabel = new Label();
        feedbackLabel.setTextFill(Color.RED);
        grid.add(feedbackLabel, 0, 6, 2, 1); // span across 2 columns

        // Register Button
        Button registerButton = new Button("Register");
        grid.add(registerButton, 1, 7);

        // Button Action with Validation
        registerButton.setOnAction(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                feedbackLabel.setText("All fields are required.");
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                feedbackLabel.setText("Invalid email format.");
            } else if (!password.equals(confirmPassword)) {
                feedbackLabel.setText("Passwords do not match.");
            } else if (password.length() < 6) {
                feedbackLabel.setText("Password must be at least 6 characters.");
            } else {
                feedbackLabel.setTextFill(Color.GREEN);
                feedbackLabel.setText("Registration successful!");
            }
        });

        // Create Scene and Show
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
