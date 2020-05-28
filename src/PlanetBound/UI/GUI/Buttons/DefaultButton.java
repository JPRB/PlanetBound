package PlanetBound.UI.GUI.Buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DefaultButton extends Button {

    private ImageView img;

    public DefaultButton(String Name, Image image, double width, double height, boolean label) {

        super(Name);

        if (image != null){
            img = new ImageView(image);
            img.setFitHeight(height);
            img.setFitWidth(width);

            this.setGraphic(img);
            this.getStyleClass().add("DefaultButton");
        }

        this.setPrefWidth(width);
        this.setPrefHeight(height);

    }

}