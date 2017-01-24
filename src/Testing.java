
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author khans4349
 */
public class Testing extends JComponent implements KeyListener, MouseListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 900;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // game variables
    // insert start page
    BufferedImage startPage = loadImage("Capture.PNG");
    // insert how to play page
    BufferedImage howToPlay = loadImage("edcde552218c1246887c85d050daf887.jpg");
    // insert back button
    BufferedImage back = loadImage("back-button-hi.png");
    // Insert Background
    BufferedImage background = loadImage("background-1_0.png");
    // insert players car
    BufferedImage playerCar = loadImage("red-car-top-view-hi.png");
    // insert other cars on road
    // car one
    BufferedImage carOne = loadImage("Blue-Taxi-18007-large.png");
    // car two
    BufferedImage carTwo = loadImage("large-Modern-Car-Top-View-66.6-5597.png");
    // car three
    BufferedImage carThree = loadImage("uploaded-by-ocal-date-06-26-2012-license-type-public-domain-sUINC0-clipart.png");
    // car four
    BufferedImage carFour = loadImage("medium-Modern-Car-Top-View-33.3-5597.png");
    // car five
    BufferedImage carFive = loadImage("medium-Modern-Car-Top-View-166.6-5597.png");
    // car six
    BufferedImage carSix = loadImage("4dc07fb6fcd4e96d1ff6e480d8cc5a14_-car-clipart-top-view-2-car-clipart-top-view_200-418.png");
    // car seven
    BufferedImage carSeven = loadImage("painted_sportscar___top_view_by_balagehun1991.png");
    // Move car left
    boolean carLeft = false;
    // move car Right
    boolean carRight = false;
    // start the game
    boolean start = false;
    // car dies
    boolean dead = false;
    // restart game
    boolean restart = false;
    // clicked Screen
    boolean clicked = false;
    // clicked How To Play
    boolean clickedTwo = false;
    // set car speed
    int speed = 25;
    // set the speed of ther other cars
    int speedOthers = 5;
    // increase the speed
    int speedPlus = 0;
    // set the speed of the road
    int roadSpeed = 10;
    // set score
    int score = 0;
    // score adder
    int addScore = 50;
    // set level
    int level = 1;
    // set the font of score
    Font scoreFont = new Font("Arial", Font.BOLD, 42);
    // set the font of the how to play title
    Font title = new Font("Eras Bold ITC", Font.BOLD, 50);
    // set the font of how to play description
    Font description = new Font("Eras Bold ITC", Font.BOLD, 30);
    
    // space between each rows of cars
    int rowSpace = 200;
    // set timer to speed up game
    int time = 1200;
    // hitbox for x coordinates side
    int Xhitbox = 80;
    // hitbox for y coordinates side
    int Yhitbox = 170;
    // car setpoint y coordinate 
    int setpoint = -6000;
    // set the location of the players car
    Rectangle usersCar = new Rectangle(365, 650, 90, 180);
    // make positions in the array on each of the lanes on the roads
    Rectangle[] otherCars = new Rectangle[4];
    // For Row One
    Rectangle carLaneOneRowOne = new Rectangle(115, 0, 90, 180);
    Rectangle carLaneTwoRowOne = new Rectangle(270, 0, 90, 180);
    Rectangle carLaneFourRowOne = new Rectangle(590, 0, 90, 180);
    // For Row Two
    Rectangle carLaneOneRowTwo = new Rectangle(115, -600, 90, 180);
    Rectangle carLaneFourRowTwo = new Rectangle(590, -600, 90, 180);
    // For Row Three
    Rectangle carLaneTwoRowThree = new Rectangle(270, -1200, 90, 180);
    Rectangle carLaneFourRowThree = new Rectangle(590, -1200, 90, 180);
    // For Row Four
    Rectangle carLaneTwoRowFour = new Rectangle(270, -1800, 90, 180);
    Rectangle carLaneThreeRowFour = new Rectangle(435, -1800, 90, 180);
    // For Row Five
    Rectangle carLaneThreeRowFive = new Rectangle(435, -2400, 90, 180);
    Rectangle carLaneFourRowFive = new Rectangle(590, -2400, 90, 180);
    // For Row Six
    Rectangle carLaneOneRowSix = new Rectangle(115, -3000, 90, 180);
    Rectangle carLaneTwoRowSix = new Rectangle(270, -3000, 90, 180);
    Rectangle carLaneThreeRowSix = new Rectangle(435, -3000, 90, 180);
    // For Row Seven
    Rectangle carLaneOneRowSeven = new Rectangle(115, -3600, 90, 180);
    Rectangle carLaneThreeRowSeven = new Rectangle(435, -3600, 90, 180);
    Rectangle carLaneFourRowSeven = new Rectangle(590, -3600, 90, 180);
    // For Row Eight
    Rectangle carLaneOneRowEight = new Rectangle(115, -4200, 90, 180);
    Rectangle carLaneThreeRowEight = new Rectangle(435, -4200, 90, 180);
    // For Row Nine
    Rectangle carLaneOneRowNine = new Rectangle(115, -4800, 90, 180);
    Rectangle carLaneTwoRowNine = new Rectangle(270, -4800, 90, 180);
    // For Row Ten
    Rectangle carLaneTwoRowTen = new Rectangle(270, -5400, 90, 180);
    Rectangle carLaneThreeRowTen = new Rectangle(435, -5400, 90, 180);
    Rectangle carLaneFourRowTen = new Rectangle(590, -5400, 90, 180);
    // For Row Eleven
    Rectangle carLaneOneRowEleven = new Rectangle(115, -6000, 90, 180);
    Rectangle carLaneTwoRowEleven = new Rectangle(270, -6000, 90, 180);
    Rectangle carLaneFourRowEleven = new Rectangle(590, -6000, 90, 180);
    // Repeat Background
    Rectangle backgroundOne = new Rectangle(0, 0, 800, 450);
    Rectangle backgroundTwo = new Rectangle(0, 450, 800, 450);
    Rectangle backgroundThree = new Rectangle(0, -450, 800, 450);
    // start page
    Rectangle frontPage = new Rectangle(0, 0, WIDTH, HEIGHT);
    // how to play page
    Rectangle howTwoScreen = new Rectangle(0, 0, WIDTH, HEIGHT);
    // back button
    Rectangle backButton = new Rectangle(690, 10, 100, 50);

    MP3Player music = new MP3Player(new File("WHO IS THE BEST  Steph Curry - CP3 - Kyrie Irving - Russell Westbrook - JohnWall.mp3"));
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        // Draw Background Screen
        g.setColor(Color.black);
        if (clicked == true) {
            g.drawImage(background, backgroundOne.x, backgroundOne.y, backgroundOne.width, backgroundOne.height, null);
            g.drawImage(background, backgroundTwo.x, backgroundTwo.y, backgroundTwo.width, backgroundTwo.height, null);
            g.drawImage(background, backgroundThree.x, backgroundThree.y, backgroundThree.width, backgroundThree.height, null);
            g.drawImage(back, backButton.x, backButton.y, backButton.width, backButton.height, null);
            
        }
        // Draw the Front Screen Page
        if (clicked != true && clickedTwo !=true) {
            g.drawImage(startPage, frontPage.x, frontPage.y, frontPage.width, frontPage.height, null);
        }
        // Draw the How to Play Page
        if(clickedTwo == true){
            g.drawImage(howToPlay, howTwoScreen.x, howTwoScreen.y, howTwoScreen.width, howTwoScreen.height, null);
            g.drawImage(back, backButton.x, backButton.y, backButton.width, backButton.height, null);
            
            // make title
            g.setColor(Color.red);
            g.setFont(title);
            g.drawString("How To Play", 230, 60);
            
            // make how to play description
            g.setColor(Color.white);
            g.setFont(description);
            g.drawString("SpaceBar: Start the car", 210, 150);
            g.drawString("Right Arrow Key: Move the Car Right", 85, 200);
            g.drawString("Left Arrow Key: Move the Car Left", 100, 250);
            g.drawString("R: Restart Game after car crashed", 105, 300);
        }
        
        
        // draw the players vehicle
        if (clicked == true) {
            g.setColor(Color.red);
            g.drawImage(playerCar, usersCar.x, usersCar.y, usersCar.width, usersCar.height, null);
        }

        // set the position of each spot in the array
        otherCars[0] = new Rectangle(150, 100, 60, 120);
        otherCars[1] = new Rectangle(300, 100, 60, 120);
        otherCars[2] = new Rectangle(450, 100, 60, 120);
        otherCars[3] = new Rectangle(600, 100, 60, 120);

        if (clicked == true) {
            // draw the cars on row one
            g.drawImage(carOne, carLaneOneRowOne.x, carLaneOneRowOne.y, carLaneOneRowOne.width, carLaneOneRowOne.height, null);
            g.drawImage(carTwo, carLaneTwoRowOne.x, carLaneTwoRowOne.y, carLaneTwoRowOne.width, carLaneTwoRowOne.height, null);
            g.drawImage(carThree, carLaneFourRowOne.x, carLaneFourRowOne.y, carLaneFourRowOne.width, carLaneFourRowOne.height, null);

            // draw the cars on row two
            g.drawImage(carFour, carLaneOneRowTwo.x, carLaneOneRowTwo.y, carLaneOneRowTwo.width, carLaneOneRowTwo.height, null);
            g.drawImage(carFive, carLaneFourRowTwo.x, carLaneFourRowTwo.y, carLaneFourRowTwo.width, carLaneFourRowTwo.height, null);

            // draw the cars on row three
            g.drawImage(carSix, carLaneTwoRowThree.x, carLaneTwoRowThree.y, carLaneTwoRowThree.width, carLaneTwoRowThree.height, null);
            g.drawImage(carSeven, carLaneFourRowThree.x, carLaneFourRowThree.y, carLaneFourRowThree.width, carLaneFourRowThree.height, null);

            // draw the cars on row four
            g.drawImage(carOne, carLaneTwoRowFour.x, carLaneTwoRowFour.y, carLaneTwoRowFour.width, carLaneTwoRowFour.height, null);
            g.drawImage(carTwo, carLaneThreeRowFour.x, carLaneThreeRowFour.y, carLaneThreeRowFour.width, carLaneThreeRowFour.height, null);

            // draw the cars on row five
            g.drawImage(carThree, carLaneThreeRowFive.x, carLaneThreeRowFive.y, carLaneThreeRowFive.width, carLaneThreeRowFive.height, null);
            g.drawImage(carFour, carLaneFourRowFive.x, carLaneFourRowFive.y, carLaneFourRowFive.width, carLaneFourRowFive.height, null);

            // draw the cars on row six
            g.drawImage(carFive, carLaneOneRowSix.x, carLaneOneRowSix.y, carLaneOneRowSix.width, carLaneOneRowSix.height, null);
            g.drawImage(carSix, carLaneTwoRowSix.x, carLaneTwoRowSix.y, carLaneTwoRowSix.width, carLaneTwoRowSix.height, null);
            g.drawImage(carSeven, carLaneThreeRowSix.x, carLaneThreeRowSix.y, carLaneThreeRowSix.width, carLaneThreeRowSix.height, null);

            // draw the cars on row seven
            g.drawImage(carOne, carLaneOneRowSeven.x, carLaneOneRowSeven.y, carLaneOneRowSeven.width, carLaneOneRowSeven.height, null);
            g.drawImage(carTwo, carLaneThreeRowSeven.x, carLaneThreeRowSeven.y, carLaneThreeRowSeven.width, carLaneThreeRowSeven.height, null);
            g.drawImage(carThree, carLaneFourRowSeven.x, carLaneFourRowSeven.y, carLaneFourRowSeven.width, carLaneFourRowSeven.height, null);

            // draw the cars on row eight
            g.drawImage(carFour, carLaneOneRowEight.x, carLaneOneRowEight.y, carLaneOneRowEight.width, carLaneOneRowEight.height, null);
            g.drawImage(carFive, carLaneThreeRowEight.x, carLaneThreeRowEight.y, carLaneThreeRowEight.width, carLaneThreeRowEight.height, null);

            // draw the cars on row nine
            g.drawImage(carSix, carLaneOneRowNine.x, carLaneOneRowNine.y, carLaneOneRowNine.width, carLaneOneRowNine.height, null);
            g.drawImage(carSeven, carLaneTwoRowNine.x, carLaneTwoRowNine.y, carLaneTwoRowNine.width, carLaneTwoRowNine.height, null);

            // draw the cars on row ten
            g.drawImage(carOne, carLaneTwoRowTen.x, carLaneTwoRowTen.y, carLaneTwoRowTen.width, carLaneTwoRowTen.height, null);
            g.drawImage(carTwo, carLaneThreeRowTen.x, carLaneThreeRowTen.y, carLaneThreeRowTen.width, carLaneThreeRowTen.height, null);
            g.drawImage(carThree, carLaneFourRowTen.x, carLaneFourRowTen.y, carLaneFourRowTen.width, carLaneFourRowTen.height, null);
            
            // draw the cars on row eleven
            g.drawImage(carFour, carLaneOneRowEleven.x, carLaneOneRowEleven.y, carLaneOneRowEleven.width, carLaneOneRowEleven.height, null);
            g.drawImage(carFive, carLaneTwoRowEleven.x, carLaneTwoRowEleven.y, carLaneTwoRowEleven.width, carLaneTwoRowEleven.height, null);
            g.drawImage(carSix, carLaneFourRowEleven.x, carLaneFourRowEleven.y, carLaneFourRowEleven.width, carLaneFourRowEleven.height, null);
            
            // set the score font and display
            g.setColor(Color.red);
            g.setFont(scoreFont);
            g.drawString("" + score, WIDTH - 780, 880);

            // set the Level font and display
            g.setColor(Color.red);
            g.setFont(scoreFont);
            g.drawString("Level " + level, WIDTH - 780, 50);
        }

        // GAME DRAWING ENDS HERE
    }

    // add images from file on to program
    public BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            File file = new File(filename);
            img = ImageIO.read(file);
        } catch (Exception e) {
            // if there is an error, print it
            e.printStackTrace();
        }
        return img;
    }

    // if the player dies
    public void reset() {

        if (restart) {

            // set the users car position back to normal
            usersCar = new Rectangle(365, 650, 90, 180);

            // booleans become false
            dead = false;
            start = false;

            // reset the variables
            speedOthers = 5;
            score = 0;
            level = 1;

            // reset the car positions
            // For Row One
            carLaneOneRowOne = new Rectangle(115, 0, 90, 180);
            carLaneTwoRowOne = new Rectangle(270, 0, 90, 180);
            carLaneFourRowOne = new Rectangle(590, 0, 90, 180);
            // For Row Two
            carLaneOneRowTwo = new Rectangle(115, -600, 90, 180);
            carLaneFourRowTwo = new Rectangle(590, -600, 90, 180);
            // For Row Three
            carLaneTwoRowThree = new Rectangle(270, -1200, 90, 180);
            carLaneFourRowThree = new Rectangle(590, -1200, 90, 180);
            // For Row Four
            carLaneTwoRowFour = new Rectangle(270, -1800, 90, 180);
            carLaneThreeRowFour = new Rectangle(435, -1800, 90, 180);
            // For Row Five
            carLaneThreeRowFive = new Rectangle(435, -2400, 90, 180);
            carLaneFourRowFive = new Rectangle(590, -2400, 90, 180);
            // For Row Six
            carLaneOneRowSix = new Rectangle(115, -3000, 90, 180);
            carLaneTwoRowSix = new Rectangle(270, -3000, 90, 180);
            carLaneThreeRowSix = new Rectangle(435, -3000, 90, 180);
            // For Row Seven
            carLaneOneRowSeven = new Rectangle(115, -3600, 90, 180);
            carLaneThreeRowSeven = new Rectangle(435, -3600, 90, 180);
            carLaneFourRowSeven = new Rectangle(590, -3600, 90, 180);
            // For Row Eight
            carLaneOneRowEight = new Rectangle(115, -4200, 90, 180);
            carLaneThreeRowEight = new Rectangle(435, -4200, 90, 180);
            // For Row Nine
            carLaneOneRowNine = new Rectangle(115, -4800, 90, 180);
            carLaneTwoRowNine = new Rectangle(270, -4800, 90, 180);
            // For Row Ten
            carLaneTwoRowTen = new Rectangle(270, -5400, 90, 180);
            carLaneThreeRowTen = new Rectangle(435, -5400, 90, 180);
            carLaneFourRowTen = new Rectangle(590, -5400, 90, 180);
            // For Row Eleven
            carLaneOneRowEleven = new Rectangle(115, -6000, 90, 180);
            carLaneTwoRowEleven = new Rectangle(270, -6000, 90, 180);
            carLaneFourRowEleven = new Rectangle(590, -6000, 90, 180);

        }
        restart = false;
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        
        music.play();
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if (clicked) {
                if (start) {
                    
                // make the game stop when a collision happens
                    // row one collisons
                    if (usersCar.x >= (carLaneOneRowOne.x - Xhitbox) && usersCar.x <= (carLaneOneRowOne.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowOne.y - Yhitbox) && usersCar.y <= (carLaneOneRowOne.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneTwoRowOne.x - Xhitbox) && usersCar.x <= (carLaneTwoRowOne.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowOne.y - Yhitbox) && usersCar.y <= (carLaneTwoRowOne.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowOne.x - Xhitbox) && usersCar.x <= (carLaneFourRowOne.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowOne.y - Yhitbox) && usersCar.y <= (carLaneFourRowOne.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row two collisions
                    if (usersCar.x >= (carLaneOneRowTwo.x - Xhitbox) && usersCar.x <= (carLaneOneRowTwo.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowTwo.y - Yhitbox) && usersCar.y <= (carLaneOneRowTwo.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowTwo.x - Xhitbox) && usersCar.x <= (carLaneFourRowTwo.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowTwo.y - Yhitbox) && usersCar.y <= (carLaneFourRowTwo.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row three collisions
                    if (usersCar.x >= (carLaneTwoRowThree.x - Xhitbox) && usersCar.x <= (carLaneTwoRowThree.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowThree.y - Yhitbox) && usersCar.y <= (carLaneTwoRowThree.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowThree.x - Xhitbox) && usersCar.x <= (carLaneFourRowThree.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowThree.y - Yhitbox) && usersCar.y <= (carLaneFourRowThree.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row four collisions
                    if (usersCar.x >= (carLaneTwoRowFour.x - Xhitbox) && usersCar.x <= (carLaneTwoRowFour.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowFour.y - Yhitbox) && usersCar.y <= (carLaneTwoRowFour.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneThreeRowFour.x - Xhitbox) && usersCar.x <= (carLaneThreeRowFour.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneThreeRowFour.y - Yhitbox) && usersCar.y <= (carLaneThreeRowFour.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row five collisions
                    if (usersCar.x >= (carLaneThreeRowFive.x - Xhitbox) && usersCar.x <= (carLaneThreeRowFive.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneThreeRowFive.y - Yhitbox) && usersCar.y <= (carLaneThreeRowFive.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowFive.x - Xhitbox) && usersCar.x <= (carLaneFourRowFive.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowFive.y - Yhitbox) && usersCar.y <= (carLaneFourRowFive.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row six collisions
                    if (usersCar.x >= (carLaneOneRowSix.x - Xhitbox) && usersCar.x <= (carLaneOneRowSix.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowSix.y - Yhitbox) && usersCar.y <= (carLaneOneRowSix.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneTwoRowSix.x - Xhitbox) && usersCar.x <= (carLaneTwoRowSix.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowSix.y - Yhitbox) && usersCar.y <= (carLaneTwoRowSix.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneThreeRowSix.x - Xhitbox) && usersCar.x <= (carLaneThreeRowSix.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneThreeRowSix.y - Yhitbox) && usersCar.y <= (carLaneThreeRowSix.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row seven collisions
                    if (usersCar.x >= (carLaneOneRowSeven.x - Xhitbox) && usersCar.x <= (carLaneOneRowSeven.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowSeven.y - Yhitbox) && usersCar.y <= (carLaneOneRowSeven.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneThreeRowSeven.x - Xhitbox) && usersCar.x <= (carLaneThreeRowSeven.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneThreeRowSeven.y - Yhitbox) && usersCar.y <= (carLaneThreeRowSeven.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowSeven.x - Xhitbox) && usersCar.x <= (carLaneFourRowSeven.y + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowSeven.y - Yhitbox) && usersCar.y <= (carLaneFourRowSeven.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row eight collisions
                    if (usersCar.x >= (carLaneThreeRowEight.x - Xhitbox) && usersCar.x <= (carLaneThreeRowEight.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneThreeRowEight.y - Yhitbox) && usersCar.y <= (carLaneThreeRowEight.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneOneRowEight.x - Xhitbox) && usersCar.x <= (carLaneOneRowEight.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowEight.y - Yhitbox) && usersCar.y <= (carLaneOneRowEight.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row nine collisions
                    if (usersCar.x >= (carLaneOneRowNine.x - Xhitbox) && usersCar.x <= (carLaneOneRowNine.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowNine.y - Yhitbox) && usersCar.y <= (carLaneOneRowNine.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneTwoRowNine.x - Xhitbox) && usersCar.x <= (carLaneTwoRowNine.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowNine.y - Yhitbox) && usersCar.y <= (carLaneTwoRowNine.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // row ten collisions
                    if (usersCar.x >= (carLaneTwoRowTen.x - Xhitbox) && usersCar.x <= (carLaneTwoRowTen.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowTen.y - Yhitbox) && usersCar.y <= (carLaneTwoRowTen.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneThreeRowTen.x - Xhitbox) && usersCar.x <= (carLaneThreeRowTen.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneThreeRowTen.y - Yhitbox) && usersCar.y <= (carLaneThreeRowTen.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowTen.x - Xhitbox) && usersCar.x <= (carLaneFourRowTen.y + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowTen.y - Yhitbox) && usersCar.y <= (carLaneFourRowTen.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    // row elven collisons
                    if (usersCar.x >= (carLaneOneRowEleven.x - Xhitbox) && usersCar.x <= (carLaneOneRowEleven.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneOneRowEleven.y - Yhitbox) && usersCar.y <= (carLaneOneRowEleven.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneTwoRowEleven.x - Xhitbox) && usersCar.x <= (carLaneTwoRowEleven.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneTwoRowEleven.y - Yhitbox) && usersCar.y <= (carLaneTwoRowEleven.y + Yhitbox)) {
                            dead = true;
                        }
                    }
                    if (usersCar.x >= (carLaneFourRowEleven.x - Xhitbox) && usersCar.x <= (carLaneFourRowEleven.x + Xhitbox)) {
                        if (usersCar.y >= (carLaneFourRowEleven.y - Yhitbox) && usersCar.y <= (carLaneFourRowEleven.y + Yhitbox)) {
                            dead = true;
                        }
                    }

                    // get the other cars to move down on screen
                    if (dead != true) {

                        // while the user isnt dead the game can't restart
                        restart = false;

                        // increase the speed and level over a certain interval in time
                        time = time - 1;

                        if (time <= 0) {
                            speedOthers = speedOthers + 1;
                            level = level + 1; 
                            time = 1200;
                        }

                        // set speed for the background
                        backgroundOne.y = backgroundOne.y + roadSpeed;
                        backgroundTwo.y = backgroundTwo.y + roadSpeed;
                        backgroundThree.y = backgroundThree.y + roadSpeed;

                        // set the speed for the cars on row one
                        carLaneOneRowOne.y = carLaneOneRowOne.y + speedOthers;
                        carLaneTwoRowOne.y = carLaneTwoRowOne.y + speedOthers;
                        carLaneFourRowOne.y = carLaneFourRowOne.y + speedOthers;

                        // set the speed for the cars on row two
                        carLaneOneRowTwo.y = carLaneOneRowTwo.y + speedOthers;
                        carLaneFourRowTwo.y = carLaneFourRowTwo.y + speedOthers;

                        // set the speed for the cars on row three
                        carLaneTwoRowThree.y = carLaneTwoRowThree.y + speedOthers;
                        carLaneFourRowThree.y = carLaneFourRowThree.y + speedOthers;

                        // set the speed for the cars on row four
                        carLaneTwoRowFour.y = carLaneTwoRowFour.y + speedOthers;
                        carLaneThreeRowFour.y = carLaneThreeRowFour.y + speedOthers;

                        // set the speed for the cars on row five
                        carLaneThreeRowFive.y = carLaneThreeRowFive.y + speedOthers;
                        carLaneFourRowFive.y = carLaneFourRowFive.y + speedOthers;

                        // set the speed for the cars on row six
                        carLaneOneRowSix.y = carLaneOneRowSix.y + speedOthers;
                        carLaneTwoRowSix.y = carLaneTwoRowSix.y + speedOthers;
                        carLaneThreeRowSix.y = carLaneThreeRowSix.y + speedOthers;

                        // set the speed for the cars on row seven
                        carLaneOneRowSeven.y = carLaneOneRowSeven.y + speedOthers;
                        carLaneThreeRowSeven.y = carLaneThreeRowSeven.y + speedOthers;
                        carLaneFourRowSeven.y = carLaneFourRowSeven.y + speedOthers;

                        // set the speed for the cars on row eight
                        carLaneOneRowEight.y = carLaneOneRowEight.y + speedOthers;
                        carLaneThreeRowEight.y = carLaneThreeRowEight.y + speedOthers;

                        // set the speed for the cars on row nine
                        carLaneOneRowNine.y = carLaneOneRowNine.y + speedOthers;
                        carLaneTwoRowNine.y = carLaneTwoRowNine.y + speedOthers;

                        // set the speed for the cars on row ten
                        carLaneTwoRowTen.y = carLaneTwoRowTen.y + speedOthers;
                        carLaneThreeRowTen.y = carLaneThreeRowTen.y + speedOthers;
                        carLaneFourRowTen.y = carLaneFourRowTen.y + speedOthers;
                        
                        // set the speed for the cars on row one
                        carLaneOneRowEleven.y = carLaneOneRowEleven.y + speedOthers;
                        carLaneTwoRowEleven.y = carLaneTwoRowEleven.y + speedOthers;
                        carLaneFourRowEleven.y = carLaneFourRowEleven.y + speedOthers;

                        // set the background to loop back
                        if (backgroundOne.y >= 900) {
                            backgroundOne.y = -450;
                        }
                        if (backgroundTwo.y >= 900) {
                            backgroundTwo.y = -450;
                        }
                        if (backgroundThree.y >= 900) {
                            backgroundThree.y = -450;
                        }

                        // Row one cars
                        if (carLaneOneRowOne.y >= 900) {
                            carLaneOneRowOne.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneTwoRowOne.y >= 900) {
                            carLaneTwoRowOne.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowOne.y >= 900) {
                            carLaneFourRowOne.y = setpoint;
                            score = score + addScore;
                        }

                        // row two cars
                        if (carLaneOneRowTwo.y >= 900) {
                            carLaneOneRowTwo.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowTwo.y >= 900) {
                            carLaneFourRowTwo.y = setpoint;
                            score = score + addScore;
                        }

                        // row three cars
                        if (carLaneTwoRowThree.y >= 900) {
                            carLaneTwoRowThree.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowThree.y >= 900) {
                            carLaneFourRowThree.y = setpoint;
                            score = score + addScore;
                        }

                        // row four cars
                        if (carLaneTwoRowFour.y >= 900) {
                            carLaneTwoRowFour.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneThreeRowFour.y >= 900) {
                            carLaneThreeRowFour.y = setpoint;
                            score = score + addScore;
                        }

                        // row five cars
                        if (carLaneThreeRowFive.y >= 900) {
                            carLaneThreeRowFive.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowFive.y >= 900) {
                            carLaneFourRowFive.y = setpoint;
                            score = score + addScore;
                        }

                        // row six cars
                        if (carLaneOneRowSix.y >= 900) {
                            carLaneOneRowSix.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneTwoRowSix.y >= 900) {
                            carLaneTwoRowSix.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneThreeRowSix.y >= 900) {
                            carLaneThreeRowSix.y = setpoint;
                            score = score + addScore;
                        }

                        // row seven cars
                        if (carLaneOneRowSeven.y >= 900) {
                            carLaneOneRowSeven.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneThreeRowSeven.y >= 900) {
                            carLaneThreeRowSeven.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowSeven.y >= 900) {
                            carLaneFourRowSeven.y = setpoint;
                            score = score + addScore;
                        }

                        // row eight cars
                        if (carLaneOneRowEight.y >= 900) {
                            carLaneOneRowEight.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneThreeRowEight.y >= 900) {
                            carLaneThreeRowEight.y = setpoint;
                            score = score + addScore;
                        }

                        // row nine cars
                        if (carLaneOneRowNine.y >= 900) {
                            carLaneOneRowNine.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneTwoRowNine.y >= 900) {
                            carLaneTwoRowNine.y = setpoint;
                            score = score + addScore;
                        }

                        // row ten cars
                        if (carLaneTwoRowTen.y >= 900) {
                            carLaneTwoRowTen.y = setpoint;
                            score = score + addScore;

                        }
                        if (carLaneThreeRowTen.y >= 900) {
                            carLaneThreeRowTen.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowTen.y >= 900) {
                            carLaneFourRowTen.y = setpoint;
                            score = score + addScore;
                        }
                        
                        // Row eleven cars
                        if (carLaneOneRowEleven.y >= 900) {
                            carLaneOneRowEleven.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneTwoRowEleven.y >= 900) {
                            carLaneTwoRowEleven.y = setpoint;
                            score = score + addScore;
                        }
                        if (carLaneFourRowEleven.y >= 900) {
                            carLaneFourRowEleven.y = setpoint;
                            score = score + addScore;
                        }
                        

                        // get the players car to move left
                        if (usersCar.x > 100) {
                            if (carLeft == true) {
                                usersCar.x = usersCar.x - speed;
                            } else {
                                carLeft = false;
                            }
                        }
                        // get the players car to move right
                        if (usersCar.x < 610) {
                            if (carRight == true) {
                                usersCar.x = usersCar.x + speed;

                            } else {
                                carRight = false;
                            }
                        }
                    } else {
                        reset();
                    }
                }
            }

            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        Testing game = new Testing();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        frame.addKeyListener(game);
        game.addMouseListener(game);
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            carLeft = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            carRight = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            start = true;
        }
        if (key == KeyEvent.VK_R) {
            restart = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // car move left
        if (key == KeyEvent.VK_LEFT) {
            carLeft = false;
        }
        // car move right
        if (key == KeyEvent.VK_RIGHT);
        carRight = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // get the x and y coordinates on the screen
        int x = e.getX();
        int y = e.getY();
        
        // start button
        if (x >= 10 && x <= 192) {
            if (y >= 717 && y <= 778) {
                clicked = true;
            }
        }
        // How to Play button
        if (x >= 10 && x <= 387) {
            if (y >= 786 && y <= 848) {
                clickedTwo = true;
            }
        }
        // back button to go back to front menu
        if(x >= 700 && x <= 800){
            if(y >= 10 && y <= 60){
                clicked = false;
                clickedTwo = false;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
