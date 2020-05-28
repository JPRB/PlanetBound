package PlanetBound.UI.GUI.Buttons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CaptionButton extends Button {


    private final ImageView img;
    private final BorderPane bp;

    public CaptionButton (String caption, Image image, int height, int width) {

        bp = new BorderPane();
        VBox cap = new VBox(new Label(caption));
        cap.setAlignment(Pos.BOTTOM_CENTER);


        //Personagem Captain
        img = new ImageView();
        img.setImage(image);
        img.setFitHeight(height-50);
        img.setFitWidth(width-50);


        bp.setCenter(img);
        bp.setBottom(cap);


        //btn = new Button();
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(30.0), Insets.EMPTY)));
        this.setGraphic(bp);
        this.setMinHeight(height);
        this.setMinWidth(width);

    }


}