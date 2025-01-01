package software.ulpgc;

import software.ulpgc.control.ImageController;
import software.ulpgc.control.io.FileImageLoader;
import software.ulpgc.model.Image;
import software.ulpgc.view.MainFrame;
import software.ulpgc.view.Presenter;

import java.io.File;

public class Main {
    private static final MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        File file = new File("Images");
        FileImageLoader loader = new FileImageLoader(file);
        Image image = loader.load();

        new ImageController(mainFrame);
        Presenter presenter = new Presenter(mainFrame, image);
        mainFrame.display.setPresenter(presenter);

        display(image);
    }

    private static void display(Image image){
        mainFrame.put(image);
        mainFrame.setVisible(true);
    }
}
