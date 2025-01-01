package software.ulpgc.view;

import software.ulpgc.model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDisplay extends JPanel implements Display{

    private Image currentImage;
    private BufferedImage bitmap;

    private int dragOffsetX = 0;
    private int initialX;
    private Presenter presenter;

    @Override
    public void display(Image image){
        this.currentImage = image;
        this.bitmap = load(currentImage);
        this.repaint();
    }

    @Override
    public BufferedImage current() {
        return bitmap;
    }

    public Image image(){
        return currentImage;
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    public void mouseAction(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialX = e.getX();
                dragOffsetX = 0;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (presenter != null) {
                    presenter.onDragRelease(initialX, e.getX());
                }
                dragOffsetX = 0;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dragOffsetX = e.getX() - initialX;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (currentImage != null) {
            drawImage(g);
        }
    }

    private BufferedImage load(Image image){
        try {
            String name = image.name();
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void drawImage(Graphics g) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int[] scaledDimensions = ViewPort.calculate(
                bitmap.getWidth(),
                bitmap.getHeight(),
                panelWidth,
                panelHeight
        );

        int scaledWidth = scaledDimensions[0];
        int scaledHeight = scaledDimensions[1];

        int x = (panelWidth - scaledWidth) / 2 + dragOffsetX;
        int y = (panelHeight - scaledHeight) / 2;

        g.drawImage(bitmap, x, y, scaledWidth, scaledHeight, null);
    }
}
