package software.ulpgc.control.commands;

import software.ulpgc.view.ImageDisplay;
import software.ulpgc.view.MainFrame;

public class PreviousImageCommand implements Command{
    private final ImageDisplay view;

    public PreviousImageCommand(ImageDisplay view) {
        this.view = view;
    }

    public void execute() {
        view.display(view.image().previous());
    }
}
