module com.example.gametictactoe.gametictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gametictactoe.gametictactoe to javafx.fxml;
    exports com.example.gametictactoe.gametictactoe;
}