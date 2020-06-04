package PlanetBound.UI.Resources;

import javafx.scene.image.Image;

import java.net.URL;


public class ImageLoader1 {
    private final String url;

    public ImageLoader1 (String url) {
        this.url = url;
    }

    public Image getImagem () {
        System.out.println(url);
        URL uri = getClass().getClassLoader().getResource(url);

        if (uri == null){
            System.out.println(url + " file not found in classPATH");
            return null;
        }

        return new Image(uri.toExternalForm());
    }

    public String getURL() {
        //System.out.println(getClass().getResource(url).toString());
        return url;
    }
}