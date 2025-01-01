package software.ulpgc.view;

import software.ulpgc.model.Image;

public class Presenter {
    private final MainFrame view;
    private Image image;

    public Presenter(MainFrame view, Image image) {
        this.view = view;
        this.image = image;

        updateView();
    }

    public void onDragRelease(int initialX, int finalX) {
        int dragDistance = finalX - initialX;

        if (dragDistance > 50) {
            image = image.previous();
        } else if (dragDistance < -50) {
            image = image.next();
        }

        updateView();
    }

    private void updateView() {
        view.display.display(image);
    }
}
