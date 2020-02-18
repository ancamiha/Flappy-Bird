package objects;

import common.Colors;

import java.awt.*;

public class Bird extends GameObject {
    public Bird(final int x, final int y, final Type type) {
        super(x, y, type);
        //speedX = 1;
    }

    @Override
    public void tick() {
        //x += speedX;
        //y += speedY;
    }

    @Override
    public void render(final Graphics graphics) {
        graphics.setColor(Color.BLACK);
        //body & wing
        graphics.fillRect(x, y, 18, 3);
        graphics.fillRect(x - 6, y + 3, 6, 3);
        graphics.fillRect(x - 9, y + 6, 3, 3);
        graphics.fillRect(x - 15, y + 9, 12, 3);
        graphics.fillRect(x - 3, y + 12, 3, 3);
        graphics.fillRect(x , y + 15, 3, 6);
        graphics.fillRect(x - 3, y + 21, 3, 3);
        graphics.fillRect(x - 18, y + 12, 3, 9);
        graphics.fillRect(x - 15, y + 21, 3, 3);
        graphics.fillRect(x - 12, y + 24, 9, 3);
        graphics.fillRect(x - 12, y + 27, 3, 3);
        graphics.fillRect(x - 9, y + 30, 6, 3);
        graphics.fillRect(x - 3, y + 33, 15, 3);
        //eye
        graphics.fillRect(x + 18 , y + 3, 3, 3);
        graphics.fillRect(x + 21 , y + 6, 3, 3);
        graphics.fillRect(x + 18 , y + 9, 3, 6);
        graphics.fillRect(x + 24 , y + 9, 3, 9);
        graphics.fillRect(x + 9 , y + 15, 3, 3);
        graphics.fillRect(x + 6 , y + 6, 3, 9);
        graphics.fillRect(x + 9 , y + 3, 3, 3);
        //mouth
        graphics.fillRect(x + 12 , y + 18, 18, 3);
        graphics.fillRect(x + 30 , y + 21, 3, 3);
        graphics.fillRect(x + 9 , y + 21, 3, 3);
        graphics.fillRect(x + 6 , y + 24, 3, 3);
        graphics.fillRect(x + 12 , y + 24, 18, 3);
        graphics.fillRect(x + 30 , y + 21, 3, 3);
        graphics.fillRect(x + 27, y + 27, 3, 3);
        graphics.fillRect(x + 12 , y + 30, 15, 3);
        graphics.fillRect(x + 9 , y + 27, 3, 3);

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x, y + 3, 9, 3);
        graphics.fillRect(x - 6, y + 6, 12, 3);
        graphics.fillRect(x - 3, y + 9, 9, 3);
        graphics.fillRect(x - 15, y + 12, 12, 3);
        graphics.fillRect(x, y + 12, 6, 3);
        graphics.fillRect(x - 15, y + 15, 15, 3);
        graphics.fillRect(x + 3, y + 15, 6, 3);
        graphics.fillRect(x - 15, y + 18, 15, 3);
        graphics.fillRect(x + 3, y + 18, 9, 3);
        graphics.fillRect(x - 12, y + 21, 9, 3);
        graphics.fillRect(x, y + 21, 9, 3);
        graphics.fillRect(x - 3, y + 24, 15, 3);
        graphics.fillRect(x - 9, y + 27, 18, 3);
        graphics.fillRect(x - 3, y + 30, 15, 3);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(x + 12, y + 3, 6, 3);
        graphics.fillRect(x + 9 , y + 6, 12, 3);
        graphics.fillRect(x + 9, y + 9, 9, 3);
        graphics.fillRect(x + 21, y + 9, 3, 3);
        graphics.fillRect(x + 9, y + 12, 9, 3);
        graphics.fillRect(x + 21, y + 12, 3, 3);
        graphics.fillRect(x + 12, y + 15, 12, 3);

        graphics.setColor(Colors.NEW_ORANGE);
        graphics.fillRect(x + 12, y + 21, 18, 3);
        graphics.fillRect(x + 12, y + 27, 15, 3);

    }
}
