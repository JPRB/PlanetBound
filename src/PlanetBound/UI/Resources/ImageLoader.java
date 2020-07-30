package PlanetBound.UI.Resources;

import javafx.scene.image.Image;

import java.net.URL;

public final class ImageLoader {

    private final String url;

    public ImageLoader (String url) {
        this.url = url;
    }

    public Image getImagem () {
        URL uri = ImageLoader.class.getResource("Images/"+url);

        if (uri == null){
            System.out.println(url + " file not found in classPATH");
            return null;
        }

        return new Image(uri.toExternalForm());
    }

    public String getURL() {
        return url;
    }
}
