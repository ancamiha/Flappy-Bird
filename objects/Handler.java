package objects;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    private LinkedList<GameObject> gameObjects = new LinkedList<>();
    public final void tick() {
        for (GameObject object : gameObjects) {
            object.tick();
        }
    }
    public final void render(final Graphics graphics) {
        for (GameObject object : gameObjects) {
            object.render(graphics);
        }
    }
    public final void add(final GameObject object) {
        this.gameObjects.add(object);
    }
    public final void remove(final GameObject object) {
        this.gameObjects.remove(object);
    }
}
