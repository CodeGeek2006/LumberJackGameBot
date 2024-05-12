package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Class Wood which runs LumberJack game
 */
public class Main {

    static boolean start = false;
    public static int x ;
    public static int y ;
    public static int blue_right;
    public static int green_right;
    public static int red_right;
    /**
     * Start Function which starts only if input String 'Start' is given after the Score you desire
     */
    public static void Start(String str) {

        if (str.equals("Start")) {
            start = true;
        }
    }

    public static boolean isInt(String s) {
        try {
            int temp = Integer.parseInt(s);
            if (temp < 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static void main (String[] args) throws Exception{

        System.out.println("What Score do you want to hit? I'll do my best! Key in an Integer: ");
        Scanner sc = new Scanner(System.in);


        int score;
        String temp;


        while (true) {

            temp = sc.nextLine();
            boolean IsInt = isInt(temp);
            if (IsInt) {
                score = Integer.parseInt(temp);
                     break;
            } else {
                System.out.println("Positive Integer please! Try again: ");
            }
        }


        // Must insert enter 'Start' for programme to run
        System.out.println("Now enter 'Start' to begin!");
        while (!start) {
            String s = sc.nextLine();
            Start(s);
        }

        Robot robot = new Robot();
        // 8 Seconds of pause before activating Game
        robot.delay(8000);

        for (int i = 0; i < score/2 ; i++) {

            robot.delay(170);

            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
             x = (int) b.getX();
             y = (int) b.getY();
            Color color_left = robot.getPixelColor(x-50,y);

             int blue_left = color_left.getBlue();
             int green_left =  color_left.getGreen();
             int red_left =  color_left.getRed();


            Color color_right = robot.getPixelColor(x, y);

            blue_right = color_right.getBlue();
            green_right =  color_right.getGreen();
            red_right =  color_right.getRed();


            System.out.println(x+" "+y);
            System.out.println("R: "+red_right+" G: "+green_right+" B: "+blue_right);

            if (blue_right < 68 && 110 < red_right &&  red_right < 170 && green_right> 74 && green_right <122){
                robot.keyPress(KeyEvent.VK_LEFT);
                robot.keyRelease(KeyEvent.VK_LEFT);
                robot.delay(5);
                robot.keyPress(KeyEvent.VK_LEFT);
                robot.keyRelease(KeyEvent.VK_LEFT);

            } else {
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
                robot.delay(5);
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
            }
        }
    }
}