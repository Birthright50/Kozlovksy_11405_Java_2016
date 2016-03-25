import java.io.Serializable;

/**
 * Created by Birthright on 04.12.2015.
 */
public class Message implements Serializable {
    private boolean pass;
    private int x;
    private int y;
    private StoneColor color;
    private double points;
    private boolean yesToPass;
    private int my_territory;
    private int enemy_territory;
    private boolean equals_counting = false;

    public Message(boolean equals_counting) {
        this.equals_counting = equals_counting;
    }

    public boolean isEquals_counting() {

        return equals_counting;
    }

    public void setEquals_counting(boolean equals_counting) {
        this.equals_counting = equals_counting;
    }

    public int getMy_territory() {
        return my_territory;
    }

    public void setMy_territory(int my_territory) {
        this.my_territory = my_territory;
    }

    public int getEnemy_territory() {
        return enemy_territory;
    }

    public void setEnemy_territory(int enemy_territory) {
        this.enemy_territory = enemy_territory;
    }

    public Message(int my_territory, int enemy_territory) {
        this.my_territory = my_territory;
        this.enemy_territory = enemy_territory;
    }

    public boolean isYesToPass() {
        return yesToPass;
    }

    public void setYesToPass(boolean yesToPass) {
        this.yesToPass = yesToPass;
    }

    public StoneColor getColor() {
        return color;
    }

    public void setColor(StoneColor color) {
        this.color = color;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Message(boolean pass, int x, int y, StoneColor stoneColor, double points, boolean yesToPass) {
        this.color = stoneColor;
        this.pass = pass;
        this.x = x;
        this.y = y;
        this.points = points;
        this.yesToPass = yesToPass;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
