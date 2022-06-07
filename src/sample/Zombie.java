package sample;


import javafx.scene.image.ImageView;

class Zombie{
    public int health,damage;
    public ImageView m;
    public Zombie(int health,ImageView m, int damage){
        this.damage=damage;
        this.health=health;
        this.m=m;

    }
    public int getDamage(){
        return damage;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health=health;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }

}
