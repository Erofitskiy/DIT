package org.sbt.mrx.RostovTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a*x^2 + b*x + c = 0");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();
        try {
            List<Double> solutions = solveQuadraticEquation(a, b, c);
            for (double x : solutions)
                System.out.println("x = " + x);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Double> solveQuadraticEquation(double a, double b, double c) throws Exception {
        List<Double> result = new ArrayList<>();
        if (a == 0.0)
            result.add(solveLinearEquation(b, c));
        else{
            double D = b*b - 4*a*c;
            if ( D < 0 ){
                System.out.println("No real roots");
                if ( a > 0 ){
                    System.out.println("x1 = " + (-b/2/a) + " + " + Math.sqrt(-D)/2/a + "i");
                    System.out.println("x2 = " + (-b/2/a) + " - " + Math.sqrt(-D)/2/a + "i");
                } else {
                    System.out.println("x1 = " + (-b/2/a) + " - " + Math.sqrt(-D)/2/Math.abs(a) + "i");
                    System.out.println("x2 = " + (-b/2/a) + " + " + Math.sqrt(-D)/2/a + "i");
                }
            } else {
                result.add( (-b + Math.sqrt(D)) / (2*a) );
                result.add( (-b - Math.sqrt(D)) / (2*a) );
            }
        }
        return result;
    }
    
    public static double solveLinearEquation(double b, double c) throws Exception {
        if (b == 0){
            throw new Exception("Not an equation");
        }
        return -c/b;
    }
}
