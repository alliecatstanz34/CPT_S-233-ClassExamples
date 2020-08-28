import java.util.Scanner;

public class ClassExample
{
    public static void tempChange(double value, int flag) {
    	if(flag == 0){
        	double newTempC = 5 * (value - 32) / 9;
        	System.out.println("Farenheit: " + value + "\n Celcius: " + newTempC);
        }
        else{
            double newTempF = (value * 9 / 5) +32;
            System.out.println("Celcius: " + value + "\n Farenheit: " + newTempF);
        }
    }
    
    public static void main(String[] args){
    
        Scanner readme = new Scanner(System.in);
        
        System.out.println("Enter Two Numbers... first one in Farenheit and the second in Celsius");
        System.out.println("Press Enter after each input: ");
        
        double faren, celsius;
        
        faren = readme.nextDouble();
        celsius = readme.nextDouble();
        
        tempChange(faren, 0);
        tempChange(celsius, 1);

        readme.close();
 
    }		
}