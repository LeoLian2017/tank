package hk.com.nexify;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 200, Dir.DOWN);
    Bullet b = new Bullet(200, 200, Dir.DOWN);
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        b.paint(g);
    }

    public TankFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(true);
        this.setTitle("Tank War");
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyAdapter() {
            boolean bL = false;
            boolean bU = false;
            boolean bR = false;
            boolean bD = false;

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> bL = true;
                    case KeyEvent.VK_RIGHT -> bR = true;
                    case KeyEvent.VK_UP -> bU = true;
                    case KeyEvent.VK_DOWN -> bD = true;
                }
                this.setMainTankDir();
            }

            private void setMainTankDir() {
                if (!bL && !bR && !bU && !bD) {
                    myTank.setMoving(false);
                } else {
                    myTank.setMoving(true);
                    if (bL) myTank.setDir(Dir.LEFT);
                    if (bR) myTank.setDir(Dir.RIGHT);
                    if (bU) myTank.setDir(Dir.UP);
                    if (bD) myTank.setDir(Dir.DOWN);
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> bL = false;
                    case KeyEvent.VK_RIGHT -> bR = false;
                    case KeyEvent.VK_UP -> bU = false;
                    case KeyEvent.VK_DOWN -> bD = false;
                }

            }
        });

    }
}

