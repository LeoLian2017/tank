package hk.com.nexify;

import lombok.Data;

import java.awt.*;

@Data
public class Tank {
    private int x = 200;
    private int y = 200;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        var c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        this.move();
    }

    private void move() {
        if (moving) {
            switch (dir) {
                case LEFT -> x -= SPEED;
                case RIGHT -> x += SPEED;
                case UP -> y -= SPEED;
                case DOWN -> y += SPEED;
            }
        }
    }
}
