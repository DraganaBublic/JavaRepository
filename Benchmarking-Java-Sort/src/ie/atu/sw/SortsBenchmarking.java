package ie.atu.sw;

import java.util.*;

public class SortsBenchmarking {

	public static double benchmarking(String[] algorithms, int[] sizes, int reps) {
		double total = 0;
		Algorithms algo = new Algorithms();
		for (String sort_algo : algorithms) {
			for (int size : sizes) {
				// run reps times for each size for each sort type
				for (int run = 0; run < reps; run++) {
					// generate random arrays
					int[] array = new int[size];
					for (int i = 0; i < size; i++) {
						array[i] = (int) (Math.random() * 100);
					}
					// create a copy of the array
					int[] cloned = new int[array.length];
					System.arraycopy(array, 0, cloned, 0, array.length);

					// benchmark the algorithms
					long startTime = System.nanoTime();

					switch (sort_algo) {
					case "BubbleSort":
						algo.bubbleSort(cloned);
						break;
					case "InsertionSort":
						algo.insertionSort(cloned);
						break;
					case "SelectionSort":
						algo.selectionSort(cloned);
						break;
					case "QuickSort":
						algo.quickSort(cloned);
						break;
					case "CountingSort":
						algo.countingSort(cloned, cloned.length);
						break;
					default:
						break;
					}

					long endTime = System.nanoTime();
					long timeElapsed = endTime - startTime;
					// convert from nanoseconds to milliseconds
					double elapsedMillis = timeElapsed / 1000000.0;
					total += elapsedMillis;
				}
			}
		}
		return total;
	}

	// Driver method.
	public static void main(String[] args) {
		String[] algorithms = { "BubbleSort", "InsertionSort", "SelectionSort", "QuickSort", "CountingSort" };
		// specifying sizes for arrays to be sorted
		int sizes[] = { 100, 500, 1000, 1500, 2000, 2500, 5000, 10000 };
		SortsBenchmarking bench = new SortsBenchmarking();
		benchmarking(algorithms, sizes, 10);

		Formatter fmt = new Formatter();
		// format the output and display table
		fmt.format("%-15s", "Sizes");
		for (int s = 0; s < sizes.length; s++) {
			fmt.format("%-11s", sizes[s]);
		}
		System.out.println(fmt);
		for (int i = 0; i < algorithms.length; i++) {
			fmt = new Formatter();
			fmt.format("%-15s", algorithms[i]);
			for (int j = 0; j < sizes.length; j++) {

				double runTime = 0.0;
				double trialSize = 10.0;

				for (int k = 0; k < trialSize; k++) {
					try {
						runTime = benchmarking(algorithms, sizes, k);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("An error occurred while benchmarking the algorithms: " + e.getMessage());
					}
				}
				// calculating the average of 10 runs
				double average = runTime / trialSize;
				// the output formatted to 3 decimal places
				fmt.format("%-11s", (String.format("%.3f", average)));
			}
			System.out.println(fmt);

		}
	}
}