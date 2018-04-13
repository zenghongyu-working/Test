public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 0, 9, 5, 4 };
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void quickSort(int[] array, int begin, int end) {
		if (begin <= end) {
			int p = p1(array, begin, end);
			if (p < end)
				quickSort(array, p + 1, end);
			if (p > begin)
				quickSort(array, begin, p - 1);
		}
	}

	public static int p(int[] array, int begin, int end) {
		int p = (begin + end) / 2;
		swap(array, p, end);
		int small = begin - 1;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[end]) {
				small++;
				if (small != i)
					swap(array, small, i);
			}
		}
		small++;
		swap(array, small, end);
		return small;
	}
	
	public static int p1(int[] array, int begin, int end) {
		int temp = array[begin];
		int i = begin ,j = end;
		while (i < j) {
			while (i < j && array[j] >= temp) j--;
			array[i] = array[j];
			while (i < j && array[i] <= temp) i++;
			array[j] = array[i];
		}
		array[i] = temp;
		return i;
	}

	private static void swap(int[] array, int p, int end) {
		int temp = array[p];
		array[p] = array[end];
		array[end] = temp;
	}

}
