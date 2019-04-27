package com.kodilla.connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Layout {

    Stage stage;
    Engine engine;
    Board board;
    Pane pane;


    public Layout() {
    }

    public Shape makeGrid() {
        Shape shape = new Rectangle(705, 610);

        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 7; x++) {
                Circle circle = new Circle(45);
                circle.setCenterX(45);
                circle.setCenterY(45);
                circle.setTranslateX(x * 95 + 20);
                circle.setTranslateY(y * 95 + 20);

                shape = Shape.subtract(shape, circle);
            }
        }

        Light.Distant light = new Light.Distant();
        light.setAzimuth(45.0);
        light.setElevation(30.0);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        shape.setFill(Color.BLUE);
        shape.setEffect(lighting);

        return shape;
    }

    public static Circle drawRedDisc(int xP, int yP, int radius) {

        Circle redDisc = new Circle(xP, yP, 45);
        redDisc.setFill(Color.RED);

        return redDisc;
    }

    public static Circle drawYellowDisc(int xP, int yP, int radius) {

        Circle redDisc = new Circle(xP, yP, 45);
        redDisc.setFill(Color.YELLOW);

        return redDisc;
    }

}
