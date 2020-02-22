package objects;

import java.awt.Graphics;

public class Bird {
    private int ticks = 0;
    private int x;
    private int y;
    private Type type;
    private int speedY;
    private final int speed = 4;
    private boolean isPressed = false;

    public Bird(final int x, final int y, final Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.setSpeedY(0);
    }
    //getters
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final int getSpeedY() {
        return speedY;
    }
    //setters
    public final void setPressed(final boolean pressed) {
        isPressed = pressed;
    }
    public final void setSpeedY(final int speedY) {
        this.speedY = speedY;
    }
    //updates
    public final void updateY(final int c) {
        this.y = this.y + c;
    }
    public final void updateSpeedY(final int speedN) {
        this.speedY = this.speedY + speedN;
    }
    //
    public final void tick() {
        //keep the bird above the grass
        final int maxSpeed = 25;
        if (isPressed) {
            this.updateY(-speed);
        } else {
            this.updateY(speed);
        }
//        final int maxSpeed = 25;
//        this.ticks++;
//        if (this.ticks % 2 == 0 && this.getSpeedY() < maxSpeed) {
//            this.updateSpeedY(2);
//            this.updateY(this.getSpeedY());
//        }
    }

    public final void render(final Graphics graphics) {
        DrawBird.drawBird(this, graphics);
    }

    public final void jump() {
        final int ten = 10;
        if (this.speedY >= 0) {
            this.speedY = 0;
        }
        this.speedY -= ten;
        this.y += this.speedY;
    }
}
