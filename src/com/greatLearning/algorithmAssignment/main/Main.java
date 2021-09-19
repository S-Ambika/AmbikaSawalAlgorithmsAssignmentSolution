package com.greatLearning.algorithmAssignment.main;

import java.util.Scanner;

import com.greatLearning.algorithmAssignment.utils.SearchingSortingHelper;
import com.gretaLearning.algorithmAssignment.beans.CompanyDetails;

public class Main {

	double[] stock_price_arr;
	String[] company_name_arr;
	boolean[] rise_in_stock_price;
	SearchingSortingHelper searchingSortingHelper=new SearchingSortingHelper();
	Scanner sc_input = new Scanner(System.in);
	

	private void insertValues(double arr[], int size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at position " + i + "-  ");
			arr[i] = sc_input.nextInt();
		}
	}

	private void printValues(double arr[], int size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			System.out.println("Value at position " + i + "is:" + arr[i]);
		}
		System.out.println();
	}



	private void TaskImplementation() {
		
		System.out.println("Please enter total number of elements required inside array");

		int arr_size = sc_input.nextInt();

		stock_price_arr = new double[arr_size];

		System.out.println("Please enter elements for  array");
		insertValues(stock_price_arr,arr_size);
		printValues(stock_price_arr,arr_size);
		//sortArray(array, 0, array.length - 1);

		stock_price_arr=searchingSortingHelper.sortInAscending(stock_price_arr, 0,arr_size-1);
		printValues(stock_price_arr,arr_size);
		
		//binarySearch(0, arr.length - 1, search_value);

		int index=searchingSortingHelper.searchElementUsingBinarySearch(stock_price_arr,0, arr_size-1,0,43);
	
	System.out.println(index);
	}

	public static void main(String args[]) {

		Main main=new Main();
		main.TaskImplementation();
		
		
		// CompanyDetails companydetails = new CompanyDetails();

	}

}
