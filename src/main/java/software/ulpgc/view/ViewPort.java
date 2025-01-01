package software.ulpgc.view;

public class ViewPort {
    public static int[] calculate(int imageWidth, int imageHeight, int containerWidth, int containerHeight) {
        double aspectRatio = (double) imageWidth / imageHeight;

        int scaledWidth;
        int scaledHeight;

        if (containerWidth / aspectRatio <= containerHeight) {
            scaledWidth = containerWidth;
            scaledHeight = (int) (containerWidth / aspectRatio);
        } else {
            scaledWidth = (int) (containerHeight * aspectRatio);
            scaledHeight = containerHeight;
        }

        return new int[]{scaledWidth, scaledHeight};
    }
}
