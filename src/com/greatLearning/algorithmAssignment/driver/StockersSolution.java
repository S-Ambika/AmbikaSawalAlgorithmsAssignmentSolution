package com.greatLearning.algorithmAssignment.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.greatLearning.algorithmAssignment.utils.Constants;
import com.greatLearning.algorithmAssignment.utils.SearchingSortingHelper;

public class StockersSolution {

	double[] stock_price_arr;
	boolean[] isRise_in_stock_price;
	boolean flag;
	int count_rose_price, count_declined_price, arr_size;
	SearchingSortingHelper searchingSortingHelper = new SearchingSortingHelper();
	Scanner sc_input = new Scanner(System.in);

	private void solutionImplementation() {
		System.out.println("Enter the no. of companies : ");
		arr_size = sc_input.nextInt();
		if(arr_size>0) {
		stock_price_arr = new double[arr_size];
		isRise_in_stock_price = new boolean[arr_size];
		insertValues(stock_price_arr, isRise_in_stock_price);
		/*
		 * asking user to select operation till user exit the program
		 */
		flag = true;
		while (flag) {
			taskToBePerformed();
		}
		}
		else {
			System.out.println("Invalid!!! Enter more than 0 value..");

		}
	}

	private void taskToBePerformed() {

		System.out.println(
				"\n..........................................\nPlease Select following tasks that you want to perform : \n"
						+ Constants.FirstTask + Constants.SecondTask + Constants.ThirdTask + Constants.FourthTask
						+ Constants.FifthTask + Constants.ExitTask);
		try {
			int selected_input = sc_input.nextInt();
			switch (selected_input) {
			case 0: // press 0 to exit
				flag = false;
				System.out.println("Thank you for using our system!!!");
				System.exit(1);
				break;

			case 1:
				/*
				 * implementing merge sorting as it has best, average, worst case O(nlogn) as
				 * required
				 */
				stock_price_arr = searchingSortingHelper.sort(stock_price_arr, 0, arr_size - 1, true);
				System.out.println("Company stock prices In Ascending order :");
				printValues(stock_price_arr);
				flag = true;
				break;

			case 2:
				/*
				 * implementing merge sorting as it has best, average, worst case O(nlogn) as
				 * required
				 */
				stock_price_arr = searchingSortingHelper.sort(stock_price_arr, 0, arr_size - 1, false);
				System.out.println("Company stock prices In Descending order :");
				printValues(stock_price_arr);
				flag = true;
				break;

			case 3:
				System.out.println("Total no of companies for which stock prices rose today : "
						+ risePriceCount(isRise_in_stock_price));
				flag = true;
				break;

			case 4:
				System.out.println("Total no of companies for which stock prices declined today : "
						+ declinedPriceCount(isRise_in_stock_price));
				flag = true;
				break;

			case 5:
				/*
				 * implementing sorting before searching in case user directly select search
				 * option
				 */
				stock_price_arr = searchingSortingHelper.sort(stock_price_arr, 0, arr_size - 1, true);
				System.out.println("Enter the key value");
				double search_val = sc_input.nextDouble();
				/*
				 * implementing binary searching as we have sorted array
				 */
				int index = searchingSortingHelper.searchElementUsingBinarySearch(stock_price_arr, 0, arr_size - 1,
						search_val);
				if (index == -1)
					System.out.println("Stock of value " + search_val + " is NOT present");
				else
					System.out.println("Stock of value " + search_val + " is present");
				flag = true;
				break;

			default:
				System.out.println("Please select valid input value....");
				break;
			}
		}
		/*
		 * exception handling for other than integer values
		 */
		catch (InputMismatchException e) {
			System.out.println("You have entered invalid values");
			System.exit(1);
		}
	}

	private void insertValues(double arr[], boolean boolArr[]) {
		int comp_count;
		// TODO Auto-generated method stub
		for (int i = 0; i < arr_size; i++) {
			try {
				comp_count = i + 1;
				System.out.println("\nEnter current stock price of the company " + comp_count + " : ");
				arr[i] = sc_input.nextDouble();
				if(arr[i]>0) {
				System.out.println("Whether company's stock price rose today compare to yesterday?(true/false)");
				boolArr[i] = sc_input.nextBoolean();
				}
				else {
					System.out.println("You have entered invalid values");
					System.exit(1);
				}
			} catch (InputMismatchException e) {
				System.out.println("You have entered invalid values");
				System.exit(1);
			}
		}
	}

	private void printValues(double arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr_size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	/*
	 * getting count of rose stock prices
	 */
	private int risePriceCount(boolean arr[]) {
		int count = 0;
		for (Boolean isRise : arr)
			if (isRise)
				count++;
		return count;
	}

	/*
	 * getting count of declined stock prices
	 */
	private int declinedPriceCount(boolean arr[]) {
		int count = 0;
		for (Boolean isRise : arr)
			if (!isRise)
				count++;
		return count;
	}

	public static void main(String args[]) {

		StockersSolution main = new StockersSolution();
		main.solutionImplementation();

	}

}
