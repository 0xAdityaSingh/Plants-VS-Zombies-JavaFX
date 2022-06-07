package sample;

public class SunToken {
    public static void main(String[] args) {
        int Total;
//        Plant plant=new Plant();
        GetSet_ gs=new GetSet_();
        gs.setSun(0);
        gs.setTime(0);
    }

}
class GetSet_{
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
