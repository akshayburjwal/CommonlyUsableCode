package inter.prep.multithreading.parallel.programming;

public class ParallelMergeSort {
	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 5, 7, 6, 2, 3, 5, 8, 7 };
		System.out.println(input);
		mergeSort(input, 0, input.length);
		System.out.println(input);
	}

	private static void mergeSort(int[] input, Integer low, Integer high) {
		if (low < high) {
			Integer mid = (low + high) / 2;
			mergeSort(input, low, mid);
			mergeSort(input, mid + 1, high);
			merge(input, low, mid, high);
		}
	}

	private static void merge(int[] input, Integer low, Integer mid, Integer high) {
		int[] left = new int[mid - low];
		for (int i = 0; i < left.length; i++) {
			left[i] = input[low + i];
		}
		int[] right = new int[high - mid];
		for (int i = 0; i < right.length; i++) {
			right[i] = input[mid + i];
		}
		int rightI = 0;
		int leftI = 0;
		int inputCounter = low;
		while (left.length < leftI && right.length < rightI) {
			if (left[leftI] <= right[rightI]) {
				input[inputCounter] = left[leftI];
				leftI++;
			} else {
				input[inputCounter] = right[rightI];
				rightI++;
			}
			inputCounter++;
		}
		while (left.length > leftI) {
			input[inputCounter] = left[leftI];
		}
		while (right.length > rightI) {
			input[inputCounter] = right[rightI];
		}
	}
}
