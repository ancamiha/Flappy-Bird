package objects;

import java.awt.Graphics;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected Type type;
    protected int speedX;
    protected int speedY;

    public GameObject(final int x, final int y, final Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public abstract void tick();
    public abstract void render(Graphics graphics);

    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final Type getType() {
        return type;
    }
    public final int getSpeedX() {
        return speedX;
    }
    public final int getSpeedY() {
        return speedY;
    }

    public final void setX(final int x) {
        this.x = x;
    }
    public final void setY(final int y) {
        this.y = y;
    }
    public final void setType(final Type type) {
        this.type = type;
    }
    public final void setSpeedX(final int speedX) {
        this.speedX = speedX;
    }
    public final void setSpeedY(final int speedY) {
        this.speedY = speedY;
    }
}
