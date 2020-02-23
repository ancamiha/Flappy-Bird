package objects;

import common.Constants;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bird extends Rectangle {
    private static final long serialVersionUID = -4821975717950705473L;
    private int ticks = 0;
    private int x;
    private int y;
    private int speedY;
    private boolean isPressed = false;
    private ArrayList<Rectangle> tubes;
    private Tubes check;
    private boolean gameOver = false;
    private boolean started = false;
    private int score = 0;
    //constructor
    public Bird(final int x, final int y, final Type type, final Tubes tubes) {
        this.x = x;
        this.y = y;
        this.setSpeedY(0);
        this.tubes = tubes.getTubes();
        this.check = tubes;
    }
    //getters
    public final double getX() {
        return x;
    }
    public final double getY() {
        return y;
    }
    public final int getSpeedY() {
        return speedY;
    }
    public final int getScore() {
        return score;
    }
    public final boolean isGameOver() {
        return gameOver;
    }
    public final boolean isStarted() {
        return started;
    }
    //setters
    public final void setX(final int x) {
        this.x = x;
    }
    public final void setY(final int y) {
        this.y = y;
    }
    public final void setPressed(final boolean pressed) {
        isPressed = pressed;
    }
    public final void setSpeedY(final int speedY) {
        this.speedY = speedY;
    }
    public final void setStarted(final boolean started) {
        this.started = started;
    }
    //updates
    public final void updateY(final int c) {
        this.y = this.y + c;
    }
    public final void updateSpeedY(final int speed) {
        this.speedY = this.speedY + speed;
    }
    //
    public final void tick() {
        //keep the bird above the grass
        final int maxSpeed = 25;
        this.ticks++;
        if (this.ticks % 2 == 0 && this.getSpeedY() < maxSpeed) {
            this.updateSpeedY(2);
            this.updateY(this.getSpeedY());
        }
        //
        final int speed = 4;
        if (isPressed) {
            if (!this.isStarted()) {
                this.setStarted(true);
            }
            //set up limit
            if (this.getY() - speed <= 0) {
                this.updateSpeedY(0);
            } else {
                this.updateY(-speed);
            }
        } else {
            //set down limit
            if (this.getY() + speed >= Constants.HEIGHT - Constants.SIZE2 - Constants.MAX_HB) {
                if (!started) {
                    this.setSpeedY(Constants.HEIGHT - Constants.SIZE2 - Constants.MAX_HB);
                } else {
                    this.updateSpeedY(0);
                }
            } else {
                this.updateY(speed);
            }
        }
        //
        for (Rectangle tube : tubes) {
            int tubeX = (int) tube.getX();
            int tubeY = (int) tube.getY();
            int tubeH = (int) tube.getHeight();
            // if the bird passed by the tube the score increase
            if (tube.getY() == 0
                    && this.getX() + this.getWidth() > tube.getX() + tube.getWidth()
                    && this.getX() + this.getWidth() <= tube.getX() + tube.getWidth() + 2) {
                score++;
            }
            //check for collisions
            if (this.intersects(tube)) {
                gameOver = true;
                check.setStopped(true);
            }
        }
    }

    public final void render(final Graphics graphics) {
        DrawBird.drawBird(this, graphics);
    }

    @Override
    public final boolean intersects(final Rectangle r) {
        return super.intersects(r);
    }
}
