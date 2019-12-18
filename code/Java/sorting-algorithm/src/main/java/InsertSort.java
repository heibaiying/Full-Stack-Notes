import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

	public static int[] sort(int[] sourceArray) {
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		for (int i = 0; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > tmp) {
				arr[j] = arr[j - 1];
				j--;
			}
			if (i != j) {
				arr[j] = tmp;
			}
		}
		return arr;
	}
}
