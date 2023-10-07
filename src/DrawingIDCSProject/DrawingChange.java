import java.awt.Font;
import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.event.*;

public class DrawingChange {
    public static void main(String[] args) {
        // set the scale of the coordinate system
        StdDraw.setXscale(-1, 1.0);
        StdDraw.setYscale(-1, 1);
        Font font = new Font("Edwardian Script ITC", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.picture(0, -.25, "kitten.jpg");
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0, .75, "Happy Kitty!");
        Font fonts = new Font("Edwardian Script ITC", Font.BOLD, 20);
        StdDraw.setFont(fonts);
        StdDraw.text(0, .6,
                "Put your mouse where you want stars in the sky above the Kitty and click one of these letters h,a,p,y,k,i,t,y,!");
        StdDraw.text(0, .5,
                "Or press your mouse to draw!");
        StdDraw.text(0, .4, "Different letters are different shapes and colors!");
        // StdAudio.play("cats-meow-81221.wav");
        while (true) {
            StdDraw.enableDoubleBuffering();
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            if (StdDraw.isKeyPressed(72)) { // this is h
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(x, y, 0.02);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("cat-89108.wav");
            } else if (StdDraw.isKeyPressed(65)) { // this is a
                StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                StdDraw.filledEllipse(x, y, 0.02, 0.03);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("cat-98721.wav");
            } else if (StdDraw.isKeyPressed(80)) { // this is p
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledRectangle(x, y, 0.01, 0.03);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("cat-meow-6226.wav");

            } else if (StdDraw.isKeyPressed(89)) { // this is y
                StdDraw.setPenColor(StdDraw.BOOK_RED);
                StdDraw.filledSquare(x, y, 0.02);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("cat-meow-14536.wav");

            } else if (StdDraw.isKeyPressed(49)) { // this is space
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.filledEllipse(x, y, 0.03, 0.02);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("cat-meow-99835.wav");

            } else if (StdDraw.isKeyPressed(75)) { // this is k
                StdDraw.setPenColor(StdDraw.MAGENTA);
                StdDraw.filledRectangle(x, y, 0.03, 0.01);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("cat-purring-and-meow-5928.wav");

            } else if (StdDraw.isKeyPressed(73)) { // this is i
                StdDraw.setPenColor(StdDraw.PINK);
                StdDraw.filledSquare(x, y, 0.02);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("kitty-meow-85182.wav");

            } else if (StdDraw.isKeyPressed(84)) { // this is t
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledEllipse(x, y, 0.02, 0.03);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("fiji-meow-01-86859.wav");

            } else if (StdDraw.isKeyPressed(89)) { // this is y
                StdDraw.setPenColor(StdDraw.PINK);
                StdDraw.filledRectangle(x, y, 0.01, 0.03);
                StdDraw.show();
                StdDraw.pause(1);
                StdAudio.play("sleepy-cat-purring-and-meowing-39248.wav");

            } else if (StdDraw.isMousePressed()) {
                StdDraw.setPenColor(StdDraw.CYAN);
                StdDraw.filledCircle(x, y, 0.01);
                StdDraw.show();
                StdDraw.pause(1);
            }
        }

    }
}
