package fibonacciGraph;

import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// creating n variable and scanner to get input
		int n;
		Scanner input = new Scanner(System.in);

		// prompting the user for input and setting n variable equal to it
		System.out.println("Please enter a positive number or zero");
		n = input.nextInt();
		input.close();
		
		//testing recursive method
		long recFibStartTime = System.nanoTime();//starting timer
		recursiveFibonacci(n);
		long recFibEndTime = System.nanoTime();//ending timer
		long totalRecursiveTime = (recFibEndTime - recFibStartTime);//calculating total time
		System.out.println("Rec fib time: " + totalRecursiveTime + " and result: " + recursiveFibonacci(n));
		
		//testing iterative method
		long iteravtiveStartTime = System.nanoTime();//starting timer
		iterativeFibonacci(n);
		long iterativeEndTime = System.nanoTime(); //ending timer
		long totalIterativeTime = (iterativeEndTime - iteravtiveStartTime);
		System.out.println("Iterative fib time: " + totalIterativeTime + " and results: " + iterativeFibonacci(n));
		
		//converting total method times data types to double
		double totalRecTime = totalRecursiveTime;
		double totalItvTime = totalIterativeTime;
		
		//creating charts
		XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("Input").yAxisTitle("Time").build();
		
		
		//adding series
		chart.addSeries("Recursive", new double[] {0, (n/2) , n}, new double[] { 0, (totalRecTime/2), totalRecTime }).setMarker(SeriesMarkers.NONE);
		chart.addSeries("Iterative", new double[] {0, (n/2) ,n}, new double[] { 0, (totalItvTime/2), totalItvTime }).setMarker(SeriesMarkers.NONE);
		
		//display chart
		new SwingWrapper<XYChart>(chart).displayChart();

		
		
	}// end of main method

	// recursive fibonacci method
	public static int recursiveFibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int results = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
		return results;
	}

	//iterative fibonacci method
	public static int iterativeFibonacci(int n) {
		int i;
		int f[] = new int[n + 2];
		f[0] = 0;
	    f[1] = 1;
	    
	    for (i = 2; i <= n; i++) {
	        // Add the previous 2 numbers
	        // in the series and store it
	        f[i] = f[i - 1] + f[i - 2];
	    }
	    return f[n];
	}
}//end of Main class