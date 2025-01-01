package software.ulpgc.control.io;

import software.ulpgc.model.Image;

import java.io.File;
import java.io.FileFilter;

public class FileImageLoader implements ImageLoader{
    private final File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(imageTypes());
    }

    private FileFilter imageTypes() {
        return (File pathname) -> pathname.getName().endsWith(".jpg");
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                if (files != null) {
                    return files[i].getAbsolutePath();
                }
                return "";
            }

            @Override
            public Image next() {
                if (files != null) {
                    return imageAt((i+1) % files.length);
                }
                return null;
            }

            @Override
            public Image previous() {
                if (files != null) {
                    return imageAt((i-1 + files.length) % files.length);
                }
                return null;
            }
        };
    }
}
