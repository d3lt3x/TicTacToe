package me.delta.tictactoe;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private final int[][] possibilities = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private String[] board = new String[9];
    private String currPlayer;
    private final Scene scene;
    private int playCount = 0;
    boolean paused = true;

    public Game(Stage stage, String player) {

        this.scene = stage.getScene();
        this.currPlayer = player;
        ((Text)this.scene.lookup("#pir")).setText("Player in row: " + player.toUpperCase());
        clearGame();
    }

    public void clearGame() {

        for (int i = 1; i <= 9; i++) {
            this.scene.lookup("#x" + i).setVisible(false);
            this.scene.lookup("#o" + i).setVisible(false);
        }
        this.board = new String[9];
        this.playCount = 0;
        paused = false;
        this.scene.lookup("#pir").setVisible(true);
    }

    private void set(String player, int pos) {

        this.scene.lookup("#" + player + pos).setVisible(true);
    }

    public void pick(String id) {

        if (paused) return;
        int pos = Integer.parseInt(String.valueOf(id.charAt(1)));

        if (this.board[pos - 1] != null)
            return;

        this.board[pos - 1] = this.currPlayer;
        this.set(currPlayer, pos);
        this.playCount++;

        if (this.currPlayer.equals("x"))
            this.currPlayer = "o";
        else this.currPlayer = "x";

        ((Text)this.scene.lookup("#pir")).setText("Player in row: " + this.currPlayer.toUpperCase());

        if (this.playCount < 3)
            return;

        this.checkWinner();
    }

    private void checkWinner() {

        String comparator;

        for (int[] section : this.possibilities) {

            if (this.board[section[0]] == null || this.board[section[1]] == null || this.board[section[2]] == null)
                continue;

            comparator = this.board[section[0]];

            if (comparator.equals(this.board[section[1]]) && comparator.equals(this.board[section[2]])) {

                this.declareWinner(comparator);
                return;
            }
        }

        if (this.playCount >= this.board.length)
            this.declareWinner("Nobody");

    }

    private void declareWinner(String winner) {

        paused = true;
        this.scene.lookup("#pir").setVisible(false);
        System.out.println(winner + " won");
        scene.lookup("#" + winner + "won").setVisible(true);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                scene.lookup("#" + winner + "won").setVisible(false);
                clearGame();
            }
        };

        new Timer().schedule(task, 2000);
    }

}



