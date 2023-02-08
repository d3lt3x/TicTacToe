package me.delta.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToe.class.getResource("board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();

        ((BoardController) fxmlLoader.getController()).startGame(stage, "x");
    }

    public static void main(String[] args) {
        launch();
    }


}