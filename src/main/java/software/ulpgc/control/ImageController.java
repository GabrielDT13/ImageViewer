package software.ulpgc.control;

import software.ulpgc.control.commands.NextImageCommand;
import software.ulpgc.control.commands.PreviousImageCommand;
import software.ulpgc.view.MainFrame;

public class ImageController {
    private final MainFrame view;

    public ImageController(MainFrame view) {
        this.view = view;

        view.nextImage(e -> nextImage());
        view.previousImage(e -> previousImage());
    }

    private void previousImage() {
        PreviousImageCommand command = new PreviousImageCommand(view.display);
        command.execute();
    }

    private void nextImage() {
        NextImageCommand command = new NextImageCommand(view.display);
        command.execute();
    }
}
