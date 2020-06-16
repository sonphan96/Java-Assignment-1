
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Scanner;

import static javafx.application.Application.launch;

/**
 * This is a program which draw a column graph from data that user input.
 * This program was written for Assignment 1
 *
 * @author Phan, Truong Son (Student number: 000824388)
 */
public class Assignment1 extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);

        Canvas canvas = new Canvas(600, 600); // Set canvas Size in Pixels
        stage.setTitle("Assignment1"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE

        // Get User Input
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a title: ");
        String title = scan.nextLine();

        System.out.println("Enter minimum value for your vertical axis: ");
        int minValue = scan.nextInt();
        System.out.println("Enter maximum value for your vertical axis: ");
        int maxValue = scan.nextInt();
        // Calculate the interval value between 2 lines
        int intervalValue = (maxValue - minValue)/4;



        // Setting font for the text
        gc.setFont(Font.font("georgia", 18));
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText(title,300, 35);

        // Convert integer to string to draw values for vertical axis
        String str1 = Integer.toString(minValue);
        String str2 = Integer.toString(intervalValue);
        String str3 = Integer.toString(2*intervalValue);
        String str4 = Integer.toString(3*intervalValue);
        String str5 = Integer.toString(maxValue);

        // Draw 5 Lines and values for vertical axis
        gc.strokeLine(100, 500, 500, 500);
        gc.strokeLine(100, 400, 500, 400);
        gc.strokeLine(100, 300, 500, 300);
        gc.strokeLine(100, 200, 500, 200);
        gc.strokeLine(100, 100, 500, 100);
        gc.strokeText(str1,50,500);
        gc.strokeText(str2,50,400);
        gc.strokeText(str3,50,300);
        gc.strokeText(str4,50,200);
        gc.strokeText(str5,50,100);



        // initialize value
        // X coordinate to draw first label & column
        String label;
        int xcor = 110;
        float value, yValue , ycor, ratio;
        // graph height = 500 - 100
        int GRAPH_HEIGHT = 400;


        // For loop get input and draw columns
        // i <= 6, ASSUMPTION: we can only draw 7 columns

        for (int i = 0; i <= 6; i++){
            System.out.println("Enter label or X for exit: ");
            label = scan.nextLine();

            if (label.equals("X")){
                break;
            }
            else {
                System.out.println("Enter value for this label: ");
                value = scan.nextInt();

                ratio = (value - minValue)/(maxValue - minValue);
                yValue =  ratio*GRAPH_HEIGHT;
                ycor = 500 - yValue;

                // Check valid input
                while (value < minValue || value > maxValue) {
                    System.err.println("The value must between " + minValue + " and " + maxValue);
                    System.out.println("Enter a value for this label: ");
                    value = scan.nextInt();
                }

                // Draw label and column
                gc.strokeText(label, xcor, 550);
                gc.fillRect(xcor, ycor, 30, yValue);

                // Increase xcor to draw next label and column
                xcor += 50;
            }
        }



        // YOUR CODE STOPS HERE
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
