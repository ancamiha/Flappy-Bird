package objects;

import common.Colors;
import common.Constants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Singleton class.
 */
public final class DrawBird extends Rectangle {
    private static DrawBird instance;
    private DrawBird() {
    }
    public static DrawBird getInstance() {
        if (instance == null) {
            instance = new DrawBird();
        }
        return instance;
    }

    static void drawBird(final Bird bird, final Graphics graphics) {
        final int three = 3;
        final int six = 6;
        final int nine = 9;
        final int twelve = 12;
        final int fifteen = 15;
        final int eighteen = 18;
        final int tOne = 21;
        final int tFour =  24;
        final int tSeven = 27;
        final int thirty = 30;
        final int thThree = 33;
        final int x = (int) bird.getX();
        final int y = (int) bird.getY();

        //transparent frame
        graphics.setColor(Colors.TRANSPARENT);
        graphics.fillRect(x - eighteen, y, Constants.MAX_WB + tOne, Constants.MAX_HB + three);
        //set color for contour
        graphics.setColor(Color.BLACK);
        //body & wing
        graphics.fillRect(x, y, eighteen, three);
        graphics.fillRect(x - six, y + three, six, three);
        graphics.fillRect(x - nine, y + six, three, three);
        graphics.fillRect(x - fifteen, y + nine, twelve, three);
        graphics.fillRect(x - three, y + twelve, three, three);
        graphics.fillRect(x, y + fifteen, three, six);
        graphics.fillRect(x - three, y + tOne, three, three);
        graphics.fillRect(x - eighteen, y + twelve, three, nine);
        graphics.fillRect(x - fifteen, y + tOne, three, three);
        graphics.fillRect(x - twelve, y + tFour, nine, three);
        graphics.fillRect(x - twelve, y + tSeven, three, three);
        graphics.fillRect(x - nine, y + thirty, six, three);
        graphics.fillRect(x - three, y + thThree, fifteen, three);
        //eye
        graphics.fillRect(x + eighteen, y + three, three, three);
        graphics.fillRect(x + tOne, y + six, three, three);
        graphics.fillRect(x + eighteen, y + nine, three, six);
        graphics.fillRect(x + tFour, y + nine, three, nine);
        graphics.fillRect(x + nine, y + fifteen, three, three);
        graphics.fillRect(x + six, y + six, three, nine);
        graphics.fillRect(x + nine, y + three, three, three);
        //mouth
        graphics.fillRect(x + twelve, y + eighteen, eighteen, three);
        graphics.fillRect(x + thirty, y + tOne, three, three);
        graphics.fillRect(x + nine, y + tOne, three, three);
        graphics.fillRect(x + six, y + tFour, three, three);
        graphics.fillRect(x + twelve, y + tFour, eighteen, three);
        graphics.fillRect(x + thirty, y + tOne, three, three);
        graphics.fillRect(x + tSeven, y + tSeven, three, three);
        graphics.fillRect(x + twelve, y + thirty, fifteen, three);
        graphics.fillRect(x + nine, y + tSeven, three, three);

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x, y + three, nine, three);
        graphics.fillRect(x - six, y + six, twelve, three);
        graphics.fillRect(x - three, y + nine, nine, three);
        graphics.fillRect(x - fifteen, y + twelve, twelve, three);
        graphics.fillRect(x, y + twelve, six, three);
        graphics.fillRect(x - fifteen, y + fifteen, fifteen, three);
        graphics.fillRect(x + three, y + fifteen, six, three);
        graphics.fillRect(x - fifteen, y + eighteen, fifteen, three);
        graphics.fillRect(x + three, y + eighteen, nine, three);
        graphics.fillRect(x - twelve, y + tOne, nine, three);
        graphics.fillRect(x, y + tOne, nine, three);
        graphics.fillRect(x - three, y + tFour, fifteen, three);
        graphics.fillRect(x - nine, y + tSeven, eighteen, three);
        graphics.fillRect(x - three, y + thirty, fifteen, three);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(x + twelve, y + three, six, three);
        graphics.fillRect(x + nine, y + six, twelve, three);
        graphics.fillRect(x + nine, y + nine, nine, three);
        graphics.fillRect(x + tOne, y + nine, three, three);
        graphics.fillRect(x + nine, y + twelve, nine, three);
        graphics.fillRect(x + tOne, y + twelve, three, three);
        graphics.fillRect(x + twelve, y + fifteen, twelve, three);

        graphics.setColor(Colors.NEW_ORANGE);
        graphics.fillRect(x + twelve, y + tOne, eighteen, three);
        graphics.fillRect(x + twelve, y + tSeven, fifteen, three);
    }
}
