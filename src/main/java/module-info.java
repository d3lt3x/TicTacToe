module me.delta.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens me.delta.tictactoe to javafx.fxml;
    exports me.delta.tictactoe;


}