import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

	public static int[] sort(int[] sourceArray) {
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		return arr;
	}
}
