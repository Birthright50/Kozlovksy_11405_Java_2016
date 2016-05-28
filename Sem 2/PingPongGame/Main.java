import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {

    private Circle ball;
    private Group pongComponents;
    private Rectangle leftPaddle;
    private Rectangle rightPaddle;
    private Rectangle topWall;
    private Rectangle rightWall;
    private Rectangle leftWall;
    private Rectangle bottomWall;
    private Timeline pongAnimation;

    private final static Random random = new Random();
    private boolean movingRight = random.nextBoolean();
    private boolean movingDown = random.nextBoolean();

    private void initialize() {
        pongAnimation = new Timeline();
        pongAnimation.getKeyFrames().add(new KeyFrame(
                new Duration(15.0),
                t -> {
                    checkForCollision();
                    int horzPixels = movingRight ? 1 : -1;
                    int vertPixels = movingDown ? 1 : -1;
                    ball.setCenterX(ball.getCenterX() + horzPixels);
                    ball.setCenterY(ball.getCenterY() + vertPixels);

                }
        ));
        pongAnimation.setCycleCount(Timeline.INDEFINITE);
        pongComponents.requestFocus();
    }

    private void checkForCollision() {
        if (ball.intersects(rightWall.getBoundsInLocal()) ||
                ball.intersects(leftWall.getBoundsInLocal())) {
            pongAnimation.stop();

        } else if (ball.intersects(bottomWall.getBoundsInLocal()) ||
                ball.intersects(topWall.getBoundsInLocal())) {
            movingDown = !movingDown;
        } else if (ball.intersects(leftPaddle.getBoundsInParent()) || ball.intersects(rightPaddle.getBoundsInParent())) {
            movingRight = !movingRight;
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        pongComponents = new Group();
        pongComponents.getChildren().add((ball = new Circle(5.0)));
        pongComponents.getChildren().add(topWall = new Rectangle(50, 0, 500, 1));
        pongComponents.getChildren().add(leftWall = new Rectangle(0, 0, 1, 500));
        pongComponents.getChildren().add(rightWall = new Rectangle(500, 0, 1, 500));
        pongComponents.getChildren().add(bottomWall = new Rectangle(0, 500, 500, 1));
        leftPaddle = new Rectangle(10, 30);
        leftPaddle.setX(20);
        rightPaddle = new Rectangle(10, 30);
        rightPaddle.setX(470);
        pongComponents.getChildren().add(leftPaddle);
        pongComponents.getChildren().add(rightPaddle);
        pongComponents.setOnKeyPressed(k -> {
            if (k.getCode() == KeyCode.UP &&
                    !this.rightPaddle.getBoundsInParent().intersects(topWall.getBoundsInLocal())) {
                rightPaddle.setTranslateY(rightPaddle.getTranslateY() - 6);
            } else if (k.getCode() == KeyCode.DOWN &&
                    !this.rightPaddle.getBoundsInParent().intersects(bottomWall.getBoundsInLocal())) {
                rightPaddle.setTranslateY(rightPaddle.getTranslateY() + 6);
            } else if (k.getCode() == KeyCode.W &&
                    !this.leftPaddle.getBoundsInParent().intersects(topWall.getBoundsInLocal())) {
                leftPaddle.setTranslateY(leftPaddle.getTranslateY() - 6);
            } else if (k.getCode() == KeyCode.S &&
                    !this.leftPaddle.getBoundsInParent().intersects(bottomWall.getBoundsInLocal())) {
                leftPaddle.setTranslateY(leftPaddle.getTranslateY() + 6);
            } else if (k.getCode() == KeyCode.SPACE) {
                pongAnimation.playFromStart();
            } else if (k.getCode() == KeyCode.BACK_SPACE) {
                this.start(stage);
            }

        });
        Scene s = new Scene(pongComponents);
        ball.setCenterX(250);
        ball.setCenterY(250);
        leftPaddle.setTranslateY(235);
        rightPaddle.setTranslateY(235);
        stage.setScene(s);
        stage.setHeight(545);
        stage.setWidth(500);
        initialize();
        stage.setTitle("Ping pong");
        stage.show();
        FadeTransition ft = new FadeTransition();
        ft.setNode(ball);
        ft.setDuration(new Duration(1800));
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }
}


