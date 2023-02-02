import javax.swing.*;

public class Tank {
    private double füllstand;
    private boolean leer;
    public Tank(double füllstand){
        this.füllstand = füllstand;
    }

    public double getFüllstand() {
        return füllstand;
    }
    public void setFüllstand(){
        if(!leer) this.füllstand -= 0.5;
        else this.füllstand += 0.5;
    }
    public void setLeer(boolean leer){
        this.leer = leer;
    }
    public boolean getLeer(){
        return leer;
    }
}
