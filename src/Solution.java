/********************************************** 
Workshop # 7
Course: JAC433
Last Name:Yang
First Name:Shuqi
ID:132162207
Section:NBB 
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature 
Date:2022-03-25
**********************************************/ 
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
//process the array and test all the functionalities
public class Solution {
	double[] array;
	public Solution(double[] arr) {
		this.array = arr;
	}
	//assign customized lambda expr to each one of them as a value
	public static final ArrayProcessor findMax = (double[] arr) -> {
		double max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	};
	public static final ArrayProcessor findMin = (double[] arr) -> {
		double min = arr[0]; 
		for(int i = 1; i < arr.length; i++) {  
			if(arr[i] < min) {
				min = arr[i];  
			}
		}
		return min;
	};
	public static ArrayProcessor findAvg = (double[] arr) ->{
		double avg, total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return avg = total/arr.length;
		
	};
	public static final ArrayProcessor findSum = (double[] arr) -> {
		double sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	};
	//main method to test the implementation
	public static void main(String[] args) {  
		
		Boolean exit = false;
		int mainOpt;
		String mainOption;
		do {
			System.out.println("****ArrayProcessor Program****\n\nPlease Choose one of the following options\n1. Enter Array\n2. Exit Program\n");
			Scanner input0 = new Scanner(System.in);
			try {
				mainOption = input0.next();
				System.out.println();
				mainOpt = Integer.parseInt(mainOption);
			}catch(Exception e) {
				System.out.println("Please Enter Integer 1 or 2\n");
				continue;
			}
			switch(mainOpt) {
			case 1:
				System.out.print("How many elements(double) you want to create inside the Array: ");
				int size = input0.nextInt();
				double[] newArr = new double[size];
				for(int i = 0; i < size; i++) {
					System.out.print("Enter Element #" + (i+1) + ": ");
					double ele = input0.nextDouble();
					//System.out.println();
					newArr[i] = ele;
				}
				Solution newSol = new Solution(newArr);
				System.out.println("\n---- Here is an Report on the Array you have just created ----");
				newSol.Report();
				break;
			case 2:
				System.out.println("Good Bye!");
				input0.close();
				exit = true;
				break;
			default:
				System.out.println("Please Enter Integer 1 or 2\n");
			}
		}while(!exit);

	}
	
	public static ArrayProcessor counter(double value) {
		//return value is a lambda expression
		return (double[] arr)->{
			int counts =0;
			for(int i = 0; i< arr.length; i++) {
				if(arr[i] == value) {
					counts++;
				}
			}
			return counts;
		};
		//return counterIntf;
	};

	public void Report() {
		final DecimalFormat twoDeci = new DecimalFormat("0.00");
		double max, min, sum, avg;
		max = findMax.apply(array);
		min = findMin.apply(array);
		sum = findSum.apply(array);
		avg = findAvg.apply(array);
		System.out.println("Maximum Value: " + max);
		System.out.println("Minimum Values: " + min);
		System.out.println("Sum of Values: " + twoDeci.format(sum));
		System.out.println("Average of Values: " + twoDeci.format(avg));
		HashMap<Double, Integer> elementCounts = new HashMap<Double, Integer>();
		for(int i = 0; i<array.length; i++) {
			//call counter method on every element in the array, 
			int counts = (int) counter(array[i]).apply(array);
			elementCounts.put(array[i], counts);
		}
		System.out.println("Occurence(s) of every Element of the Array(<Element>=<Counts>):");
		System.out.println(elementCounts);
		System.out.println("\n");
	}

}
