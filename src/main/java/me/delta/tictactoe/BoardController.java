package me.delta.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BoardController {
    private Game game;
    private Stage stage;
    public void bn(MouseEvent mouseEvent) {

        if (game == null)
            return;

        String id = ((Button) mouseEvent.getSource()).getId();
        game.pick(id);
    }
    public Game startGame(Stage stage, String player) {

        this.stage = stage;

        this.game = new Game(stage, player);
        return this.game;
    }
    public void onClose(ActionEvent actionEvent) {
        this.stage.close();
    }
    public void onRestart(ActionEvent actionEvent) {
        this.game.clearGame();
    }
}