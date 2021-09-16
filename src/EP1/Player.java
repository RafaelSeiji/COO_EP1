package EP1;

import java.awt.Color;

public class Player {
    private double cx;
    private double cy;
    private double width;
    private double height;
    private Color color;
    private String id;
    private double[] v_limit;
    private double speed;


    public Player(double cx, double cy, double width, double height, Color color, String id, double[] v_limit, double speed) {
        this.cx = cx;
        this.cy = cy;
        this.width = width;
        this.height = height;
        this.color = color;
        this.id = id;
        this.v_limit = v_limit;
        this.speed = speed;
    }

    public void draw() {
        if(getId() == "Player 1") {
            GameLib.setColor(Color.GREEN);
            GameLib.fillRect(cx, cy, width, height);
        }else if(getId() == "Player 2"){
            GameLib.setColor(Color.BLUE);
            GameLib.fillRect(cx, cy, width, height);
        }
    }
    public void moveUp(long var1) {
        //RETIRAR COMENTARIO P/ + SPEED
        //speed = var1;
        if(cy>v_limit[0]+height/2+2){
            cy-=speed;
        }

    }

    public void moveDown(long var1) {
        //RETIRAR COMENTARIO P/ + SPEED
        //speed = var1;
        if(cy<v_limit[1]-height/2-2) {
            cy += speed;
        }
    }

    public String getId() {
        return id;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }
    public double getSpeed(){
        return speed;
    }
}
