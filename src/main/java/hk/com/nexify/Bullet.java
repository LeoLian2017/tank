package hk.com.nexify;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data
@AllArgsConstructor
public class Bullet {
    private static final int SPEED = 7;
    private static final int WEIGHT = 30;
    private static final int HEIGHT = 30;
    private int x;
    private int y;
    private Dir dir;

    public void paint(Graphics g) {
        var c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WEIGHT, HEIGHT);
        g.setColor(c);
        this.move();
    }

    private void move() {
        switch (dir) {
            case LEFT -> x -= SPEED;
            case RIGHT -> x += SPEED;
            case UP -> y -= SPEED;
            case DOWN -> y += SPEED;
        }

    }
}
