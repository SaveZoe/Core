import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] array = getArray();
        int minVal = getMinVal(array);
        int maxVal = getMaxVal(array);
        int avgVal = getAvgVal(array);
        System.out.println("minVal: " + minVal + " maxVal: " + maxVal + " avgVal: " + avgVal);
    }

    private static int getAvgVal(int[][] array) {
        int avgVal = 0;
        int count = 0;
        for (int[] exArray : array) {
            for (int inArray : exArray) {
                avgVal += inArray;
                count++;
            }
        }
        return avgVal / count;
    }

    private static int getMaxVal(int[][] array) {
        int maxVal = array[0][0];
        for (int[] exArray : array) {
            for (int inArray : exArray) {
                if (maxVal < inArray) maxVal = inArray;
            }
        }
        return maxVal;
    }

    private static int getMinVal(int[][] array) {
        int minVal = array[0][0];
        for (int[] exArray : array) {
            for (int inArray : exArray) {
                if (minVal > inArray) minVal = inArray;
            }
        }
        return minVal;
    }

    private static int[][] getArray() {
        int[][] array = new int[5][5];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = rand.nextInt(101);
            }
        }
        return array;
    }


}
