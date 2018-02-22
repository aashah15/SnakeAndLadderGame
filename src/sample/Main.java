package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public int cirPos[][] = new int[10][10];
    public int ladderPos[][] = new int[6][3];

    public int rand;
    public Label randResult;
    public Label gameResult;

    public static final int tileSize = 80;
    public static final int width = 10;
    public static final int height = 10;

    public Circle player1;
    public Circle player2;

    public int player1Position = 1;
    public int player2Position = 1;

    public boolean player1Turn = true;
    public boolean player2Turn = true;

    public static int player1XPos = 150;
    public static int player1YPos = 840;

    public static int player2XPos = 640;
    public static int player2YPos = 840;

    public int posCir1 = 1;
    public int posCir2 = 1;

    public boolean gameStart = false;
    public Button gameButton;

    private Group titleGroup = new Group();

    private Parent createContent(){

        Pane root = new Pane();
        root.setPrefSize(width * tileSize, (height * tileSize) + 80);
        root.getChildren().addAll(titleGroup);

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                Tile tile = new Tile(tileSize, tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                titleGroup.getChildren().add(tile);

            }

        }

        player1 = new Circle(40);
        player1.setId("Player 1");
        player1.setFill(Color.GREEN);
        player1.getStyleClass().add("Style.css");
        player1.setTranslateX(player1XPos);
        player1.setTranslateY(player1YPos);

        player2 = new Circle(40);
        player2.setId("Player 2");
        player2.setFill(Color.RED);
        player2.getStyleClass().add("Style.css");
        player2.setTranslateX(player2XPos);
        player2.setTranslateY(player2YPos);

        Button button1 = new Button("Player 1");
        button1.setTranslateX(20);
        button1.setTranslateY(820);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameStart){
                    if(player1Turn){
                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        movePlayer1();
                        translatePlayer(player1XPos, player1YPos, player1);
                        player1Position += rand;

                        if(player1Position == 3){
                            translatePlayer(player1XPos = 120, player1YPos = 520, player1);
                            posCir1 += 3;
                            player1Position = 39;
                        }
                        if(player1Position == 10){
                            translatePlayer(player1XPos = 680, player1YPos = 680, player1);
                            posCir1 += 1;
                            player1Position = 12;
                        }
                        if(player1Position == 27){
                           translatePlayer(player1XPos = 600, player1YPos = 360, player1);
                            posCir1 += 3;
                            player1Position = 53;
                        }
                        if(player1Position == 56){
                           translatePlayer(player1XPos = 280, player1YPos = 120, player1);
                            posCir1 += 3;
                            player1Position = 84;
                        }
                        if(player1Position == 61 || player1Position == 99){
                           translatePlayer(player1XPos = 40, player1YPos = 40, player1);
                            posCir1 += 3;
                            player1Position = 99;
                        }
                        if(player1Position == 72){
                            translatePlayer(player1XPos = 760, player1YPos = 120, player1);
                            posCir1 += 1;
                            player1Position = 90;
                        }
                        if(player1Position == 16){
                            translatePlayer(player1XPos = 600, player1YPos = 680, player1);
                            player1Position = 13;
                        }
                        if(player1Position == 31){
                            translatePlayer(player1XPos = 280, player1YPos = 760, player1);
                            posCir1 -= 3;
                            player1Position = 4;
                        }
                        if(player1Position == 47){
                            translatePlayer(player1XPos = 360, player1YPos = 600, player1);
                            posCir1 -= 2;
                            player1Position = 25;
                        }if(player1Position == 63){
                            translatePlayer(player1XPos = 40, player1YPos = 360, player1);
                            posCir1 -= 1;
                            player1Position = 60;
                        }
                        if(player1Position == 66){
                            translatePlayer(player1XPos = 760, player1YPos = 360, player1);
                            posCir1 -= 1;
                            player1Position = 52;
                        }
                        if(player1Position == 97){
                            translatePlayer(player1XPos = 440, player1YPos = 200, player1);
                            posCir1 -= 2;
                            player1Position = 75;
                        }
                        if(player1Position >= 100){
                            translatePlayer(player1XPos = 150, player1YPos = 840, player1);
                            posCir1 = 10;
                            player1Position = 100;
                        }

                        player1Turn = false;
                        player2Turn = true;

                    }
                }

            }
        });

        Button button2 = new Button("Player 2");
        button2.setTranslateX(700);
        button2.setTranslateY(820);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameStart){
                    if(player2Turn){
                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        movePlayer2();
                        translatePlayer(player2XPos, player2YPos, player2);
                        player2Position += rand;

                        if(player2Position == 3){
                            translatePlayer(player2XPos = 120, player2YPos = 520, player2);
                            posCir2 += 3;
                            player2Position = 39;
                        }
                        if(player2Position == 10){
                            translatePlayer(player2XPos = 680, player2YPos = 680, player2);
                            posCir2 += 1;
                            player2Position = 12;
                        }
                        if(player2Position == 27){
                            translatePlayer(player2XPos = 600, player2YPos = 360, player2);
                            posCir2 += 3;
                            player2Position = 53;
                        }
                        if(player2Position == 56){
                            translatePlayer(player2XPos = 280, player2YPos = 120, player2);
                            posCir2 += 3;
                            player2Position =84;
                        }
                        if(player2Position == 61 || player2Position == 99){
                            translatePlayer(player2XPos = 40, player2YPos = 40, player2);
                            posCir2 += 3;
                            player2Position = 99;
                        }
                        if(player2Position == 72){
                            translatePlayer(player2XPos = 760, player2YPos = 120, player2);
                            posCir2 += 1;
                            player2Position = 90;
                        }
                        if(player2Position == 16){
                            translatePlayer(player2XPos = 600, player2YPos = 680, player2);
                            player2Position = 13;
                        }
                        if(player2Position == 31){
                            translatePlayer(player2XPos = 280, player2YPos = 760, player2);
                            posCir2 -= 3;
                            player2Position = 4;
                        }
                        if(player2Position == 47){
                            translatePlayer(player2XPos = 360, player2YPos = 600, player2);
                            posCir2 -= 2;
                            player2Position = 25;
                        }if(player2Position == 63){
                            translatePlayer(player2XPos = 40, player2YPos = 360, player2);
                            posCir2 -= 1;
                            player2Position = 60;
                        }
                        if(player2Position == 66){
                            translatePlayer(player2XPos = 680, player2YPos = 360, player2);
                            posCir2 -= 1;
                            player2Position = 52;
                        }if(player2Position == 97){
                            translatePlayer(player2XPos = 440, player2YPos = 200, player2);
                            posCir2 -= 2;
                            player2Position = 75;
                        }
                        if(player2Position >= 100){
                            translatePlayer(player2XPos = 150, player2YPos = 840, player2);
                            posCir2 = 10;
                            player2Position = 100;
                        }

                        player1Turn = true;
                        player2Turn = false;


                    }
                }
            }
        });

        gameButton = new Button("Start Game");
        gameButton.setTranslateX(350);
        gameButton.setTranslateY(820);

            gameButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                if(!gameStart) {
                    randResult.setText("Dice Result");
                    randResult.setTranslateX(220);
                    gameButton.setText("Game Started");
                    player1XPos = 40;
                    player1YPos = 760;

                    player2XPos = 40;
                    player2YPos = 760;

                    player1Position = 1;
                    player2Position = 1;

                    posCir1 = 1;
                    posCir2 = 1;

                    player1.setTranslateX(player1XPos);
                    player1.setTranslateY(player1YPos);
                    player2.setTranslateX(player2XPos);
                    player2.setTranslateY(player2YPos);

                    gameStart = true;
                }

                }
            });


        randResult = new Label("Dice Result");
        randResult.setTranslateX(230);
        randResult.setTranslateY(830);

        gameResult = new Label("Game Result");
        gameResult.setTranslateX(490);
        gameResult.setTranslateY(830);

        Image img = new Image("snakebg.jpeg");
        ImageView imageView = new ImageView();
        imageView.setImage(img);
        imageView.setFitWidth(800);
        imageView.setFitHeight(800);


        titleGroup.getChildren().addAll(imageView,player1, player2, button1, button2, gameButton, randResult, gameResult);

        return root;

    }

    public void getDiceValue(){
        rand = (int)(Math.random() * 6 +1);
    }

    public void movePlayer1(){

        if( player1XPos == 40 && player1YPos == 40){
            player1XPos =40;
            player1YPos = 40;
        }

        for(int i=0; i<rand; i++){
            if(posCir1 % 2 == 1){
                player1XPos += 80;
            }
            if(posCir1 % 2 == 0){
                player1XPos -= 80;
            }
            if(player1XPos > 760){
                player1YPos -= 80;
                player1XPos -= 80;
                posCir1++;
            }
            if(player1XPos < 40){
                player1YPos -= 80;
                player1XPos += 80;
                posCir1++;
            }

            if(player1XPos < 30 || player1YPos < 30){
                player1XPos = 40;
                player1YPos =40;
                gameResult.setTranslateX(530);
                gameResult.setText("Player One Won");
                gameButton.setText("Start Again");
                gameStart = false;
            }
        }
    }

    public void movePlayer2(){

        if( player1XPos == 40 && player1YPos == 40){
            player1XPos =40;
            player1YPos = 40;
        }

        for(int i=0; i<rand; i++){
            if(posCir2 % 2 == 1){
                player2XPos += 80;
            }
            if(posCir2 % 2 == 0){
                player2XPos -= 80;
            }
            if(player2XPos > 760){
                player2YPos -= 80;
                player2XPos -= 80;
                posCir2++;
            }
            if(player2XPos < 40){
                player2YPos -= 80;
                player2XPos += 80;
                posCir2++;
            }

            if(player2XPos < 30 || player2YPos < 30 || player2Position ==100){
                player2XPos = 40;
                player2YPos = 40;
                gameResult.setTranslateX(530);
                gameResult.setText("Player Two Won");
                gameButton.setText("Start Again");
                gameStart = false;
            }
        }
    }

    public void translatePlayer(int x, int y, Circle b){

        TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Snake and Ladder Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
