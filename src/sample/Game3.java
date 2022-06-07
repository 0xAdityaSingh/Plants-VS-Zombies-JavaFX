package sample;

import com.sun.prism.Image;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game3{
    public void saveGame(ActionEvent event) throws IOException {

        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        Scene SavedGameScene = new Scene(SavedGameParent);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);
        table.show();
    }
    public void handleButtonAction(ActionEvent event) {
        System.exit(0);
    }


}
