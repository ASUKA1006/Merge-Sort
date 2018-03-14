import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

	// randomly select numbers to array
	public static int[] SetArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}

		return array;
	}

	public void size(int[] array) {
		if (array.length == 1) {
			System.out.println("The array has only one element");
		} else if (array.length == 0) {
			System.out.println("nothing");
		}
	}

	public static int[] MergeSort(int[] array) {
		if (array.length == 1) {
			return array;
		} else {

			int[] result = new int[array.length];
			int midIndex = array.length / 2;
			int[] left = new int[midIndex];

			// scope
			int[] right;
			// array.length = even or odd
			//if array is odd and divided by two, right array has (left +1)
			if (array.length % 2 == 0) {
				right = new int[midIndex];
			} else {
				right = new int[midIndex + 1];
			}

			// initialize each array
			for (int i = 0; i < midIndex; i++) {
				left[i] = array[i];
			}
			for (int a = 0, j = midIndex; j < array.length; j++, a++) {
				right[a] = array[j];
			}
			
			//to make sure my code is correct or not
			System.out.println("Merge process: ");
			System.out.println(Arrays.toString(left));
			System.out.println(Arrays.toString(right));

			// recursion
			left = MergeSort(left);
			right = MergeSort(right);
			
			//initialize
			int leftIndex = 0;
			int rightIndex = 0;
			int resultIndex = 0;
			
			//Merge part
			//comparing two numbers in right side and left side
			while (resultIndex != result.length) {
				if (leftIndex != left.length && rightIndex != right.length) {

					if (left[leftIndex] < right[rightIndex]) {
						result[resultIndex] = left[leftIndex];
						resultIndex++;
						leftIndex++;

					} else if (left[leftIndex] > right[rightIndex]) {
						result[resultIndex] = right[rightIndex];
						resultIndex++;
						rightIndex++;

					} else if (left[leftIndex] == right[rightIndex]) {
						result[resultIndex] = left[leftIndex];
						resultIndex++;
						result[resultIndex] = right[rightIndex];
						resultIndex++;
						leftIndex++;
						rightIndex++;

					}
				} else if (leftIndex < left.length) {
					result[resultIndex] = left[leftIndex];
					resultIndex++;
					leftIndex++;

				} else if (rightIndex < right.length) {
					result[resultIndex] = right[rightIndex];
					resultIndex++;
					rightIndex++;

				}
			}
			System.out.println("Result: " + Arrays.toString(result));
			return result;
		}
	}

	public static void main(String[] args) {
		int array[] = new int[10];

		SetArray(array);
		System.out.println("Before: " + Arrays.toString(array));

		int[] result = MergeSort(array);

		System.out.println("After: " + Arrays.toString(result));

	}
}
