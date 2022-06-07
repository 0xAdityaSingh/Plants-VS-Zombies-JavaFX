package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {
    private SimpleStringProperty name;
    private SimpleIntegerProperty level;
    private SimpleIntegerProperty scoretotal;

    public Data(String name, int level, int scoretotal) {
        this.name = new SimpleStringProperty(name);
        this.level = new SimpleIntegerProperty(level);
        this.scoretotal = new SimpleIntegerProperty(scoretotal);
    }

    public Data() {
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getLevel() {
        return level.get();
    }

    public void setLevel(int level) {
        this.level = new SimpleIntegerProperty(level);
    }

    public int getScoretotal() {
        return scoretotal.get();
    }

    public void setScoretotal(int scoretotal) {
        this.scoretotal = new SimpleIntegerProperty(scoretotal);
    }
}
