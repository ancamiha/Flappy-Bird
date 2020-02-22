package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import common.Colors;
import objects.Bird;
import objects.Tubes;
import objects.Type;
import window.Window;
import common.Constants;

public class Game extends Canvas implements Runnable, KeyListener {
    private static final long serialVersionUID = 3581940693392704995L;
    private Thread thread;
    private boolean running = false;
    private Tubes tubes;
    private Bird bird;

    public Game() {
        final int seconds = 90;
        //
        addKeyListener(this);
        new Window(this, Constants.WIDTH, Constants.HEIGHT, "Flappy Bird");
        tubes = new Tubes(seconds);
        bird = new Bird(Constants.WIDTH / 2 - Constants.MAX_WB,
                Constants.HEIGHT / 2 - Constants.MAX_HB - Constants.SIZE3, Type.Player);
    }
    public final synchronized void start() {
        if (running) {
            return;
        }
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    private synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            //killing/stopping the thread
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    //game loop
    @Override
    public void run() {
        //current time in nanoseconds
        long lastTime = System.nanoTime();
        //nanoseconds per tick(second)
        final double ns = 1000000000 / 60.0;
        double delta = 0;
        //get current time
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            //current time in nanoseconds current loop
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
                render();
                frames++;
            }

            final int condition = 1000;
            //if one seconds has passed
            if (System.currentTimeMillis() - timer >= condition) {
                timer += condition;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        bird.tick();
        tubes.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            final int numBuffers = 3;
            this.createBufferStrategy(numBuffers);
            return;
        }
        //scene
        Graphics graphics = bs.getDrawGraphics();
        graphics.setColor(Colors.MY_BLUE);
        graphics.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        graphics.setColor(Colors.MY_GRASS);
        graphics.fillRect(0, Constants.HEIGHT - Constants.SIZE1,
                            Constants.WIDTH, Constants.SIZE1);
        graphics.setColor(Colors.GREEN);
        graphics.fillRect(0, Constants.HEIGHT - Constants.SIZE2,
                            Constants.WIDTH, Constants.SIZE3);
        graphics.setColor(Colors.DARK_GREEN);
        graphics.fillRect(0, Constants.HEIGHT - Constants.SIZE2,
                Constants.WIDTH, Constants.SIZE4);
        graphics.fillRect(0, Constants.HEIGHT - Constants.SIZE1,
                Constants.WIDTH, Constants.SIZE4);

        bird.render(graphics);
        tubes.render(graphics);
        graphics.dispose();
        bs.show();
    }

    @Override
    public final void keyTyped(final KeyEvent e) { }

    @Override
    public final void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bird.setPressed(true);
        }
    }

    @Override
    public final void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bird.setPressed(false);
        }
    }
}
