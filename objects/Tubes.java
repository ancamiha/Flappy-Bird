package objects;

import common.Colors;
import common.Constants;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Tubes {
    private static final long serialVersionUID = 2816462330440679201L;
    private ArrayList<Rectangle> tubes;
    private int time;
    private int currTime;
    private Random random;
    private boolean stopped;
    //constructor
    public Tubes(final int time, final boolean stopped) {
        this.tubes = new ArrayList<>();
        this.time = time;
        this.random = new Random();
        Type type = Type.Object;
        this.stopped = stopped;
    }

    public final boolean isNotStopped() {
        return stopped;
    }
    final ArrayList<Rectangle> getTubes() {
        return tubes;
    }
    public final void setStopped(final boolean stopped) {
        this.stopped = stopped;
    }

    public final void tick() {
        //if the game is not started don't create tubes
        if (!this.stopped) {
            this.currTime++;
            if (this.currTime == this.time) {
                //Create a new tube
                this.currTime = 0;
                int x = Constants.WIDTH;
                //first tube
                int y1 = 0;
                int height1 = random.nextInt(Constants.HEIGHT / 2);
                //second tube
                final int space = 130;
                int y2 = height1 + space;
                int height2 = Constants.HEIGHT - y2 - Constants.SIZE2;
                tubes.add(new Rectangle(x, 0, Constants.TUBE_W, height1));
                tubes.add(new Rectangle(x, y2, Constants.TUBE_W, height2));
            }

            final int speed = 4;
            for (int i = 0; i < tubes.size(); i++) {
                Rectangle r = tubes.get(i);
                //the speed of the tubes
                r.x -= speed;
                //remove the already seen tubes
                if (r.x + Constants.TUBE_W <= -Constants.MAX_WB) {
                    tubes.remove(i--);
                }
            }
        }
    }

    public final void render(final Graphics graphics) {
        graphics.setColor(Colors.DARK_GREEN);

        for (Rectangle r : tubes) {
            graphics.fillRect(r.x, r.y, r.width, r.height);
        }
    }
}
