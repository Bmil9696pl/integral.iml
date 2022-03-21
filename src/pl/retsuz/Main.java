package pl.retsuz;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapez;

import java.util.Scanner;

public class Main {

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    protected static IntegralAlgorithm algorithm2;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Wprowadz poczatek przedzialu:");
        double a = sc.nextDouble();
        System.out.println("Wprowadz koniec przedzialu:");
        double b = sc.nextDouble();
        System.out.println("Wprowadz krok:");
        int n= sc.nextInt();

        if(a>b){
            System.out.println("Poczatek przedzialu musi byc mniejszy niz koniec przedzialu");
        } else {
            functionBuilder = new CosineExampleBuilder();
            givenExample = functionBuilder.build();
            algorithm = new MonteCarlo();
            algorithm2 = new Trapez();

            algorithm.setFunction(givenExample);
            algorithm.setA(a);
            algorithm.setB(b);
            algorithm.setN(n);
            algorithm.calculateIntegral();

            algorithm2.setFunction(givenExample);
            algorithm2.setA(a);
            algorithm2.setB(b);
            algorithm2.setN(n);
            algorithm2.calculateIntegral();

            double monteIntegral = algorithm.getIntegral();
            double exactIntegral = givenExample.getExactIntegralValue(b) - givenExample.getExactIntegralValue(a);
            double error = Math.abs(monteIntegral - exactIntegral);

            double trapezIntegral = algorithm2.getIntegral();
            double trapezError = Math.abs(trapezIntegral - exactIntegral);

            System.out.println("Numeryczna\t" + monteIntegral);
            System.out.println("Dokładna\t" + exactIntegral);
            System.out.println("Błąd\t\t" + error);
            System.out.println("Trapez:\t" + trapezIntegral);
            System.out.println("Błąd trapezu:\t" + trapezError);
        }
    }
}
