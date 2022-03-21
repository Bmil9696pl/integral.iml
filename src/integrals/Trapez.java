package integrals;

public class Trapez extends IntegralAlgorithm{
    @Override
    public void calculateIntegral(){
        double krok = (b-a)/n;
        double x = a;
        for (int i = 0; i < n; i++){
            double f1 = function.getValue(x);
            x = x+krok;
            double f2 = function.getValue(x);
            sum+=((f1+f2)/2)*krok;
        }
    }
}
