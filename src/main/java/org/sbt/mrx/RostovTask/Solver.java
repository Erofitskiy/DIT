package org.sbt.mrx.RostovTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static List<Double> solveQuadraticEquation(double a, double b, double c) throws Exception {
        List<Double> result = new ArrayList<>();
        if (a == 0.0)
            result.add(solveLinearEquation(b, c));
        else{
            double D = b*b - 4*a*c;
            if ( D < 0){
                System.out.println("No real roots");
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
