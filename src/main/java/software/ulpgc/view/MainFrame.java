package software.ulpgc.view;

import software.ulpgc.model.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public final ImageDisplay display;
    private final JButton nextButton = new JButton("Next");
    private final JButton previousButton = new JButton("Previous");

    public MainFrame(){
        setTitle("Money Calculator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        display = new ImageDisplay();
        add(display);
        add(toolBar(), BorderLayout.SOUTH);
        display.mouseAction();
    }

    public MainFrame put(Image image) {
        display.display(image);
        return this;
    }

    private JPanel toolBar() {
        JPanel jPanel = new JPanel();

        jPanel.add(previousButton);
        jPanel.add(nextButton);

        return jPanel;
    }

    public void nextImage(ActionListener listener){
        nextButton.addActionListener(listener);
    }

    public void previousImage(ActionListener listener){
        previousButton.addActionListener(listener);
    }
}
