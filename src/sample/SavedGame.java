package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

public class SavedGame implements Initializable {

    public TextField textfieldName;
    public TextField textfieldLevel;
    public TextField textfieldToken;
    public TableView<Data> tableview;
    public TableColumn<Data,String> colName;
    public TableColumn<Data,Integer> colLevel;
    public TableColumn<Data,Integer> colToken;


    public void changeScene(ActionEvent event) throws IOException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene SavedGameScene = new Scene(SavedGameParent);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);
        table.show();
    }
    ArrayList<Shooter> Shoo = new ArrayList<Shooter>();
    ArrayList<Nut> Nutt = new ArrayList<Nut>();
    ArrayList<SunFlower> SF = new ArrayList<SunFlower>();
    ArrayList<CherryBomb> CB = new ArrayList<CherryBomb>();
    ArrayList<Zombie> Zom = new ArrayList<Zombie>();
    ArrayList<TranslateTransition> TT = new ArrayList<TranslateTransition>();
    int count=0;
    int total=0;
    double tempX;
    double tempY;
    Group group = new Group();
    Label timer = new Label();
    public void checkZombie() throws InterruptedException {
//        System.out.println(Zom.size());
//        System.out.println(SF.size());

        for(int j=0;j<Shoo.size();j++){
            for(int i=0;i<Zom.size();i++){
                double kx=Zom.get(i).m.getTranslateX()-(Zom.get(i).m.getX()-Shoo.get(j).img2.getTranslateX())+675;
                double kx1=Zom.get(i).m.getTranslateX()-(Zom.get(i).m.getX()-Shoo.get(j).img3.getTranslateX())+675;
                double Sh=Zom.get(i).m.getTranslateX()-(Zom.get(i).m.getX()-Shoo.get(j).Shooter.getTranslateX())+685;
//                    double ky=Zom.get(i).m.getTranslateY()-(Zom.get(i).m.getY()-Shoo.get(j).img2.getTranslateY())+280;
//                    System.out.println(kx);
                if((kx<10 && kx>-10) || (kx1<10 && kx1>-10)){
                    System.out.println(i);
                    System.out.println(j);
                    if(Zom.get(i).health>0){
                        Zom.get(i).health-=1;
                        System.out.println(Zom.get(i).health);
                        System.out.println(Zom.get(i)); }
                    else{
                        System.out.println("ZombieDied");
                        Zom.get(i).m=null;
                    }

                }
                if(Sh<5 && Sh>-10){
                    if(Zom.get(i).health>0){
                        System.out.println("ShooterDied");
                        Shoo.get(j).Shooter=null;
                    }

                }

            }
        }
        for(int j=0;j<Nutt.size();j++){
            for(int i=0;i<Zom.size();i++){
                double Sh=Zom.get(i).m.getTranslateX()-(Zom.get(i).m.getX()-Nutt.get(j).Shooter.getTranslateX())+685;
                System.out.println(Sh);
                if(Sh<10 && Sh>-10){
                    if(Zom.get(i).health>0){
                        System.out.println("ShooterDied");
                        Shoo.get(j).Shooter=null;
                        TT.get(i).setDelay(Duration.seconds(4));
                    }

                }

            }
        }
        for(int j=0;j<SF.size();j++){
            for(int i=0;i<Zom.size();i++){
                double Sh=Zom.get(i).m.getTranslateX()-(Zom.get(i).m.getX()-SF.get(j).getImageS().getTranslateX())+685;
//                    double ky=Zom.get(i).m.getTranslateY()-(Zom.get(i).m.getY()-Shoo.get(j).img2.getTranslateY())+280;
                System.out.println(Sh);
                if(Sh<10 && Sh>-10){
                    if(Zom.get(i).health>0){
                        System.out.println("ShooterDied");
                        Shoo.get(j).Shooter=null;
                        TT.get(i).setDelay(Duration.seconds(4));
                    }

                }

            }
        }
        for(int j=0;j<CB.size();j++){
            for(int i=0;i<Zom.size();i++){
                double Sh=Zom.get(i).m.getTranslateX()-(Zom.get(i).m.getX()-CB.get(j).getImageS().getTranslateX())+685;
                double ky=Zom.get(i).m.getTranslateY()-(Zom.get(i).m.getY()-Shoo.get(j).img2.getTranslateY())+280;
                System.out.println(Sh);
                if((Sh<25 && Sh>-25)||(ky<25 && ky>-25)){
                    if(Zom.get(i).health>0){
                        CB.get(j).Shooter=null;
                        Zom.get(i).m=null;
                        System.out.println("CherrBombDied");
                        System.out.println("ZombieDied");

                    }

                }

            }
        }
//    System.out.println( TT.get(0).getByX());
//        System.out.println( TT.get(1).);
//        System.out.println( TT.get(2).getByX());
//            for(int j=0;j<SF.size();j++){
//                for(int i=0;i<Zom.size();i++){
//                if(SF.get(j).img2.intersects(Zom.get(i).m.getLayoutBounds())){
//                    System.out.println(Zom.get(i).m.getX());
//                    SF.remove(j);
//                    System.out.println("asdfghj");
//                }
//            }}
    }
    public void sunFall(double tempX,double tempY){
        Button button5=new Button();

        group.getChildren().add(button5);
        Image a=new Image("images/sun.png");
        BackgroundImage ab=new BackgroundImage(a,BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, 20, true, true, true, true));
        Background abc =new Background(ab);
        ImageView m15 = new ImageView("images/sun.png");
        button5.setPickOnBounds(true);
        button5.setBackground(abc);
        button5.setMinSize(50,50);
        Random rd1 = new Random();


        button5.setLayoutX(tempX);
        button5.setLayoutY(tempY);

        button5.setOnMouseClicked(e ->
                {   total+=25;
                    timer.setText(Integer.toString(total));
                    button5.setDisable(true);
                    button5.setVisible(false);}
        );
    }



    public void Play(ActionEvent event) throws IOException, InterruptedException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("SelectLvl.fxml"));
        Scene SavedGameScene = new Scene(SavedGameParent);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);
        table.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colLevel.setCellValueFactory(new PropertyValueFactory<>("Level"));
        colToken.setCellValueFactory(new PropertyValueFactory<>("Scoretotal"));
        tableview.setItems(observableList);
    }
    ObservableList<Data> observableList= FXCollections.observableArrayList(
new Data("Aditya",2,200)
    );
    public void buttonAction(ActionEvent actionEvent){
        Data data =new Data(textfieldName.getText(),Integer.parseInt( textfieldLevel.getText()),Integer.parseInt( textfieldToken.getText()));
        tableview.getItems().add(data);
    }
}

