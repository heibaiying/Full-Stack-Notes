import java.util.Arrays;

public class ZTest {
	public static void main(String[] args) {
		int[] source = {1, 4, 2, 5, 3};
		int[] sort01 = BubbleSort.sort(source);
		int[] sort02 = SelectionSort.sort(source);
		int[] sort03 = InsertSort.sort(source);
		System.out.println(Arrays.toString(sort03));
	}
}
