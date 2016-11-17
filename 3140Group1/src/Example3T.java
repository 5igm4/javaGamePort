import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

// An alternative implementation of Example 3,
//    using the Timeline, KeyFrame, and Duration classes.

// Animation of Earth rotating around the sun. (Hello, world!)
public class Example3T extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Group 1 Java Game" );
        
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        HBox hbox1 = new HBox();
        
        Canvas canvas = new Canvas( 815, 700 );
        root.getChildren().add( canvas );
        
        theStage.setMaxWidth(815);
        theStage.setMaxHeight(700);
        
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        MainMenu menu = new MainMenu(gc);
        menu.init();
        

        double x = (canvas.getWidth()/2) - 50;
        System.out.println(x);

        
        final Image earth = new Image( "earth.png" );
        final Image sun   = new Image( "sun.png" );
        final Image space = new Image( "space.png" );
        
        final Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        final long timeStart = System.currentTimeMillis();
        boolean isEnd = false;
       
        final Button button1 = new Button("Start Game");
        button1.setStyle("-fx-font: 22 arial; -fx-base: #eee;");
        button1.setMinSize(100, 80);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	gameLoop.play();
            }
        });
        button1.setLayoutX(x);
        button1.setLayoutY(500);
        root.getChildren().add( button1 );
        KeyFrame kf = new KeyFrame(
            Duration.seconds(0.017),                // 60 FPS
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent ae)
                {
                    double t = (System.currentTimeMillis() - timeStart) / 1000.0; 
                                
                    double x = 232 + 128 * Math.cos(t);
                    double y = 232 + 128 * Math.sin(t);
                    
                    // Clear the canvas
                    //gc.clearRect(0, 0, 512,512);
                    
                    // background image clears canvas
                    gc.drawImage( space, 0, 0 );
                    gc.drawImage( earth, x, y );
                    gc.drawImage( sun, 196, 196 );
                    gc.setFill(Color.BLACK);
                    gc.fillOval(0, 0, 50, 50);
                    System.out.println(t);
                    if(t > 10){
                    	gameLoop.stop();
                    }
                }
            });
        
        gameLoop.getKeyFrames().add( kf );
        
        theStage.show();
        
    }
}