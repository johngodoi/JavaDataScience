package br.unifesp.henrique.john.research.datascience.charts;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * https://community.oracle.com/thread/2380913?tstart=0
 */
public class TestMultipleStages extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(TestMultipleStages.class, args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Create stage");
        btn.setOnAction(event -> {
            new CreateStage();
            primaryStage.toFront();

        });
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class CreateStage {

    public CreateStage() {
        Stage stage = new Stage();
        stage.setTitle("Many st");
        stage.setScene(new Scene(new Group(), 260, 230, Color.LIGHTCYAN));
        stage.show();
    }
}