package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class Tile extends Rectangle {

   public Tile(int x, int y){

       setWidth(Main.tileSize);
       setHeight(Main.tileSize);

       setFill(Color.PINK);
       setStroke(Color.BLACK);
    }
}
