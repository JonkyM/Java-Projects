import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
import javafx.scene.text.Font;

public class PieChart extends Application
{
    public void start(Stage mainStage) throws FileNotFoundException
    {
        final double TOTAL_DEGREES = 360.0; //constant used to calculate arc angle
        double angStart = 0, angEnd = 0;    //values used in arc construction
       
        double value1, value2, value3, value4, total_sum;

        String valueName1, valueName2, valueName3, valueName4;

        DecimalFormat fmt = new DecimalFormat("0.##"); //formating for labels

        Ellipse bgEllipse = new Ellipse(300, 300, 200, 200); 
        bgEllipse.setFill(null);
        bgEllipse.setStroke(Color.BLACK);
        bgEllipse.setStrokeWidth(4);

        Scanner scan = new Scanner(new File("C:/Users/John Kendrick Mejia/Documents/College Documents/CSE 220 Assignments/Homework 2/CodeHW2/src/VALUES.txt"));
        //the pathname of the file for the scanner has to be exact, I tried just using the name while having the file in the same folder as my .java file but it did not work
        //the pathname has to be replaced manually for it to work

        valueName1 = scan.next();
        value1 = scan.nextDouble();
        valueName2 = scan.next();
        value2 = scan.nextDouble();
        valueName3 = scan.next();
        value3 = scan.nextDouble();
        valueName4 = scan.next();
        value4 = scan.nextDouble();
        //scans name of the value first and then the value for all 4 values

        total_sum = value1 + value2 + value3 + value4; //used to calculate percentages later
       
        Font font1 = new Font("Comic Sans MS", 20);

        Text value1_label = new Text(10, 30, valueName1 + ": " + fmt.format(value1 / total_sum * 100) + "%");
        value1_label.setFill(Color.GREEN);
        value1_label.setFont(font1);
        
        Text value2_label = new Text(10, 60, valueName2 + ": " + fmt.format(value2 / total_sum * 100) + "%");
        value2_label.setFill(Color.RED);
        value2_label.setFont(font1);
       
        Text value3_label = new Text(10, 90, valueName3 + ": " + fmt.format(value3 / total_sum * 100) + "%");
        value3_label.setFill(Color.BLUE);
        value3_label.setFont(font1);
        
        Text value4_label = new Text(10, 120, valueName4 + ": " + fmt.format(value4 / total_sum * 100) + "%");
        value4_label.setFill(Color.YELLOW);
        value4_label.setFont(font1);
        //creates the lables for all the values with nice formatting

        angEnd = (value1 / total_sum) * TOTAL_DEGREES; 

        Arc slice1 = new Arc(300, 300, 200, 200, angStart, angEnd);
        slice1.setType(ArcType.ROUND);
        slice1.setStroke(Color.BLACK);
        slice1.setFill(Color.GREEN);
        
        angStart += angEnd;
        angEnd = (value2 / total_sum) * TOTAL_DEGREES;
        //angStart sets start angle of the arc at the same position where the previous arc left off
        //angEnd calculates the arc length based on the percentage the value represents
        //this is the same for all 4 arcs with the only difference being in the value being used for angEnd

        Arc slice2 = new Arc(300, 300, 200, 200, angStart, angEnd);
        slice2.setType(ArcType.ROUND);
        slice2.setStroke(Color.BLACK);
        slice2.setFill(Color.RED);

        angStart += angEnd;
        angEnd = (value3 / total_sum) * TOTAL_DEGREES;

        Arc slice3 = new Arc(300, 300, 200, 200, angStart, angEnd);
        slice3.setType(ArcType.ROUND);
        slice3.setStroke(Color.BLACK);
        slice3.setFill(Color.BLUE);

        angStart += angEnd;
        angEnd = (value4 / total_sum) * TOTAL_DEGREES;

        Arc slice4 = new Arc(300, 300, 200, 200, angStart, angEnd);
        slice4.setType(ArcType.ROUND);
        slice4.setStroke(Color.BLACK);
        slice4.setFill(Color.YELLOW);


        Group root = new Group(value1_label, value2_label, value3_label, value4_label, slice1, slice2, slice3, slice4, bgEllipse);
        Scene window = new Scene(root, 600, 600, Color.LIGHTSKYBLUE);
        //sets up the actual app window

        mainStage.setTitle("I present to you... A PIE CHART"); 
        mainStage.setScene(window); 
        mainStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}