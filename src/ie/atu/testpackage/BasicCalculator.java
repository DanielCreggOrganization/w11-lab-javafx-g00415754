package ie.atu.testpackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BasicCalculator extends Application {

    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create a text field to display calculations
        TextField display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 18px;");
        display.setPrefHeight(50);

        // Create a grid for buttons
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // Add numeric buttons (0-9)
        int number = 1;
        for (int row = 1; row <= 3; row++) {
            for (int col = 0; col < 3; col++) {
                int digit = number++;
                Button numButton = new Button(String.valueOf(digit));
                numButton.setPrefSize(50, 50);
                numButton.setOnAction(e -> appendDigit(display, digit));
                grid.add(numButton, col, row);
            }
        }

        // Add the 0 button
        Button zeroButton = new Button("0");
        zeroButton.setPrefSize(50, 50);
        zeroButton.setOnAction(e -> appendDigit(display, 0));
        grid.add(zeroButton, 0, 4);

        // Add operator buttons
        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < operators.length; i++) {
            String op = operators[i];
            Button opButton = new Button(op);
            opButton.setPrefSize(50, 50);
            opButton.setOnAction(e -> setOperator(display, op));
            grid.add(opButton, 3, i + 1);
        }

        // Add the Clear button
        Button clearButton = new Button("C");
        clearButton.setPrefSize(50, 50);
        clearButton.setOnAction(e -> clearDisplay(display));
        grid.add(clearButton, 2, 4);

        // Add the Equals button
        Button equalsButton = new Button("=");
        equalsButton.setPrefSize(50, 50);
        equalsButton.setOnAction(e -> calculateResult(display));
        grid.add(equalsButton, 3, 4);

        // Layout
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(10));
        layout.add(display, 0, 0, 4, 1);
        layout.add(grid, 0, 1);

        // Create Scene and Stage
        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Basic Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void appendDigit(TextField display, int digit) {
        currentInput += digit;
        display.setText(currentInput);
    }

    private void setOperator(TextField display, String op) {
        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput);
            operator = op;
            currentInput = "";
            display.setText(firstOperand + " " + operator + " ");
        }
    }

    private void calculateResult(TextField display) {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;
            switch (operator) {
                case "+" -> result = firstOperand + secondOperand;
                case "-" -> result = firstOperand - secondOperand;
                case "*" -> result = firstOperand * secondOperand;
                case "/" -> result = secondOperand != 0 ? firstOperand / secondOperand : 0; // Avoid division by zero
            }
            display.setText(String.valueOf(result));
            currentInput = "";
            operator = "";
            firstOperand = result; // Allow chaining operations
        }
    }

    private void clearDisplay(TextField display) {
        currentInput = "";
        operator = "";
        firstOperand = 0;
        display.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
