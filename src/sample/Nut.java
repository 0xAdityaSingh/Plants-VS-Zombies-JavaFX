package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Nut {
    ImageView Shooter = new ImageView("walnut_full_life.gif");
    public ImageView getImageS(){
        return Shooter;
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

    }

}
