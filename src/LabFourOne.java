import java.awt.*;

public class LabFourOne {
    public static void main(String[] args) {



        int ticker = 15;

        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        StdDraw.setTitle("Milk Carton Kids Noise");
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.text(5,5,"Click the mouse to start the process or hold it down to animate.");
        StdDraw.text(3,3,"Press h key to play noise");
        StdDraw.text(5,1,"If No noises play it means 15 count passed");
        StdDraw.text(5,0, " for the clicker thus restart the program");
        StdDraw.show();

        int count=0;


                while (true) {



                    while (StdDraw.isMousePressed()) {

                        double randomNum = (double) Math.random();
                        randomNum = randomNum * 10;

                        double x = StdDraw.mouseX();
                        double y = StdDraw.mouseY();
                        StdDraw.picture(5, 5, "milkkitty.jpg");
                        StdDraw.filledCircle(x, y, .1);
                        StdDraw.setPenColor(Color.red);
                        StdDraw.text(5, 5, "Turn the volume up");
                        StdDraw.setPenColor(Color.pink);
                        StdDraw.circle(randomNum+.5, randomNum, 1);
                        StdDraw.setPenColor(Color.GREEN);
                        StdDraw.filledSquare(randomNum, randomNum-1, .5);
                        StdDraw.setPenColor(Color.orange);
                        StdDraw.text(3, 1, "Click Again After Noise is gone!");
                        StdDraw.setPenColor(Color.blue);
                        StdDraw.filledEllipse(randomNum/(randomNum*randomNum), randomNum*(randomNum+.33), .5, .5);
                        StdDraw.setPenColor(Color.black);
                        StdDraw.filledRectangle(randomNum/2d, randomNum/.5d, .5,1);

                        StdDraw.show();
                        StdDraw.pause(10);
                        count +=1;
                        StdDraw.clear();





                    }
                    //Ingrid helped me here with the isKeyPressed code
                    if(StdDraw.isKeyPressed(72)){
                        double sampleRate = StdAudio.SAMPLE_RATE; //pulled this because I was having issues getting audio files in

                        double duration = 2;

                        int numberOfSamples = (int) (sampleRate * duration);

                        double[] a = new double[numberOfSamples + 1];
                        for (int i = 0; i <= numberOfSamples; i++) {
                            a[i] = Math.sin(2 * Math.PI * i * 440d / StdAudio.SAMPLE_RATE);
                        }
                        int numberOfSeconds = 1;
                        for (int i = 0; i < numberOfSeconds; i++) {
                            StdAudio.play(a);
                        }
                    }
                }


            }
        }


