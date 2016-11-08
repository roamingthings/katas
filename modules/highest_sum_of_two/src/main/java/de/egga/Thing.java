package de.egga;

/**
 * @author egga
 */
public class Thing {

    public static int smallestSum(int[] chain) {

        validateInput(chain);


        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int maxIndex = chain.length - 1;
        int minIndex = 1;
        for (int i = minIndex; i < maxIndex; i++) {
            int current = chain[i];
            if (current < smallest) {
                secondSmallest = smallest;
                smallest = current;
            } else if (i < secondSmallest) {
                secondSmallest = current;
            }
        }

        int sum = smallest + secondSmallest;
        validateResult(sum);

        return sum;
    }

    private static void validateResult(int sum) {
        if (sum < 0) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateInput(int[] chain) {
        if (tooFewElements(chain)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean tooFewElements(int[] chain) {
        return chain.length < 4;
    }
}
