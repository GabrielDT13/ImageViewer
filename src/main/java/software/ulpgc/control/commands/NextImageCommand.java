package software.ulpgc.control.commands;

import software.ulpgc.view.ImageDisplay;
import software.ulpgc.view.MainFrame;

public class NextImageCommand implements Command{
    private final ImageDisplay view;

    public NextImageCommand(ImageDisplay view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.display(view.image().next());
    }
}
