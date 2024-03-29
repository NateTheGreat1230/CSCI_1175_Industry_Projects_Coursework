package com.example.chapter31_exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Line");
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Line(10, 10, 80, 80));
        tab1.setContent(pane1);
        Tab tab2 = new Tab("Rectangle");
        tab2.setContent(new Rectangle(10, 10, 200, 200));
        Tab tab3 = new Tab("Circle");
        tab3.setContent(new Circle(50, 50, 20));
        Tab tab4 = new Tab("Ellipse");
        tab4.setContent(new Ellipse(10, 10, 100, 80));
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton topRadio = new RadioButton("Top");
        topRadio.setToggleGroup(toggleGroup);
        topRadio.setSelected(true);
        RadioButton bottomRadio = new RadioButton("Bottom");
        bottomRadio.setToggleGroup(toggleGroup);
        RadioButton leftRadio = new RadioButton("Left");
        leftRadio.setToggleGroup(toggleGroup);
        RadioButton rightRadio = new RadioButton("Right");
        rightRadio.setToggleGroup(toggleGroup);

        HBox radioBox = new HBox(10, topRadio, bottomRadio, leftRadio, rightRadio);
        StackPane.setAlignment(radioBox, Pos.BOTTOM_CENTER);
        pane1.getChildren().add(radioBox);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == topRadio) {
                tabPane.setSide(Side.TOP);
            } else if (newValue == bottomRadio) {
                tabPane.setSide(Side.BOTTOM);
            } else if (newValue == leftRadio) {
                tabPane.setSide(Side.LEFT);
            } else if (newValue == rightRadio) {
                tabPane.setSide(Side.RIGHT);
            }
        });

        Scene scene = new Scene(tabPane, 300, 250);
        primaryStage.setTitle("DisplayFigure"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window
    }
    public static void main(String[] args) {
        launch(args);
    }
}