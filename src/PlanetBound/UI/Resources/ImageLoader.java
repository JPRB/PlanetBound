package PlanetBound.UI.Resources;

import javafx.scene.image.Image;

import java.net.URL;

public final class ImageLoader {
   /* private static final Map<ImgConstants, Image> imagens = new HashMap<>();


    static {
        imagens.put(ImgConstants.CURSOR, new Image("Images/cursor.png"));
        imagens.put(ImgConstants.SPACESHIP_MILITAR, new Image("Images/spaceship-militar.png"));
        imagens.put(ImgConstants.SPACESHIP_EXPLORER, new Image("Images/spaceship-explorer.png"));
        imagens.put(ImgConstants.SPACE, new Image("Images/space.png"));
        imagens.put(ImgConstants.FUEL, new Image("Images/fuel.jpg"));

    }

    public static Image getImage(ImgConstants name) {
        Image img = imagens.get(name);
        if (img == null) {
            return loadImage(name);
        }
        return img;
    }

    public static Image loadImage(ImgConstants name) {
        try {
            Image img = new Image(ImageLoader.class.getResourceAsStream("Images/" + name.getName()));
            if (img != null) {
                imagens.put(name, img);
                return img;
            }
        } catch (Exception e) {
        }
        return null;
    }*/

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
        //System.out.println(getClass().getResource(url).toString());
        return url;
    }
}
