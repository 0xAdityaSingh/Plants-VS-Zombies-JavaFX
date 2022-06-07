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
import java.util.ArrayList;
import java.util.Random;

public class SelectLvl {
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
        BackgroundImage ab=new BackgroundImage(a, BackgroundRepeat.REPEAT,
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


    public void Lvl5(ActionEvent event) throws IOException, InterruptedException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
//        Image image = new Image("CONEZOMBIE.gif");
//        Image image2 = new Image("images/pea.png");
//        ImageView img = new ImageView(image);
//        group.getChildren().add(img);
        boolean t=false,f=false;

        VBox vbox = new VBox();
        group.getChildren().add(SavedGameParent);
        group.getChildren().add(vbox);

        timer.setLayoutX(19);
        timer.setLayoutY(56);
        group.getChildren().add(timer);
        timer.setText(Integer.toString(total));

        //////////making timer




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            incrementCount();
                            checkZombie();


                        }catch (IndexOutOfBoundsException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (NullPointerException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        catch (IllegalMonitorStateException e){
                            e.printStackTrace();
                        }
                    }

                    private void incrementCount() throws FileNotFoundException {
                        count++;

//                        timer.setText(Integer.toString(count));
//                        System.out.println(count);
                        if(count%5==0){
                            sunFall(tempX,tempY);
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
                            double x=rd1.nextDouble()*1000;
                            double y=rd1.nextDouble()*500;

                            button5.setLayoutX(x);
                            button5.setLayoutY(y);

                            button5.setOnMouseClicked(e ->
                                    {   total+=25;
                                        timer.setText(Integer.toString(total));
                                        button5.setDisable(true);
                                        button5.setVisible(false);}
                            );}
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(true);
        thread.start();




        //////////
        ImageView m1 = new ImageView("p00.png");
//        System.out.println(m1);
        m1.setFitHeight(150);
        m1.setFitWidth(50);
        m1.setX(80.0);
        m1.setY(1.0);
        m1.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"

        m1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Shooter pea=new Shooter();
                Shoo.add(pea);
//                System.out.println(Shoo.get(0));

                group.getChildren().add(pea.getImageP());
                group.getChildren().add(pea.getImageP2());
                group.getChildren().add(pea.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea.set_XP(event.getScreenX()-675);
                        pea.set_YP(event.getScreenY()-280);
                        pea.set_XP2(event.getScreenX()-675);
                        pea.set_YP2(event.getScreenY()-280);
                        pea.set_XS(event.getScreenX()-685);
                        pea.set_YS(event.getScreenY()-290);


                    }
                });
                total-=100;
                timer.setText(Integer.toString(total));

                pea.start();
//                System.out.println(Shoo.get(0));




            }
        });


        group.getChildren().add(m1);
        ImageView m2 = new ImageView("p01.png");
        m2.setFitHeight(150);
        m2.setFitWidth(50);
        m2.setX(150.0);
        m2.setY(1.0);
        m2.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SunFlower sun=new SunFlower();
                SF.add(sun);
//                pea.getImageP().setX(-675);
//                pea.getImageP().setY(-280);
//                pea.getImageS().setX(-675);
//                pea.getImageS().setY(-280);
                sun.getImageP().setX(0);
                sun.getImageP().setY(0);
                sun.getImageS().setX(0);
                sun.getImageS().setY(0);
//                System.out.println(pea.getImageP().getX());
//                System.out.println(pea.getImageP().getY());
//                System.out.println(pea.getImageS().getX());
//                System.out.println(pea.getImageS().getY());
                group.getChildren().add(sun.getImageP());
                group.getChildren().add(sun.getImageS());
                Button button51=new Button();
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        sun.set_XP(event.getScreenX()-675);
                        sun.set_YP(event.getScreenY()-280);
                        sun.set_XS(event.getScreenX()-685);
                        sun.set_YS(event.getScreenY()-290);
                        tempX=event.getScreenX()-675;
                        tempY=event.getScreenY()-280;
                        sunFall(tempX,tempY);



//                        System.out.println(pea.getImageP().getX());
//                        System.out.println(pea.getImageP().getY());
//                        System.out.println(pea.getImageS().getX());
//                        System.out.println(pea.getImageS().getY());
                    }
                });
//                tempX=sun.img2.getX();
//                tempY=sun.img2.getY();
                total-=50;
                timer.setText(Integer.toString(total));

//        System.out.println("hi");
                sun.start();





            }
        });

        group.getChildren().add(m2);
        ImageView m3 = new ImageView("p02.png");
        m3.setFitHeight(150);
        m3.setFitWidth(50);
        m3.setX(220.0);
        m3.setY(1.0);
        m3.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                CherryBomb pea1=new CherryBomb();
                CB.add(pea1);

                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=150;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m3);
        ImageView m4 = new ImageView("p03.png");
        m4.setFitHeight(150);
        m4.setFitWidth(50);
        m4.setX(290.0);
        m4.setY(1.0);
        m4.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Nut pea1=new Nut();
                Nutt.add(pea1);
                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=50;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m4);
        ImageView m5 = new ImageView("p07.png");
        m5.setFitHeight(150);
        m5.setFitWidth(50);
        m5.setX(360.0);
        m5.setY(1.0);
        m5.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m5.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Repeater pea1=new Repeater();
                Shoo.add(pea1);
                group.getChildren().add(pea1.getImageP());
                group.getChildren().add(pea1.getImageP2());
                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XP(event.getScreenX()-675);
                        pea1.set_YP(event.getScreenY()-280);
                        pea1.set_XP2(event.getScreenX()-675);
                        pea1.set_YP2(event.getScreenY()-280);
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=200;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
        group.getChildren().add(m5);
        ImageView m6 = new ImageView("p15.png");
        m6.setFitHeight(150);
        m6.setFitWidth(50);
        m6.setX(430.0);
        m6.setY(1.0);
        m6.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m6.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                TallNut pea1=new TallNut();
                Nutt.add(pea1);
                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=125;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
        group.getChildren().add(m6);
        ImageView m7 = new ImageView("BucketheadZombie.gif");
        ImageView m8 = new ImageView("BucketheadZombie.gif");
        ImageView m9 = new ImageView("BucketheadZombie.gif");
        ImageView m10 = new ImageView("BucketheadZombie.gif");
        ImageView m11 = new ImageView("BucketheadZombie.gif");
        ImageView m12 = new ImageView("BucketheadZombie.gif");
        ImageView m13 = new ImageView("BucketheadZombie.gif");
        ImageView m14 = new ImageView("BucketheadZombie.gif");




        m7.setX(818);
        m7.setY(438);
        m7.setFitHeight(60);
        m7.setFitWidth(40);
        m8.setX(818);
        m8.setY(273);
        m8.setFitHeight(60);
        m8.setFitWidth(40);
        m9.setX(818);
        m9.setY(96);
        m9.setFitHeight(60);
        m9.setFitWidth(40);
        m10.setX(818);
        m10.setY(191);
        m10.setFitHeight(60);
        m10.setFitWidth(40);
        m11.setX(818);
        m11.setY(273);
        m11.setFitHeight(60);
        m11.setFitWidth(40);
        m12.setX(818);
        m12.setY(348);
        m12.setFitHeight(60);
        m12.setFitWidth(40);
        m13.setX(818);
        m13.setY(438);
        m13.setFitHeight(60);
        m13.setFitWidth(40);
        m14.setX(818);
        m14.setY(96);
        m14.setFitHeight(60);
        m14.setFitWidth(40);
        group.getChildren().add(m7);
        group.getChildren().add(m8);
        group.getChildren().add(m9);
        group.getChildren().add(m10);
        group.getChildren().add(m11);
        group.getChildren().add(m12);
        group.getChildren().add(m13);
        group.getChildren().add(m14);
        Zombie z1=new Zombie(4,m7,5);
        Zombie z2=new Zombie(4,m8,5);
        Zombie z3=new Zombie(4,m9,5);
        Zombie z4=new Zombie(4,m10,5);
        Zombie z5=new Zombie(4,m11,5);
        Zombie z6=new Zombie(4,m12,5);
        Zombie z7=new Zombie(4,m13,5);
        Zombie z8=new Zombie(4,m14,5);
        Zom.add(z1);
        Zom.add(z2);
        Zom.add(z3);
        Zom.add(z4);
        Zom.add(z5);
        Zom.add(z6);
        Zom.add(z7);
        Zom.add(z8);

        TranslateTransition translate_zombie1 = new TranslateTransition();
        translate_zombie1.setByX(-700);
        translate_zombie1.setDuration(Duration.millis(25000));
        translate_zombie1.setCycleCount(1);
        translate_zombie1.setAutoReverse(false);
        translate_zombie1.setNode(m7);
        translate_zombie1.setDelay(Duration.seconds(15));
        translate_zombie1.play();

        TranslateTransition translate_zombie2 = new TranslateTransition();
        translate_zombie2.setByX(-700);
        translate_zombie2.setDuration(Duration.millis(25000));
        translate_zombie2.setCycleCount(1);
        translate_zombie2.setAutoReverse(false);
        translate_zombie2.setNode(m8);
        translate_zombie2.setDelay(Duration.seconds(15));
        translate_zombie2.play();
        TranslateTransition translate_zombie3 = new TranslateTransition();
        translate_zombie3.setByX(-700);
        translate_zombie3.setDuration(Duration.millis(25000));
        translate_zombie3.setCycleCount(1);
        translate_zombie3.setAutoReverse(false);
        translate_zombie3.setNode(m9);
        translate_zombie3.setDelay(Duration.seconds(15));
        translate_zombie3.play();
        TranslateTransition translate_zombie4 = new TranslateTransition();
        translate_zombie4.setByX(-700);
        translate_zombie4.setDuration(Duration.millis(25000));
        translate_zombie4.setCycleCount(1);
        translate_zombie4.setAutoReverse(false);
        translate_zombie4.setNode(m10);
        translate_zombie4.setDelay(Duration.seconds(40));
        translate_zombie4.play();
        TranslateTransition translate_zombie5 = new TranslateTransition();
        translate_zombie5.setByX(-700);
        translate_zombie5.setDuration(Duration.millis(25000));
        translate_zombie5.setCycleCount(1);
        translate_zombie5.setAutoReverse(false);
        translate_zombie5.setNode(m11);
        translate_zombie5.setDelay(Duration.seconds(40));
        translate_zombie5.play();
        TranslateTransition translate_zombie6 = new TranslateTransition();
        translate_zombie6.setByX(-700);
        translate_zombie6.setDuration(Duration.millis(25000));
        translate_zombie6.setCycleCount(1);
        translate_zombie6.setAutoReverse(false);
        translate_zombie6.setNode(m12);
        translate_zombie6.setDelay(Duration.seconds(40));
        translate_zombie6.play();
        TranslateTransition translate_zombie7 = new TranslateTransition();
        translate_zombie7.setByX(-700);
        translate_zombie7.setDuration(Duration.millis(25000));
        translate_zombie7.setCycleCount(1);
        translate_zombie7.setAutoReverse(false);
        translate_zombie7.setNode(m13);
        translate_zombie7.setDelay(Duration.seconds(40));
        translate_zombie7.play();
        TranslateTransition translate_zombie8 = new TranslateTransition();
        translate_zombie8.setByX(-700);
        translate_zombie8.setDuration(Duration.millis(25000));
        translate_zombie8.setCycleCount(1);
        translate_zombie8.setAutoReverse(false);
        translate_zombie8.setNode(m14);
        translate_zombie8.setDelay(Duration.seconds(40));
        translate_zombie8.play();
        checkZombie();
        if(Zom.contains(z1)==false){
            m7=null;
        }
        if(Zom.contains(z2)==false){
            m8=null;
        }
        if(Zom.contains(z3)==false){
            m9=null;
        }
        if(Zom.contains(z4)==false){
            m10=null;
        }
        if(Zom.contains(z5)==false){
            m11=null;
        }
        if(Zom.contains(z6)==false){
            m12=null;
        }
        if(Zom.contains(z7)==false){
            m13=null;
        }
        if(Zom.contains(z8)==false){
            m14=null;
        }

        Scene SavedGameScene = new Scene(group);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);

        table.show();
    }
    public void Lvl4(ActionEvent event) throws IOException, InterruptedException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
//        Image image = new Image("CONEZOMBIE.gif");
//        Image image2 = new Image("images/pea.png");
//        ImageView img = new ImageView(image);
//        group.getChildren().add(img);
        boolean t=false,f=false;

        VBox vbox = new VBox();
        group.getChildren().add(SavedGameParent);
        group.getChildren().add(vbox);

        timer.setLayoutX(19);
        timer.setLayoutY(56);
        group.getChildren().add(timer);
        timer.setText(Integer.toString(total));

        //////////making timer




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            incrementCount();
                            checkZombie();


                        }catch (IndexOutOfBoundsException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (NullPointerException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        catch (IllegalMonitorStateException e){
                            e.printStackTrace();
                        }
                    }

                    private void incrementCount() throws FileNotFoundException {
                        count++;

//                        timer.setText(Integer.toString(count));
//                        System.out.println(count);
                        if(count%5==0){
                            sunFall(tempX,tempY);
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
                            double x=rd1.nextDouble()*1000;
                            double y=rd1.nextDouble()*500;

                            button5.setLayoutX(x);
                            button5.setLayoutY(y);

                            button5.setOnMouseClicked(e ->
                                    {   total+=25;
                                        timer.setText(Integer.toString(total));
                                        button5.setDisable(true);
                                        button5.setVisible(false);}
                            );}
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(true);
        thread.start();




        //////////
        ImageView m1 = new ImageView("p00.png");
//        System.out.println(m1);
        m1.setFitHeight(150);
        m1.setFitWidth(50);
        m1.setX(80.0);
        m1.setY(1.0);
        m1.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"

        m1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Shooter pea=new Shooter();
                Shoo.add(pea);
//                System.out.println(Shoo.get(0));

                group.getChildren().add(pea.getImageP());
                group.getChildren().add(pea.getImageP2());
                group.getChildren().add(pea.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea.set_XP(event.getScreenX()-675);
                        pea.set_YP(event.getScreenY()-280);
                        pea.set_XP2(event.getScreenX()-675);
                        pea.set_YP2(event.getScreenY()-280);
                        pea.set_XS(event.getScreenX()-685);
                        pea.set_YS(event.getScreenY()-290);


                    }
                });
                total-=100;
                timer.setText(Integer.toString(total));

                pea.start();
//                System.out.println(Shoo.get(0));




            }
        });


        group.getChildren().add(m1);
        ImageView m2 = new ImageView("p01.png");
        m2.setFitHeight(150);
        m2.setFitWidth(50);
        m2.setX(150.0);
        m2.setY(1.0);
        m2.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SunFlower sun=new SunFlower();
                SF.add(sun);
//                pea.getImageP().setX(-675);
//                pea.getImageP().setY(-280);
//                pea.getImageS().setX(-675);
//                pea.getImageS().setY(-280);
                sun.getImageP().setX(0);
                sun.getImageP().setY(0);
                sun.getImageS().setX(0);
                sun.getImageS().setY(0);
//                System.out.println(pea.getImageP().getX());
//                System.out.println(pea.getImageP().getY());
//                System.out.println(pea.getImageS().getX());
//                System.out.println(pea.getImageS().getY());
                group.getChildren().add(sun.getImageP());
                group.getChildren().add(sun.getImageS());
                Button button51=new Button();
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        sun.set_XP(event.getScreenX()-675);
                        sun.set_YP(event.getScreenY()-280);
                        sun.set_XS(event.getScreenX()-685);
                        sun.set_YS(event.getScreenY()-290);
                        tempX=event.getScreenX()-675;
                        tempY=event.getScreenY()-280;
                        sunFall(tempX,tempY);



//                        System.out.println(pea.getImageP().getX());
//                        System.out.println(pea.getImageP().getY());
//                        System.out.println(pea.getImageS().getX());
//                        System.out.println(pea.getImageS().getY());
                    }
                });
//                tempX=sun.img2.getX();
//                tempY=sun.img2.getY();
                total-=50;
                timer.setText(Integer.toString(total));

//        System.out.println("hi");
                sun.start();





            }
        });

        group.getChildren().add(m2);
        ImageView m3 = new ImageView("p02.png");
        m3.setFitHeight(150);
        m3.setFitWidth(50);
        m3.setX(220.0);
        m3.setY(1.0);
        m3.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                CherryBomb pea1=new CherryBomb();
                CB.add(pea1);

                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=150;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m3);
        ImageView m4 = new ImageView("p03.png");
        m4.setFitHeight(150);
        m4.setFitWidth(50);
        m4.setX(290.0);
        m4.setY(1.0);
        m4.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Nut pea1=new Nut();
                Nutt.add(pea1);
                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=50;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m4);
        ImageView m5 = new ImageView("p07.png");
        m5.setFitHeight(150);
        m5.setFitWidth(50);
        m5.setX(360.0);
        m5.setY(1.0);
        m5.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m5.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Repeater pea1=new Repeater();
                Shoo.add(pea1);
                group.getChildren().add(pea1.getImageP());
                group.getChildren().add(pea1.getImageP2());
                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XP(event.getScreenX()-675);
                        pea1.set_YP(event.getScreenY()-280);
                        pea1.set_XP2(event.getScreenX()-675);
                        pea1.set_YP2(event.getScreenY()-280);
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=200;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
        group.getChildren().add(m5);
        ImageView m6 = new ImageView("p15.png");
        m6.setFitHeight(150);
        m6.setFitWidth(50);
        m6.setX(430.0);
        m6.setY(1.0);
        m6.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m6.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                TallNut pea1=new TallNut();
                Nutt.add(pea1);
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=125;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m6);
        ImageView m7 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m8 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m9 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m10 = new ImageView("BucketheadZombie.gif");
        ImageView m11 = new ImageView("BucketheadZombie.gif");
        ImageView m12 = new ImageView("BucketheadZombie.gif");
        ImageView m13 = new ImageView("BucketheadZombie.gif");
        ImageView m14 = new ImageView("BucketheadZombie.gif");




        m7.setX(818);
        m7.setY(438);
        m7.setFitHeight(60);
        m7.setFitWidth(40);
        m8.setX(818);
        m8.setY(273);
        m8.setFitHeight(60);
        m8.setFitWidth(40);
        m9.setX(818);
        m9.setY(96);
        m9.setFitHeight(60);
        m9.setFitWidth(40);
        m10.setX(818);
        m10.setY(191);
        m10.setFitHeight(60);
        m10.setFitWidth(40);
        m11.setX(818);
        m11.setY(273);
        m11.setFitHeight(60);
        m11.setFitWidth(40);
        m12.setX(818);
        m12.setY(348);
        m12.setFitHeight(60);
        m12.setFitWidth(40);
        m13.setX(818);
        m13.setY(438);
        m13.setFitHeight(60);
        m13.setFitWidth(40);
        m14.setX(818);
        m14.setY(96);
        m14.setFitHeight(60);
        m14.setFitWidth(40);
        group.getChildren().add(m7);
        group.getChildren().add(m8);
        group.getChildren().add(m9);
        group.getChildren().add(m10);
        group.getChildren().add(m11);
        group.getChildren().add(m12);
        group.getChildren().add(m13);
        group.getChildren().add(m14);
        Zombie z1=new Zombie(4,m7,5);
        Zombie z2=new Zombie(4,m8,5);
        Zombie z3=new Zombie(4,m9,5);
        Zombie z4=new Zombie(4,m10,5);
        Zombie z5=new Zombie(4,m11,5);
        Zombie z6=new Zombie(4,m12,5);
        Zombie z7=new Zombie(4,m13,5);
        Zombie z8=new Zombie(4,m14,5);
        Zom.add(z1);
        Zom.add(z2);
        Zom.add(z3);
        Zom.add(z4);
        Zom.add(z5);
        Zom.add(z6);
        Zom.add(z7);
        Zom.add(z8);

        TranslateTransition translate_zombie1 = new TranslateTransition();
        translate_zombie1.setByX(-700);
        translate_zombie1.setDuration(Duration.millis(25000));
        translate_zombie1.setCycleCount(1);
        translate_zombie1.setAutoReverse(false);
        translate_zombie1.setNode(m7);
        translate_zombie1.setDelay(Duration.seconds(15));
        translate_zombie1.play();

        TranslateTransition translate_zombie2 = new TranslateTransition();
        translate_zombie2.setByX(-700);
        translate_zombie2.setDuration(Duration.millis(25000));
        translate_zombie2.setCycleCount(1);
        translate_zombie2.setAutoReverse(false);
        translate_zombie2.setNode(m8);
        translate_zombie2.setDelay(Duration.seconds(15));
        translate_zombie2.play();
        TranslateTransition translate_zombie3 = new TranslateTransition();
        translate_zombie3.setByX(-700);
        translate_zombie3.setDuration(Duration.millis(25000));
        translate_zombie3.setCycleCount(1);
        translate_zombie3.setAutoReverse(false);
        translate_zombie3.setNode(m9);
        translate_zombie3.setDelay(Duration.seconds(15));
        translate_zombie3.play();
        TranslateTransition translate_zombie4 = new TranslateTransition();
        translate_zombie4.setByX(-700);
        translate_zombie4.setDuration(Duration.millis(25000));
        translate_zombie4.setCycleCount(1);
        translate_zombie4.setAutoReverse(false);
        translate_zombie4.setNode(m10);
        translate_zombie4.setDelay(Duration.seconds(40));
        translate_zombie4.play();
        TranslateTransition translate_zombie5 = new TranslateTransition();
        translate_zombie5.setByX(-700);
        translate_zombie5.setDuration(Duration.millis(25000));
        translate_zombie5.setCycleCount(1);
        translate_zombie5.setAutoReverse(false);
        translate_zombie5.setNode(m11);
        translate_zombie5.setDelay(Duration.seconds(40));
        translate_zombie5.play();
        TranslateTransition translate_zombie6 = new TranslateTransition();
        translate_zombie6.setByX(-700);
        translate_zombie6.setDuration(Duration.millis(25000));
        translate_zombie6.setCycleCount(1);
        translate_zombie6.setAutoReverse(false);
        translate_zombie6.setNode(m12);
        translate_zombie6.setDelay(Duration.seconds(40));
        translate_zombie6.play();
        TranslateTransition translate_zombie7 = new TranslateTransition();
        translate_zombie7.setByX(-700);
        translate_zombie7.setDuration(Duration.millis(25000));
        translate_zombie7.setCycleCount(1);
        translate_zombie7.setAutoReverse(false);
        translate_zombie7.setNode(m13);
        translate_zombie7.setDelay(Duration.seconds(40));
        translate_zombie7.play();
        TranslateTransition translate_zombie8 = new TranslateTransition();
        translate_zombie8.setByX(-700);
        translate_zombie8.setDuration(Duration.millis(25000));
        translate_zombie8.setCycleCount(1);
        translate_zombie8.setAutoReverse(false);
        translate_zombie8.setNode(m14);
        translate_zombie8.setDelay(Duration.seconds(40));
        translate_zombie8.play();
        checkZombie();
        if(Zom.contains(z1)==false){
            m7=null;
        }
        if(Zom.contains(z2)==false){
            m8=null;
        }
        if(Zom.contains(z3)==false){
            m9=null;
        }
        if(Zom.contains(z4)==false){
            m10=null;
        }
        if(Zom.contains(z5)==false){
            m11=null;
        }
        if(Zom.contains(z6)==false){
            m12=null;
        }
        if(Zom.contains(z7)==false){
            m13=null;
        }
        if(Zom.contains(z8)==false){
            m14=null;
        }

        Scene SavedGameScene = new Scene(group);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);

        table.show();
    }
    public void Lvl3(ActionEvent event) throws IOException, InterruptedException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
//        Image image = new Image("CONEZOMBIE.gif");
//        Image image2 = new Image("images/pea.png");
//        ImageView img = new ImageView(image);
//        group.getChildren().add(img);
        boolean t=false,f=false;

        VBox vbox = new VBox();
        group.getChildren().add(SavedGameParent);
        group.getChildren().add(vbox);

        timer.setLayoutX(19);
        timer.setLayoutY(56);
        group.getChildren().add(timer);
        timer.setText(Integer.toString(total));

        //////////making timer




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            incrementCount();
                            checkZombie();


                        }catch (IndexOutOfBoundsException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (NullPointerException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        catch (IllegalMonitorStateException e){
                            e.printStackTrace();
                        }
                    }

                    private void incrementCount() throws FileNotFoundException {
                        count++;

//                        timer.setText(Integer.toString(count));
//                        System.out.println(count);
                        if(count%5==0){
                            sunFall(tempX,tempY);
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
                            double x=rd1.nextDouble()*1000;
                            double y=rd1.nextDouble()*500;

                            button5.setLayoutX(x);
                            button5.setLayoutY(y);

                            button5.setOnMouseClicked(e ->
                                    {   total+=25;
                                        timer.setText(Integer.toString(total));
                                        button5.setDisable(true);
                                        button5.setVisible(false);}
                            );}
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(true);
        thread.start();




        //////////
        ImageView m1 = new ImageView("p00.png");
//        System.out.println(m1);
        m1.setFitHeight(150);
        m1.setFitWidth(50);
        m1.setX(80.0);
        m1.setY(1.0);
        m1.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"

        m1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Shooter pea=new Shooter();
                Shoo.add(pea);
//                System.out.println(Shoo.get(0));

                group.getChildren().add(pea.getImageP());
                group.getChildren().add(pea.getImageP2());
                group.getChildren().add(pea.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea.set_XP(event.getScreenX()-675);
                        pea.set_YP(event.getScreenY()-280);
                        pea.set_XP2(event.getScreenX()-675);
                        pea.set_YP2(event.getScreenY()-280);
                        pea.set_XS(event.getScreenX()-685);
                        pea.set_YS(event.getScreenY()-290);


                    }
                });
                total-=100;
                timer.setText(Integer.toString(total));

                pea.start();
//                System.out.println(Shoo.get(0));




            }
        });


        group.getChildren().add(m1);
        ImageView m2 = new ImageView("p01.png");
        m2.setFitHeight(150);
        m2.setFitWidth(50);
        m2.setX(150.0);
        m2.setY(1.0);
        m2.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SunFlower sun=new SunFlower();
                SF.add(sun);
//                pea.getImageP().setX(-675);
//                pea.getImageP().setY(-280);
//                pea.getImageS().setX(-675);
//                pea.getImageS().setY(-280);
                sun.getImageP().setX(0);
                sun.getImageP().setY(0);
                sun.getImageS().setX(0);
                sun.getImageS().setY(0);
//                System.out.println(pea.getImageP().getX());
//                System.out.println(pea.getImageP().getY());
//                System.out.println(pea.getImageS().getX());
//                System.out.println(pea.getImageS().getY());
                group.getChildren().add(sun.getImageP());
                group.getChildren().add(sun.getImageS());
                Button button51=new Button();
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        sun.set_XP(event.getScreenX()-675);
                        sun.set_YP(event.getScreenY()-280);
                        sun.set_XS(event.getScreenX()-685);
                        sun.set_YS(event.getScreenY()-290);
                        tempX=event.getScreenX()-675;
                        tempY=event.getScreenY()-280;
                        sunFall(tempX,tempY);



//                        System.out.println(pea.getImageP().getX());
//                        System.out.println(pea.getImageP().getY());
//                        System.out.println(pea.getImageS().getX());
//                        System.out.println(pea.getImageS().getY());
                    }
                });
//                tempX=sun.img2.getX();
//                tempY=sun.img2.getY();
                total-=50;
                timer.setText(Integer.toString(total));

//        System.out.println("hi");
                sun.start();





            }
        });

        group.getChildren().add(m2);
        ImageView m3 = new ImageView("p02.png");
        m3.setFitHeight(150);
        m3.setFitWidth(50);
        m3.setX(220.0);
        m3.setY(1.0);
        m3.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                CherryBomb pea1=new CherryBomb();
                CB.add(pea1);

                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=150;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m3);
        ImageView m4 = new ImageView("p03.png");
        m4.setFitHeight(150);
        m4.setFitWidth(50);
        m4.setX(290.0);
        m4.setY(1.0);
        m4.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Nut pea1=new Nut();
                Nutt.add(pea1);
                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=50;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m4);
        ImageView m5 = new ImageView("p07.png");
        m5.setFitHeight(150);
        m5.setFitWidth(50);
        m5.setX(360.0);
        m5.setY(1.0);
        m5.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m5.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Repeater pea1=new Repeater();
                Shoo.add(pea1);
//                group.getChildren().add(pea1.getImageP());
//                group.getChildren().add(pea1.getImageP2());
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XP(event.getScreenX()-675);
                        pea1.set_YP(event.getScreenY()-280);
                        pea1.set_XP2(event.getScreenX()-675);
                        pea1.set_YP2(event.getScreenY()-280);
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=200;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m5);
        ImageView m6 = new ImageView("p15.png");
        m6.setFitHeight(150);
        m6.setFitWidth(50);
        m6.setX(430.0);
        m6.setY(1.0);
        m6.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m6.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                TallNut pea1=new TallNut();
                Nutt.add(pea1);
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=125;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m6);
        ImageView m7 = new ImageView("CONEZOMBIE.gif");
        ImageView m8 = new ImageView("CONEZOMBIE.gif");
        ImageView m9 = new ImageView("CONEZOMBIE.gif");
        ImageView m10 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m11 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m12 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m13 = new ImageView("NEWSPAPERZOMBIE.gif");
        ImageView m14 = new ImageView("NEWSPAPERZOMBIE.gif");




        m7.setX(818);
        m7.setY(438);
        m7.setFitHeight(60);
        m7.setFitWidth(40);
        m8.setX(818);
        m8.setY(273);
        m8.setFitHeight(60);
        m8.setFitWidth(40);
        m9.setX(818);
        m9.setY(96);
        m9.setFitHeight(60);
        m9.setFitWidth(40);
        m10.setX(818);
        m10.setY(191);
        m10.setFitHeight(60);
        m10.setFitWidth(40);
        m11.setX(818);
        m11.setY(273);
        m11.setFitHeight(60);
        m11.setFitWidth(40);
        m12.setX(818);
        m12.setY(348);
        m12.setFitHeight(60);
        m12.setFitWidth(40);
        m13.setX(818);
        m13.setY(438);
        m13.setFitHeight(60);
        m13.setFitWidth(40);
        m14.setX(818);
        m14.setY(96);
        m14.setFitHeight(60);
        m14.setFitWidth(40);
        group.getChildren().add(m7);
        group.getChildren().add(m8);
        group.getChildren().add(m9);
        group.getChildren().add(m10);
        group.getChildren().add(m11);
        group.getChildren().add(m12);
        group.getChildren().add(m13);
        group.getChildren().add(m14);
        Zombie z1=new Zombie(4,m7,5);
        Zombie z2=new Zombie(4,m8,5);
        Zombie z3=new Zombie(4,m9,5);
        Zombie z4=new Zombie(4,m10,5);
        Zombie z5=new Zombie(4,m11,5);
        Zombie z6=new Zombie(4,m12,5);
        Zombie z7=new Zombie(4,m13,5);
        Zombie z8=new Zombie(4,m14,5);
        Zom.add(z1);
        Zom.add(z2);
        Zom.add(z3);
        Zom.add(z4);
        Zom.add(z5);
        Zom.add(z6);
        Zom.add(z7);
        Zom.add(z8);

        TranslateTransition translate_zombie1 = new TranslateTransition();
        translate_zombie1.setByX(-700);
        translate_zombie1.setDuration(Duration.millis(25000));
        translate_zombie1.setCycleCount(1);
        translate_zombie1.setAutoReverse(false);
        translate_zombie1.setNode(m7);
        translate_zombie1.setDelay(Duration.seconds(15));
        translate_zombie1.play();

        TranslateTransition translate_zombie2 = new TranslateTransition();
        translate_zombie2.setByX(-700);
        translate_zombie2.setDuration(Duration.millis(25000));
        translate_zombie2.setCycleCount(1);
        translate_zombie2.setAutoReverse(false);
        translate_zombie2.setNode(m8);
        translate_zombie2.setDelay(Duration.seconds(15));
        translate_zombie2.play();
        TranslateTransition translate_zombie3 = new TranslateTransition();
        translate_zombie3.setByX(-700);
        translate_zombie3.setDuration(Duration.millis(25000));
        translate_zombie3.setCycleCount(1);
        translate_zombie3.setAutoReverse(false);
        translate_zombie3.setNode(m9);
        translate_zombie3.setDelay(Duration.seconds(15));
        translate_zombie3.play();
        TranslateTransition translate_zombie4 = new TranslateTransition();
        translate_zombie4.setByX(-700);
        translate_zombie4.setDuration(Duration.millis(25000));
        translate_zombie4.setCycleCount(1);
        translate_zombie4.setAutoReverse(false);
        translate_zombie4.setNode(m10);
        translate_zombie4.setDelay(Duration.seconds(40));
        translate_zombie4.play();
        TranslateTransition translate_zombie5 = new TranslateTransition();
        translate_zombie5.setByX(-700);
        translate_zombie5.setDuration(Duration.millis(25000));
        translate_zombie5.setCycleCount(1);
        translate_zombie5.setAutoReverse(false);
        translate_zombie5.setNode(m11);
        translate_zombie5.setDelay(Duration.seconds(40));
        translate_zombie5.play();
        TranslateTransition translate_zombie6 = new TranslateTransition();
        translate_zombie6.setByX(-700);
        translate_zombie6.setDuration(Duration.millis(25000));
        translate_zombie6.setCycleCount(1);
        translate_zombie6.setAutoReverse(false);
        translate_zombie6.setNode(m12);
        translate_zombie6.setDelay(Duration.seconds(40));
        translate_zombie6.play();
        TranslateTransition translate_zombie7 = new TranslateTransition();
        translate_zombie7.setByX(-700);
        translate_zombie7.setDuration(Duration.millis(25000));
        translate_zombie7.setCycleCount(1);
        translate_zombie7.setAutoReverse(false);
        translate_zombie7.setNode(m13);
        translate_zombie7.setDelay(Duration.seconds(40));
        translate_zombie7.play();
        TranslateTransition translate_zombie8 = new TranslateTransition();
        translate_zombie8.setByX(-700);
        translate_zombie8.setDuration(Duration.millis(25000));
        translate_zombie8.setCycleCount(1);
        translate_zombie8.setAutoReverse(false);
        translate_zombie8.setNode(m14);
        translate_zombie8.setDelay(Duration.seconds(40));
        translate_zombie8.play();
        checkZombie();
        if(Zom.contains(z1)==false){
            m7=null;
        }
        if(Zom.contains(z2)==false){
            m8=null;
        }
        if(Zom.contains(z3)==false){
            m9=null;
        }
        if(Zom.contains(z4)==false){
            m10=null;
        }
        if(Zom.contains(z5)==false){
            m11=null;
        }
        if(Zom.contains(z6)==false){
            m12=null;
        }
        if(Zom.contains(z7)==false){
            m13=null;
        }
        if(Zom.contains(z8)==false){
            m14=null;
        }

        Scene SavedGameScene = new Scene(group);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);

        table.show();
    }
    public void Lvl2(ActionEvent event) throws IOException, InterruptedException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
//        Image image = new Image("CONEZOMBIE.gif");
//        Image image2 = new Image("images/pea.png");
//        ImageView img = new ImageView(image);
//        group.getChildren().add(img);
        boolean t=false,f=false;

        VBox vbox = new VBox();
        group.getChildren().add(SavedGameParent);
        group.getChildren().add(vbox);

        timer.setLayoutX(19);
        timer.setLayoutY(56);
        group.getChildren().add(timer);
        timer.setText(Integer.toString(total));

        //////////making timer




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            incrementCount();
                            checkZombie();


                        }catch (IndexOutOfBoundsException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (NullPointerException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        catch (IllegalMonitorStateException e){
                            e.printStackTrace();
                        }
                    }

                    private void incrementCount() throws FileNotFoundException {
                        count++;

//                        timer.setText(Integer.toString(count));
//                        System.out.println(count);
                        if(count%5==0){
                            sunFall(tempX,tempY);
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
                            double x=rd1.nextDouble()*1000;
                            double y=rd1.nextDouble()*500;

                            button5.setLayoutX(x);
                            button5.setLayoutY(y);

                            button5.setOnMouseClicked(e ->
                                    {   total+=25;
                                        timer.setText(Integer.toString(total));
                                        button5.setDisable(true);
                                        button5.setVisible(false);}
                            );}
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(true);
        thread.start();




        //////////
        ImageView m1 = new ImageView("p00.png");
//        System.out.println(m1);
        m1.setFitHeight(150);
        m1.setFitWidth(50);
        m1.setX(80.0);
        m1.setY(1.0);
        m1.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"

        m1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Shooter pea=new Shooter();
                Shoo.add(pea);
//                System.out.println(Shoo.get(0));

                group.getChildren().add(pea.getImageP());
                group.getChildren().add(pea.getImageP2());
                group.getChildren().add(pea.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea.set_XP(event.getScreenX()-675);
                        pea.set_YP(event.getScreenY()-280);
                        pea.set_XP2(event.getScreenX()-675);
                        pea.set_YP2(event.getScreenY()-280);
                        pea.set_XS(event.getScreenX()-685);
                        pea.set_YS(event.getScreenY()-290);


                    }
                });
                total-=100;
                timer.setText(Integer.toString(total));

                pea.start();
//                System.out.println(Shoo.get(0));




            }
        });


        group.getChildren().add(m1);
        ImageView m2 = new ImageView("p01.png");
        m2.setFitHeight(150);
        m2.setFitWidth(50);
        m2.setX(150.0);
        m2.setY(1.0);
        m2.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SunFlower sun=new SunFlower();
                SF.add(sun);
//                pea.getImageP().setX(-675);
//                pea.getImageP().setY(-280);
//                pea.getImageS().setX(-675);
//                pea.getImageS().setY(-280);
                sun.getImageP().setX(0);
                sun.getImageP().setY(0);
                sun.getImageS().setX(0);
                sun.getImageS().setY(0);
//                System.out.println(pea.getImageP().getX());
//                System.out.println(pea.getImageP().getY());
//                System.out.println(pea.getImageS().getX());
//                System.out.println(pea.getImageS().getY());
                group.getChildren().add(sun.getImageP());
                group.getChildren().add(sun.getImageS());
                Button button51=new Button();
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        sun.set_XP(event.getScreenX()-675);
                        sun.set_YP(event.getScreenY()-280);
                        sun.set_XS(event.getScreenX()-685);
                        sun.set_YS(event.getScreenY()-290);
                        tempX=event.getScreenX()-675;
                        tempY=event.getScreenY()-280;
                        sunFall(tempX,tempY);



//                        System.out.println(pea.getImageP().getX());
//                        System.out.println(pea.getImageP().getY());
//                        System.out.println(pea.getImageS().getX());
//                        System.out.println(pea.getImageS().getY());
                    }
                });
//                tempX=sun.img2.getX();
//                tempY=sun.img2.getY();
                total-=50;
                timer.setText(Integer.toString(total));

//        System.out.println("hi");
                sun.start();





            }
        });

        group.getChildren().add(m2);
        ImageView m3 = new ImageView("p02.png");
        m3.setFitHeight(150);
        m3.setFitWidth(50);
        m3.setX(220.0);
        m3.setY(1.0);
        m3.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                CherryBomb pea1=new CherryBomb();
                CB.add(pea1);

                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=150;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
        group.getChildren().add(m3);
        ImageView m4 = new ImageView("p03.png");
        m4.setFitHeight(150);
        m4.setFitWidth(50);
        m4.setX(290.0);
        m4.setY(1.0);
        m4.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Nut pea1=new Nut();
                Nutt.add(pea1);
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=50;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
//        group.getChildren().add(m4);
        ImageView m5 = new ImageView("p07.png");
        m5.setFitHeight(150);
        m5.setFitWidth(50);
        m5.setX(360.0);
        m5.setY(1.0);
        m5.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m5.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Repeater pea1=new Repeater();
                Shoo.add(pea1);
//                group.getChildren().add(pea1.getImageP());
//                group.getChildren().add(pea1.getImageP2());
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XP(event.getScreenX()-675);
                        pea1.set_YP(event.getScreenY()-280);
                        pea1.set_XP2(event.getScreenX()-675);
                        pea1.set_YP2(event.getScreenY()-280);
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=200;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m5);
        ImageView m6 = new ImageView("p15.png");
        m6.setFitHeight(150);
        m6.setFitWidth(50);
        m6.setX(430.0);
        m6.setY(1.0);
        m6.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m6.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                TallNut pea1=new TallNut();
                Nutt.add(pea1);
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=125;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m6);
        ImageView m7 = new ImageView("images/zombies/zombie1.png");
        ImageView m8 = new ImageView("images/zombies/zombie1.png");
        ImageView m9 = new ImageView("images/zombies/zombie1.png");
        ImageView m10 = new ImageView("CONEZOMBIE.gif");
        ImageView m11 = new ImageView("CONEZOMBIE.gif");
        ImageView m12 = new ImageView("CONEZOMBIE.gif");
        ImageView m13 = new ImageView("CONEZOMBIE.gif");
        ImageView m14 = new ImageView("CONEZOMBIE.gif");




        m7.setX(818);
        m7.setY(438);
        m7.setFitHeight(60);
        m7.setFitWidth(40);
        m8.setX(818);
        m8.setY(273);
        m8.setFitHeight(60);
        m8.setFitWidth(40);
        m9.setX(818);
        m9.setY(96);
        m9.setFitHeight(60);
        m9.setFitWidth(40);
        m10.setX(818);
        m10.setY(191);
        m10.setFitHeight(60);
        m10.setFitWidth(40);
        m11.setX(818);
        m11.setY(273);
        m11.setFitHeight(60);
        m11.setFitWidth(40);
        m12.setX(818);
        m12.setY(348);
        m12.setFitHeight(60);
        m12.setFitWidth(40);
        m13.setX(818);
        m13.setY(438);
        m13.setFitHeight(60);
        m13.setFitWidth(40);
        m14.setX(818);
        m14.setY(96);
        m14.setFitHeight(60);
        m14.setFitWidth(40);
        group.getChildren().add(m7);
        group.getChildren().add(m8);
        group.getChildren().add(m9);
        group.getChildren().add(m10);
        group.getChildren().add(m11);
        group.getChildren().add(m12);
        group.getChildren().add(m13);
        group.getChildren().add(m14);
        Zombie z1=new Zombie(4,m7,5);
        Zombie z2=new Zombie(4,m8,5);
        Zombie z3=new Zombie(4,m9,5);
        Zombie z4=new Zombie(4,m10,5);
        Zombie z5=new Zombie(4,m11,5);
        Zombie z6=new Zombie(4,m12,5);
        Zombie z7=new Zombie(4,m13,5);
        Zombie z8=new Zombie(4,m14,5);
        Zom.add(z1);
        Zom.add(z2);
        Zom.add(z3);
        Zom.add(z4);
        Zom.add(z5);
        Zom.add(z6);
        Zom.add(z7);
        Zom.add(z8);

        TranslateTransition translate_zombie1 = new TranslateTransition();
        translate_zombie1.setByX(-700);
        translate_zombie1.setDuration(Duration.millis(25000));
        translate_zombie1.setCycleCount(1);
        translate_zombie1.setAutoReverse(false);
        translate_zombie1.setNode(m7);
        translate_zombie1.setDelay(Duration.seconds(15));
        translate_zombie1.play();

        TranslateTransition translate_zombie2 = new TranslateTransition();
        translate_zombie2.setByX(-700);
        translate_zombie2.setDuration(Duration.millis(25000));
        translate_zombie2.setCycleCount(1);
        translate_zombie2.setAutoReverse(false);
        translate_zombie2.setNode(m8);
        translate_zombie2.setDelay(Duration.seconds(15));
        translate_zombie2.play();
        TranslateTransition translate_zombie3 = new TranslateTransition();
        translate_zombie3.setByX(-700);
        translate_zombie3.setDuration(Duration.millis(25000));
        translate_zombie3.setCycleCount(1);
        translate_zombie3.setAutoReverse(false);
        translate_zombie3.setNode(m9);
        translate_zombie3.setDelay(Duration.seconds(15));
        translate_zombie3.play();
        TranslateTransition translate_zombie4 = new TranslateTransition();
        translate_zombie4.setByX(-700);
        translate_zombie4.setDuration(Duration.millis(25000));
        translate_zombie4.setCycleCount(1);
        translate_zombie4.setAutoReverse(false);
        translate_zombie4.setNode(m10);
        translate_zombie4.setDelay(Duration.seconds(40));
        translate_zombie4.play();
        TranslateTransition translate_zombie5 = new TranslateTransition();
        translate_zombie5.setByX(-700);
        translate_zombie5.setDuration(Duration.millis(25000));
        translate_zombie5.setCycleCount(1);
        translate_zombie5.setAutoReverse(false);
        translate_zombie5.setNode(m11);
        translate_zombie5.setDelay(Duration.seconds(40));
        translate_zombie5.play();
        TranslateTransition translate_zombie6 = new TranslateTransition();
        translate_zombie6.setByX(-700);
        translate_zombie6.setDuration(Duration.millis(25000));
        translate_zombie6.setCycleCount(1);
        translate_zombie6.setAutoReverse(false);
        translate_zombie6.setNode(m12);
        translate_zombie6.setDelay(Duration.seconds(40));
        translate_zombie6.play();
        TranslateTransition translate_zombie7 = new TranslateTransition();
        translate_zombie7.setByX(-700);
        translate_zombie7.setDuration(Duration.millis(25000));
        translate_zombie7.setCycleCount(1);
        translate_zombie7.setAutoReverse(false);
        translate_zombie7.setNode(m13);
        translate_zombie7.setDelay(Duration.seconds(40));
        translate_zombie7.play();
        TranslateTransition translate_zombie8 = new TranslateTransition();
        translate_zombie8.setByX(-700);
        translate_zombie8.setDuration(Duration.millis(25000));
        translate_zombie8.setCycleCount(1);
        translate_zombie8.setAutoReverse(false);
        translate_zombie8.setNode(m14);
        translate_zombie8.setDelay(Duration.seconds(40));
        translate_zombie8.play();
        checkZombie();
        if(Zom.contains(z1)==false){
            m7=null;
        }
        if(Zom.contains(z2)==false){
            m8=null;
        }
        if(Zom.contains(z3)==false){
            m9=null;
        }
        if(Zom.contains(z4)==false){
            m10=null;
        }
        if(Zom.contains(z5)==false){
            m11=null;
        }
        if(Zom.contains(z6)==false){
            m12=null;
        }
        if(Zom.contains(z7)==false){
            m13=null;
        }
        if(Zom.contains(z8)==false){
            m14=null;
        }

        Scene SavedGameScene = new Scene(group);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);

        table.show();
    }
    public void Lvl1(ActionEvent event) throws IOException, InterruptedException {
        Parent SavedGameParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
//        Image image = new Image("CONEZOMBIE.gif");
//        Image image2 = new Image("images/pea.png");
//        ImageView img = new ImageView(image);
//        group.getChildren().add(img);
        boolean t=false,f=false;

        VBox vbox = new VBox();
        group.getChildren().add(SavedGameParent);
        group.getChildren().add(vbox);

        timer.setLayoutX(19);
        timer.setLayoutY(56);
        group.getChildren().add(timer);
        timer.setText(Integer.toString(total));

        //////////making timer




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            incrementCount();
                            checkZombie();


                        }catch (IndexOutOfBoundsException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (NullPointerException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        catch (IllegalMonitorStateException e){
                            e.printStackTrace();
                        }
                    }

                    private void incrementCount() throws FileNotFoundException {
                        count++;

//                        timer.setText(Integer.toString(count));
//                        System.out.println(count);
                        if(count%5==0){
                            sunFall(tempX,tempY);
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
                            double x=rd1.nextDouble()*1000;
                            double y=rd1.nextDouble()*500;

                            button5.setLayoutX(x);
                            button5.setLayoutY(y);

                            button5.setOnMouseClicked(e ->
                                    {   total+=25;
                                        timer.setText(Integer.toString(total));
                                        button5.setDisable(true);
                                        button5.setVisible(false);}
                            );}
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(true);
        thread.start();




        //////////
        ImageView m1 = new ImageView("p00.png");
//        System.out.println(m1);
        m1.setFitHeight(150);
        m1.setFitWidth(50);
        m1.setX(80.0);
        m1.setY(1.0);
        m1.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"

        m1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Shooter pea=new Shooter();
                Shoo.add(pea);
//                System.out.println(Shoo.get(0));

                group.getChildren().add(pea.getImageP());
                group.getChildren().add(pea.getImageP2());
                group.getChildren().add(pea.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea.set_XP(event.getScreenX()-675);
                        pea.set_YP(event.getScreenY()-280);
                        pea.set_XP2(event.getScreenX()-675);
                        pea.set_YP2(event.getScreenY()-280);
                        pea.set_XS(event.getScreenX()-685);
                        pea.set_YS(event.getScreenY()-290);


                    }
                });
                total-=100;
                timer.setText(Integer.toString(total));

                pea.start();
//                System.out.println(Shoo.get(0));




            }
        });


        group.getChildren().add(m1);
        ImageView m2 = new ImageView("p01.png");
        m2.setFitHeight(150);
        m2.setFitWidth(50);
        m2.setX(150.0);
        m2.setY(1.0);
        m2.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m2.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SunFlower sun=new SunFlower();
                SF.add(sun);
//                pea.getImageP().setX(-675);
//                pea.getImageP().setY(-280);
//                pea.getImageS().setX(-675);
//                pea.getImageS().setY(-280);
                sun.getImageP().setX(0);
                sun.getImageP().setY(0);
                sun.getImageS().setX(0);
                sun.getImageS().setY(0);
//                System.out.println(pea.getImageP().getX());
//                System.out.println(pea.getImageP().getY());
//                System.out.println(pea.getImageS().getX());
//                System.out.println(pea.getImageS().getY());
                group.getChildren().add(sun.getImageP());
                group.getChildren().add(sun.getImageS());
                Button button51=new Button();
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        sun.set_XP(event.getScreenX()-675);
                        sun.set_YP(event.getScreenY()-280);
                        sun.set_XS(event.getScreenX()-685);
                        sun.set_YS(event.getScreenY()-290);
                        tempX=event.getScreenX()-675;
                        tempY=event.getScreenY()-280;
                        sunFall(tempX,tempY);



//                        System.out.println(pea.getImageP().getX());
//                        System.out.println(pea.getImageP().getY());
//                        System.out.println(pea.getImageS().getX());
//                        System.out.println(pea.getImageS().getY());
                    }
                });
//                tempX=sun.img2.getX();
//                tempY=sun.img2.getY();
                total-=50;
                timer.setText(Integer.toString(total));

//        System.out.println("hi");
                sun.start();





            }
        });

        group.getChildren().add(m2);
        ImageView m3 = new ImageView("p02.png");
        m3.setFitHeight(150);
        m3.setFitWidth(50);
        m3.setX(220.0);
        m3.setY(1.0);
        m3.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m3.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                CherryBomb pea1=new CherryBomb();
                CB.add(pea1);

//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=150;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
//        group.getChildren().add(m3);
        ImageView m4 = new ImageView("p03.png");
        m4.setFitHeight(150);
        m4.setFitWidth(50);
        m4.setX(290.0);
        m4.setY(1.0);
        m4.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m4.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Nut pea1=new Nut();
                Nutt.add(pea1);
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=50;
                timer.setText(Integer.toString(total));
                pea1.start();
            }
        });
//        group.getChildren().add(m4);
        ImageView m5 = new ImageView("p07.png");
        m5.setFitHeight(150);
        m5.setFitWidth(50);
        m5.setX(360.0);
        m5.setY(1.0);
        m5.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m5.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Repeater pea1=new Repeater();
                Shoo.add(pea1);
//                group.getChildren().add(pea1.getImageP());
//                group.getChildren().add(pea1.getImageP2());
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XP(event.getScreenX()-675);
                        pea1.set_YP(event.getScreenY()-280);
                        pea1.set_XP2(event.getScreenX()-675);
                        pea1.set_YP2(event.getScreenY()-280);
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=200;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m5);
        ImageView m6 = new ImageView("p15.png");
        m6.setFitHeight(150);
        m6.setFitWidth(50);
        m6.setX(430.0);
        m6.setY(1.0);
        m6.preserveRatioProperty().set(true);
//        fitHeight="150.0" fitWidth="50.0" pickOnBounds="true" preserveRatio="true" x="80.0" y="1.0"
        m6.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                TallNut pea1=new TallNut();
                Nutt.add(pea1);
//                group.getChildren().add(pea1.getImageS());
                group.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        pea1.set_XS(event.getScreenX()-685);
                        pea1.set_YS(event.getScreenY()-290);

                    }
                });
                total-=125;
                timer.setText(Integer.toString(total));
                pea1.start();


            }
        });
//        group.getChildren().add(m6);
        ImageView m7 = new ImageView("images/zombies/zombie1.png");
        ImageView m8 = new ImageView("images/zombies/zombie1.png");
        ImageView m9 = new ImageView("images/zombies/zombie1.png");
        ImageView m10 = new ImageView("images/zombies/zombie1.png");
        ImageView m11 = new ImageView("images/zombies/zombie1.png");
        ImageView m12 = new ImageView("images/zombies/zombie1.png");
        ImageView m13 = new ImageView("images/zombies/zombie1.png");
        ImageView m14 = new ImageView("images/zombies/zombie1.png");




        m7.setX(818);
        m7.setY(438);
        m7.setFitHeight(60);
        m7.setFitWidth(40);
        m8.setX(818);
        m8.setY(273);
        m8.setFitHeight(60);
        m8.setFitWidth(40);
        m9.setX(818);
        m9.setY(96);
        m9.setFitHeight(60);
        m9.setFitWidth(40);
        m10.setX(818);
        m10.setY(191);
        m10.setFitHeight(60);
        m10.setFitWidth(40);
        m11.setX(818);
        m11.setY(273);
        m11.setFitHeight(60);
        m11.setFitWidth(40);
        m12.setX(818);
        m12.setY(348);
        m12.setFitHeight(60);
        m12.setFitWidth(40);
        m13.setX(818);
        m13.setY(438);
        m13.setFitHeight(60);
        m13.setFitWidth(40);
        m14.setX(818);
        m14.setY(96);
        m14.setFitHeight(60);
        m14.setFitWidth(40);
        group.getChildren().add(m7);
        group.getChildren().add(m8);
        group.getChildren().add(m9);
        group.getChildren().add(m10);
        group.getChildren().add(m11);
        group.getChildren().add(m12);
        group.getChildren().add(m13);
        group.getChildren().add(m14);
        Zombie z1=new Zombie(4,m7,5);
        Zombie z2=new Zombie(4,m8,5);
        Zombie z3=new Zombie(4,m9,5);
        Zombie z4=new Zombie(4,m10,5);
        Zombie z5=new Zombie(4,m11,5);
        Zombie z6=new Zombie(4,m12,5);
        Zombie z7=new Zombie(4,m13,5);
        Zombie z8=new Zombie(4,m14,5);
        Zom.add(z1);
        Zom.add(z2);
        Zom.add(z3);
        Zom.add(z4);
        Zom.add(z5);
        Zom.add(z6);
        Zom.add(z7);
        Zom.add(z8);

        TranslateTransition translate_zombie1 = new TranslateTransition();
        translate_zombie1.setByX(-700);
        translate_zombie1.setDuration(Duration.millis(25000));
        translate_zombie1.setCycleCount(1);
        translate_zombie1.setAutoReverse(false);
        translate_zombie1.setNode(m7);
        translate_zombie1.setDelay(Duration.seconds(15));
        translate_zombie1.play();

        TranslateTransition translate_zombie2 = new TranslateTransition();
        translate_zombie2.setByX(-700);
        translate_zombie2.setDuration(Duration.millis(25000));
        translate_zombie2.setCycleCount(1);
        translate_zombie2.setAutoReverse(false);
        translate_zombie2.setNode(m8);
        translate_zombie2.setDelay(Duration.seconds(15));
        translate_zombie2.play();
        TranslateTransition translate_zombie3 = new TranslateTransition();
        translate_zombie3.setByX(-700);
        translate_zombie3.setDuration(Duration.millis(25000));
        translate_zombie3.setCycleCount(1);
        translate_zombie3.setAutoReverse(false);
        translate_zombie3.setNode(m9);
        translate_zombie3.setDelay(Duration.seconds(15));
        translate_zombie3.play();
        TranslateTransition translate_zombie4 = new TranslateTransition();
        translate_zombie4.setByX(-700);
        translate_zombie4.setDuration(Duration.millis(25000));
        translate_zombie4.setCycleCount(1);
        translate_zombie4.setAutoReverse(false);
        translate_zombie4.setNode(m10);
        translate_zombie4.setDelay(Duration.seconds(40));
        translate_zombie4.play();
        TranslateTransition translate_zombie5 = new TranslateTransition();
        translate_zombie5.setByX(-700);
        translate_zombie5.setDuration(Duration.millis(25000));
        translate_zombie5.setCycleCount(1);
        translate_zombie5.setAutoReverse(false);
        translate_zombie5.setNode(m11);
        translate_zombie5.setDelay(Duration.seconds(40));
        translate_zombie5.play();
        TranslateTransition translate_zombie6 = new TranslateTransition();
        translate_zombie6.setByX(-700);
        translate_zombie6.setDuration(Duration.millis(25000));
        translate_zombie6.setCycleCount(1);
        translate_zombie6.setAutoReverse(false);
        translate_zombie6.setNode(m12);
        translate_zombie6.setDelay(Duration.seconds(40));
        translate_zombie6.play();
        TranslateTransition translate_zombie7 = new TranslateTransition();
        translate_zombie7.setByX(-700);
        translate_zombie7.setDuration(Duration.millis(25000));
        translate_zombie7.setCycleCount(1);
        translate_zombie7.setAutoReverse(false);
        translate_zombie7.setNode(m13);
        translate_zombie7.setDelay(Duration.seconds(40));
        translate_zombie7.play();
        TranslateTransition translate_zombie8 = new TranslateTransition();
        translate_zombie8.setByX(-700);
        translate_zombie8.setDuration(Duration.millis(25000));
        translate_zombie8.setCycleCount(1);
        translate_zombie8.setAutoReverse(false);
        translate_zombie8.setNode(m14);
        translate_zombie8.setDelay(Duration.seconds(40));
        translate_zombie8.play();
        checkZombie();
        if(Zom.contains(z1)==false){
            m7=null;
        }
        if(Zom.contains(z2)==false){
            m8=null;
        }
        if(Zom.contains(z3)==false){
            m9=null;
        }
        if(Zom.contains(z4)==false){
            m10=null;
        }
        if(Zom.contains(z5)==false){
            m11=null;
        }
        if(Zom.contains(z6)==false){
            m12=null;
        }
        if(Zom.contains(z7)==false){
            m13=null;
        }
        if(Zom.contains(z8)==false){
            m14=null;
        }

        Scene SavedGameScene = new Scene(group);
        Stage table = (Stage)((Node)event.getSource()).getScene().getWindow();
        table.setScene(SavedGameScene);

        table.show();
    }
}
