package com.greatLearning.algorithmAssignment.utils;

public class SearchingSortingHelper 
{


	public void mergeSort(double[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	public double[] sortInAscending(double[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sortInAscending(arr, left, mid);
			sortInAscending(arr, mid + 1, right);

			// Merge the sorted halves
			mergeSort(arr, left, mid, right);
			
			
		}
		return arr;
	}


	public int searchElementUsingBinarySearch(double arr[], int first, int last, int mid, int search_value) {
		// TODO Auto-generated method stub
		mid = (first + last) / 2;

		while (first <= last) {

			if (arr[mid] < search_value) {
				first = mid + 1;
			}

			else if (arr[mid] == search_value) {

				System.out.println("Element found at middle index :" + mid);
				return mid;
				//break;
			}

			else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Element not found!!!");
			return -1;

		}
		return 0;
	}
	
}
