package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Repeater extends Shooter {
    boolean t=false,f=true,setbool=false;
    ImageView img3 = new ImageView("images/pea.png");
    ImageView img2 = new ImageView("images/pea.png");
    ImageView Shooter = new ImageView("repeater.png");

public Repeater(){

    super.Shooter=this.Shooter;
    super.Shooter.setFitWidth(103);
    super.Shooter.setFitHeight(250);
    super.setbool=true;
    super.start();
}

}
