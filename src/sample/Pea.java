package sample;import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Pea extends Shooter {
    ImageView img2 = new ImageView("images/pea.png");
    public ImageView getImage(){
        return img2;
    }
    public void start(){

        img2.setFitWidth(20);
        img2.setFitHeight(20);
        img2.setX(300);
        img2.setY(206);
        TranslateTransition translate_pea = new TranslateTransition();
        translate_pea.setByX(400);
        translate_pea.setDuration(Duration.millis(2500));
        translate_pea.setCycleCount(25);
        translate_pea.setAutoReverse(false);
        translate_pea.setNode(img2);
        translate_pea.play();
    }

}
