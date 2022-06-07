package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MenuPage {

    public void changeScene(ActionEvent event) throws IOException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("SavedGame.fxml"));
        Scene SavedGameScene = new Scene(SavedGameParent);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);
        table.show();
    }

    public void back(ActionEvent event) throws IOException, InterruptedException {

            Parent SavedGameParent = FXMLLoader.load(getClass().getResource("SelectLvl.fxml"));
            Scene SavedGameScene = new Scene(SavedGameParent);
            Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
            table.setScene(SavedGameScene);
            table.show();
        }

    public void handleButtonAction(ActionEvent event) {
        System.exit(0);
    }
}
