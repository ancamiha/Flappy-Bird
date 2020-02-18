package window;

import game.Game;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window  extends Canvas {
    private static final long serialVersionUID = -81887243200810618L;

    /**
     * Constructs a new Canvas.
     */
    public Window(final Game game, final int width, final int height, final String title) {
        //the frame of our window
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //the window will open in the center of our screen not in the top-left
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

//        ImageIcon icon = new ImageIcon("blue-flappy-bird-clipart.jpg");
//        JLabel label = new JLabel(icon);
//        frame.add(label);
    }
}
