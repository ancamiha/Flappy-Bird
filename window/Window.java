package window;

import game.Game;
import objects.Bird;
import javax.swing.JFrame;
import javax.swing.Renderer;
import java.awt.Dimension;

public class Window {
    private static final long serialVersionUID = -81887243200810618L;
    private static Bird bird;
    private static Renderer renderer;

    /**
     * Constructs a new Canvas.
     */
    public Window(final Game game, final int width, final int height, final String title) {
        //the frame of our window
        JFrame frame = new JFrame(title);

        //frame.addMouseListener(new MyMouse());
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //the window will open in the center of our screen not in the top-left
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
