package PlanetBound.UI.GUI.Buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CaptionButton extends Button {


    private final ImageView img;
    private final BorderPane bp;
    private Color color;
    private  CornerRadii cornerRadii;
    private Insets insets;

    public CaptionButton (String caption, Image image, int height, int width) {

       this(caption, image, 0, 0, height, width);

    }

    public CaptionButton (String caption, Image image, int heightImg, int widthImg, int height, int width) {

        color = Color.WHITE;
        cornerRadii = new CornerRadii(30.0);
        insets = Insets.EMPTY;

        bp = new BorderPane();
        VBox cap = new VBox(new Label(caption));
        cap.setAlignment(Pos.BOTTOM_CENTER);

        //Personagem Captain
        img = new ImageView();
        img.setImage(image);
        if (image != null) {
            if (heightImg > 0 && widthImg > 0) {
                img.setFitHeight(heightImg);
                img.setFitWidth(widthImg);
            } else {
                img.setFitHeight(height - 50);
                img.setFitWidth(width - 50);
            }

            bp.setCenter(img);
            bp.setBottom(cap);
        }else {
            if (caption.isEmpty()) {
                bp.setCenter(img);
            }
            else
            {
                cap.setAlignment(Pos.CENTER);
                bp.setCenter(cap);
            }
        }


        //btn = new Button();
        setBackGround();
        this.setGraphic(bp);
        this.setMinHeight(height);
        this.setMinWidth(width);

    }

    public void setBackGround() {
        this.setBackground(new Background(new BackgroundFill(color, cornerRadii, insets)));
    }

    public void setImg (Image img){
        this.img.setImage(img);
    }

    public final void setColor (String color){
        setColor(Color.valueOf(color));
    }

    public void setColor (Color color) {
        this.color = color;
        this.setBackGround();
    }

    public Color getColor () {
        return color;
    }

    public void setCornerRadii (CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }

    public CornerRadii getCornerRadii () {
        return cornerRadii;
    }

    public void setInsets (Insets insets) {
        this.insets = insets;
    }
}