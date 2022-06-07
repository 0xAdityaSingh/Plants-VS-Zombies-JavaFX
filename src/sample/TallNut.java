package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class TallNut extends Nut {
    ImageView Shooter = new ImageView("tallnut.png");

    public TallNut(){
        super.Shooter=this.Shooter;
        super.start();
    }

}
