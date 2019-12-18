import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

	public static int[] sort(int[] sourceArray) {
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
		return arr;
	}
}
