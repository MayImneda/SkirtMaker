package com.company;
import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;
/**
 * Created by may on 6/6/17.
 */
public class Calculator {
    //input
    private double gords;
    private double waist;
    private double newWaist;
    private double newHip;
    private double hip;
    private double rise;
    private double length;
    private double newLength;
    private double easement;
    private double seamAllowance;
    private double hem;
    private double flare;
    private double newFlare;
    private double waistRound;
    private double lengthRound;

// calculations
    public Calculator(){
/*
        gords = 6;
        waist = 36;
        hip = 42;
        rise = 6;
        length = 36;
        easement = 2;
        seamAllowance = 0.5;
        hem = 0.75;
        flare = 4;
**/

    }

    public void userPrompt(){

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to gorded skirt calculator, this will help you pattern draft your ownn skirt.");
        System.out.println("Start with some bucher paper folded in half keeping true right angles.  The width need not be long as you'll see,");
        System.out.println("however the lenght must exceed your skirt lenght.  All lines are drawn from fold keeping those right angles true.");

        System.out.println("How many gords do you want for your skirt? (suggested 6, 8, 10, 12): ");
        in.nextLine();
        gords = in.nextDouble();
        if(gords % 2 == 1&&gords <= 6 ){
            System.out.println("gords must be 6 or more, and even in number");
            userPrompt();
        }


        System.out.println("Waist measurment in inches: ");
        in.nextLine();
        waist = in.nextDouble();
        if(waist<=0){
            System.out.println("Waist must exist");
            userPrompt();
        }



        System.out.println("Hip measurment in inches: ");
        in.nextLine();
        hip = in.nextDouble();
        if(hip <= waist){
            System.out.println("Your hips are larger than your waist.  If not seek medical attention and a tailor");
            userPrompt();
        }


        System.out.println("How many inches from your natural waist to your hip bone?: ");
        in.nextLine();
        rise = in.nextDouble();
        if(rise <0){
            System.out.println("Your waist and hip are seperate.  If not seek medical attention and a talior");
            userPrompt();
        }


        System.out.println("How long do you want your skirt in inches: ");
        in.nextLine();
        length = in.nextDouble();
        if(length < rise){
            System.out.println("Total lenght must exceed your rise, even if you want a slutty skirt");
            userPrompt();
        }


        System.out.println("How much easement do you need in inches (suggested 1-5 inches): ");
        in.nextLine();
        easement = in.nextDouble();
        if(easement < 0){
            System.out.println("If you want this to actually fit, you need easement");
            userPrompt();
        }


        System.out.println("How much seam allowance in inches (suggested 0.25 0.5 0.625 inches)?: ");
        in.nextLine();
        seamAllowance = in.nextDouble();
        if(seamAllowance < 0){
            System.out.println("Please have allowance be over nothing and under 1.5 inches");
            userPrompt();
        }



        System.out.println("How much of a hem in inches (suggested 0.75 inches)?: ");
        in.nextLine();
        hem = in.nextDouble();
        if(hem > 3){
            System.out.println("Must be under 3 inches, 3 inches is PLENTLY of growing and shrinking room.");
            userPrompt();
        }


        System.out.println("How much flare in inches?: ");
        flare = in.nextDouble();
        in.nextLine();
    }

    public void calculate(){

        newWaist = (waist + easement)/gords/2 + seamAllowance;
        newHip = (hip + easement)/gords/2 + seamAllowance;
        newLength = length + hem;
        newFlare = (hip + easement + flare)/gords/2 + seamAllowance;
        waistRound = newWaist/2/2 + seamAllowance;
        lengthRound = newLength/2/2 +seamAllowance;

    }

    public void output(){

        //insert direction and numbers in context

        System.out.printf("Draw line %.2f\n",newWaist);
        System.out.printf("inches long, this line is your waist, A ");
        System.out.printf("Go %.2f\n",rise);
        System.out.printf("lenghtwise down and draw line %.2f\n",newHip);
        System.out.printf("inches across, this is your hip, B ");
        System.out.printf("Go %.2f\n",newLength);
        System.out.printf("inches down from waist line, make a mark for flare");
        System.out.printf("final bottom measurment, aka flare point C is  %.2f\n",newFlare);
        System.out.printf("inches across");
        System.out.printf("measure one inch up from end of point A, and mark %.2f\n", waistRound);
        System.out.printf("merge this point down to A ");
        System.out.printf("to prevent hankerchif points (unless that is what you want) mark 1-3 inches above end of hemline and blend down to %.2f\n",lengthRound);

    }
}



