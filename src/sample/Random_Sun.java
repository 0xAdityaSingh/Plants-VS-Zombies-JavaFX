package sample;

public class Random_Sun extends position {

    public static void main(String[] args) {
    int Sun,Time;
    GetSet gs=new GetSet();
    gs.setSun(0);
    gs.setTime(0);
    }

}
class GetSet{
    int Sun,Time;
    public void setSun(int Sun){
    this.Sun=Sun;
    }
    public void setTime(int Time){
        this.Time=Time;
    }
    public int getSun(){
        return Sun;
    }
    public int getTime(){
        return Time;
    }
}
