package sample;import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Shooter {
    boolean t=false,f=true,setbool=false;
    public ImageView img3 = new ImageView("images/pea.png");
    public ImageView img2 = new ImageView("images/pea.png");
    public ImageView Shooter = new ImageView("images/plants/peashooter.gif");
    public ImageView getImageS(){
        return Shooter;
    }
    public ImageView getImageP(){
        return img2;
    }
    public void setbool(boolean k){
        this.setbool=true;
    }
    public ImageView getImageP2(){
        return img3;
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
    public void set_XP2(double x){
        img3.setX(x);
    }
    public void set_YP2(double y){
        img3.setY(y);
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
        img3.setFitWidth(20);
        img3.setFitHeight(20);
        img3.setX(-300);
        img3.setY(-206);
        TranslateTransition translate_pea = new TranslateTransition();
        translate_pea.setByX(600);
        translate_pea.setDuration(Duration.millis(3500));
        translate_pea.setCycleCount(25);

        translate_pea.setAutoReverse(false);
        translate_pea.setNode(img2);
        translate_pea.play();
        if(setbool==true){

            translate_pea.play();
            TranslateTransition translate_pea1 = new TranslateTransition();
            translate_pea1.setByX(600);
            translate_pea1.setDuration(Duration.millis(3200));
            translate_pea1.setCycleCount(25);
            translate_pea1.setAutoReverse(false);
            translate_pea.setDelay(Duration.seconds(2));
            translate_pea1.setNode(img3);
            translate_pea1.play();
        }

    }

}








