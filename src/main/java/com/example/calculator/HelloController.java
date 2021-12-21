package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    private double number1;
    private double number2;
    private String sign;

    @FXML
    private TextField display;

    /**
     * class's constructor
     */
    public HelloController() {
        this.number1 = -1;
        this.number2 = -1;
        this.sign = "null";
    }

    /**
     * 0-9 and "." buttons call this
     * @param event action event
     */
    @FXML
    protected void numPress(ActionEvent event){
        String displayText = display.getText();
        if(displayText.equals("+") || displayText.equals("-") || displayText.equals("x") || displayText.equals("/") || displayText.equals("power"))
            display.clear();
        Button button = (Button)event.getSource();
        final String buttonNumber = button.getText();
        display.appendText(buttonNumber);
    }

    /**
     * sin and cos buttons call this
     * @param event action event
     */
    @FXML
    protected void triPress(ActionEvent event){
        Button button = (Button)event.getSource();
        final String buttonText = button.getText();
        double ans;
        String displayText = display.getText();
        number1 = Double.parseDouble(displayText);
        number1 = Math.toRadians(number1);
        if (buttonText.equals("sin")){
            this.sign = "sin";
            ans = Math.sin(number1);
        }else {
            this.sign = "cos";
            ans = Math.cos(number1);
        }
        this.ACPress();
        display.setText(String.valueOf(ans));
    }

    /**
     * "=" button calls this
     */
    @FXML
    protected void equalsPress(){
        String displayText = display.getText();
        double num = Double.parseDouble(displayText);
        number2 = num;
        double ans = 0;
        switch (this.sign){
            case "+":
                ans = number1 + number2;
                break;
            case "-":
                ans = number1 - number2;
                break;
            case "x":
                ans = number1 * number2;
                break;
            case "/":
                ans = number1 / number2;
                break;
            case "power":
                ans = Math.pow(number1 , number2);
                break;
        }
        String s = number1 + " " + sign + " " + number2 + " = " + ans;
        display.setText(s);

    }

    /**
     * "+ , - , x , / , power" buttons call this
     * @param event
     */
    @FXML
    protected void signPress(ActionEvent event){
        Button button = (Button)event.getSource();
        final String buttonText = button.getText();
        this.sign = buttonText;
        String displayText = display.getText();
        display.clear();
        display.setText(sign);
        double num = Double.parseDouble(displayText);
        number1 = num;
    }

    /**
     * AC button calls this
     */
    @FXML
    protected void ACPress(){
        number1 = -1;
        number2 = -1;
        this.sign = "null";
        display.clear();
    }



}