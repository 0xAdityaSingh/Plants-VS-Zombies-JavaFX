package sample;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SunFlower {

    boolean t=false,f=true;

    ImageView img2 = new ImageView("images/sun.png");//Button button5=new Button().setGraphic(img2);
    ImageView Shooter = new ImageView("images/plants/sunflower.gif");


    public ImageView getImageS(){
        return Shooter;
    }
    public ImageView getImageP(){
        return img2;
    }
    public void set_t(boolean x){
        this.t=t;
    }
    public void set_f(boolean f){
        this.f=f;
    }
    public boolean get_t(){
        return t;
    }
    public boolean get_f(){
        return f;
    }
    public void set_XP(double x){
        img2.setX(x);
    }
    public void set_YP(double y){
        img2.setY(y);
    }
    public void set_XS(double x){
        Shooter.setX(x);
    }
    public void set_YS(double y){
        Shooter.setY(y);
    }
    public void start(){
        Shooter.setFitWidth(53);
        Shooter.setFitHeight(150);
        Shooter.setY(-200);
        Shooter.setX(-263);
        Shooter.setPreserveRatio(true);
        img2.setFitWidth(20);
        img2.setFitHeight(20);
        img2.setX(-300);
        img2.setY(-206);
//        img2.setOnMouseClicked();
    }

}
