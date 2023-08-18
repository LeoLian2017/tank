package hk.com.nexify;

public class T {
    public static void main(String[] args) {
        var t = new TankFrame();

        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t.repaint();
        }
    }
}
