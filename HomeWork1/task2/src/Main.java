import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 6, 3, 2, 5, 1, 4, 9};
        int[] sortedArray = getSortedArray(unsortedArray);
        assert Arrays.equals(sortedArray, new int[]{1, 2, 3, 4, 5, 5, 6, 9});
        assert Arrays.equals(sortedArray, new int[]{5, 6, 3, 2, 5, 1, 4, 9});
    }

    private static int[] getSortedArray(int[] unsortedArray) {
        if (unsortedArray.length <= 1) return unsortedArray;
        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = 0; j < unsortedArray.length; j++) {
                if (unsortedArray[i] < unsortedArray[j]) {
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }
            }
        }
        return unsortedArray;
    }
}