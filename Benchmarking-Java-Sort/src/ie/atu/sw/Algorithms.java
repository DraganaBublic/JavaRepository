
package ie.atu.sw;

public class Algorithms {

	// Bubble Sort.
	// The code here is from programiz.com where I slightly adjusted the variable
	// names for my own understanding and commented out the code.

	public int[] bubbleSort(int arr[]) {

		int size = arr.length;

		// loop to access each element of the array
		for (int i = 0; i < size - 1; i++)
			// comparing each element of the array via loop
			for (int j = 0; j < size - i - 1; j++)
				// comparing two adjacent elements in the array
				if (arr[j] > arr[j + 1]) {
					// Replace elements if not in correct order
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
		return arr;

	}
	// Selection Sort.
	// The code here is from programiz.com where I slightly adjusted the variable
	// names for my own understanding and commented out the code.

	public int[] selectionSort(int arr[]) {
		int size = arr.length;
		// set the first element as the minimum
		for (int step = 0; step < size - 1; step++) {
			int min_index = step;
			// for each of unsorted elements if element < current minimum
			for (int i = step + 1; i < size; i++) {
				// set element as new minimum
				if (arr[i] < arr[min_index]) {
					min_index = i;
				}
			}
			// put minimum at the correct position
			int temp = arr[step];
			arr[step] = arr[min_index];
			arr[min_index] = temp;
		}
		return arr;
	}

	// Insertion Sort.
	// The code here is from programiz.com where I slightly adjusted the variable
	// names for my own understanding and commented out the code.

	public int[] insertionSort(int arr[]) {
		int size = arr.length;

		for (int step = 1; step < size; step++) {
			int key = arr[step];
			int j = step - 1;
			// compare the key with each element to the left of it until an element smaller
			// than it is found
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				--j;
			}
			// Set the key to after the element just smaller than it.
			arr[j + 1] = key;
		}
		return arr;
	}

	// Quick Sort.
	// The code here is from programiz.com where I slightly adjusted the variable
	// names for my own understanding and commented out the code.

	public int[] quickSort(int arr[]) {
		quickSortHelper(arr, 0, arr.length - 1);
		return arr;
	}

	// a method to partition the array using the pivot element
	private static int partition(int arr[], int low, int high) {

		// select rightmost element as pivot
		int pivot = arr[high];

		// pointer to larger element
		int i = (low - 1);

		// traverse through all elements
		// compare each element with pivot
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {

				// if an element smaller than the pivot is found
				// replace it with a larger element marked with i
				i++;

				// replace the element at i with the element at j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

		}

		// replace the pivot element with the larger element specified by i
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		// returns the position from which the partition was made
		return (i + 1);
	}

	private static void quickSortHelper(int arr[], int low, int high) {
		if (low < high) {

			// find the split point by recursively calling methods on the two halves of the
			// array
			int pi = partition(arr, low, high);

			// recursive call on the left of pivot
			quickSortHelper(arr, low, pi - 1);

			// recursive call on the right of pivot
			quickSortHelper(arr, pi + 1, high);
		}
	}

	// Counting Sort.
	// The code here is from programiz.com where I slightly adjusted the variable
	// names for my own understanding and commented out the code.

	public int[] countingSort(int arr[], int size) {
		int[] output = new int[size + 1];

		// find the largest element of the array
		int max = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		int[] count = new int[max + 1];

		// a counter array initialized with zeros
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		// store the count of each element
		for (int i = 0; i < size; i++) {
			count[arr[i]]++;
		}

		// stores the cumulative count of each array
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}

		// find the index of each element of the original array in the counter array and
		// put the elements in the output array
		for (int i = size - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}

		// Copy the sorted elements into the original array
		for (int i = 0; i < size; i++) {
			arr[i] = output[i];
		}
		return arr;
	}

}