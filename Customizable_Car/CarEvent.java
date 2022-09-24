import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ColorPicker;
import javafx.event.ActionEvent;

public class CarEvent extends Application
{
    //points used for the polygons
    private double[] chasisPoints = {96,198,202,406,395,405,498,585,788,583,928,401,1187,397,1100,204};
    private double[] windowPoints = {216,199,254,141,290,141,291,200};
    private ColorPicker colorChoice;
    private Polygon chasis = new Polygon(chasisPoints);  //Moved the polygon declaration outside the start method so it can be used in the processColorChoice method

    public void start(Stage mainStage)
    {
        //Color picker that changes chasis color
        colorChoice = new ColorPicker(Color.RED);
        colorChoice.setOnAction(this::processColorChoice);
        colorChoice.setTranslateX(20);
        colorChoice.setTranslateY(20);

        //default chasis color
        chasis.setFill(Color.RED);
        chasis.setScaleY(-1);

        Polygon window1 = new Polygon(windowPoints);
        window1.setFill(Color.LIGHTCYAN);
        window1.setScaleX(2.5);
        window1.setScaleY(2.5);
        window1.setTranslateX(275);
        window1.setTranslateY(125);

        Polygon window2 = new Polygon(windowPoints);
        window2.setFill(Color.LIGHTCYAN);
        window2.setScaleX(-3.25);
        window2.setScaleY(2.5);
        window2.setTranslateX(510);
        window2.setTranslateY(125);
        
        Ellipse wheel1 = new Ellipse(350,580,90,90);
        Ellipse rim1 = new Ellipse(350,580,50,50);
        Ellipse rim1Mid = new Ellipse(350,580,20,20);
        rim1.setFill(Color.GRAY);
        rim1Mid.setFill(Color.DARKGRAY);

        Ellipse wheel2 = new Ellipse(950,580,90,90);
        Ellipse rim2 = new Ellipse(950,580,50,50);
        Ellipse rim2Mid = new Ellipse(950,580,20,20);
        rim2.setFill(Color.GRAY);
        rim2Mid.setFill(Color.DARKGRAY);

        Line doorLine = new Line(632,225,632,560);
        doorLine.setFill(Color.BLACK);
        doorLine.setStrokeWidth(3);

        Rectangle doorHandle = new Rectangle(650,400,50,15);
        doorHandle.setFill(Color.WHITESMOKE);

        //used arc width to get a rounded edge
        Rectangle carLight = new Rectangle(1140,400,50,60);
        carLight.setFill(Color.YELLOW);
        carLight.setArcHeight(20);
        carLight.setArcWidth(20);

        //front bumper
        Rectangle carBumperF = new Rectangle(1050,535,90,60);
        carBumperF.setFill(Color.WHITESMOKE);
        carBumperF.setArcHeight(20);
        carBumperF.setArcWidth(20);

        //rear bumper
        Rectangle carBumperB = new Rectangle(75,545,90,60);
        carBumperB.setFill(Color.WHITESMOKE);
        carBumperB.setArcHeight(20);
        carBumperB.setArcWidth(20);

        //shapes used for the road
        Rectangle asphalt = new Rectangle(0,570,1280,200);
        asphalt.setFill(Color.rgb(19, 20, 33));
        Rectangle roadLine1 = new Rectangle(20,630,100,30);
        roadLine1.setFill(Color.YELLOW);
        Rectangle roadLine2 = new Rectangle(250,630,100,30);
        roadLine2.setFill(Color.YELLOW);
        Rectangle roadLine3 = new Rectangle(480,630,100,30);
        roadLine3.setFill(Color.YELLOW);
        Rectangle roadLine4 = new Rectangle(710,630,100,30);
        roadLine4.setFill(Color.YELLOW);
        Rectangle roadLine5 = new Rectangle(940,630,100,30);
        roadLine5.setFill(Color.YELLOW);
        Rectangle roadLine6 = new Rectangle(1170,630,100,30);
        roadLine6.setFill(Color.YELLOW);

        Group car = new Group(carLight,chasis,wheel1,rim1,rim1Mid,wheel2,rim2,rim2Mid,window1,window2,doorLine,doorHandle,carBumperF,carBumperB,colorChoice);
        Group road = new Group(asphalt,roadLine1,roadLine2,roadLine3,roadLine4,roadLine5,roadLine6);

        Group root = new Group(road,car);
        Scene window = new Scene(root, 1280, 720, Color.LIGHTSKYBLUE);
        //sets up the actual app window

        mainStage.setTitle("RANDOM CAR EVENT!!!!!"); 
        mainStage.setScene(window); 
        mainStage.show();
    }

    //Event handler for the color picker that changes the color of the chasis
    public void processColorChoice(ActionEvent event)
    {
        chasis.setFill(colorChoice.getValue());
    }

    
    public static void main(String[] args)
    {
        launch(args);
    }
}