package software.ulpgc.view;

import software.ulpgc.model.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface Display {
    void display(Image Image) throws IOException;
    BufferedImage current();
}
