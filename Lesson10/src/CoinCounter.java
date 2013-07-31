import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class CoinCounter {
    public static int CHANGE_NOT_POSSIBLE_FLAG = Integer.MAX_VALUE;
    private int[] denominations;

    private CoinCounter() {
        super();
    }

    /**
     * Creates a new instance with the desired coin denominations. All future calculations will use
     * these coin denominations.
     *
     * @param denominations Integer value coin denominations. They do not have to be sorted, but all must be > 0.
     *                      This is copied and stored locally.
     */
    public CoinCounter(int[] denominations) {
        this.denominations = Arrays.copyOf(denominations, denominations.length);
        Arrays.sort(this.denominations);
    }

    public int findBiggestCoin(int[] denominations, int value) {
        int r = 0;
        for (int i = denominations.length -1; i >= 0; i-- ) {
            if (value >= denominations[i]) {
                r = denominations[i] ;
                break;
            }
        }
        return r;
    }

    /**
     * Returns the number of coins required to make change for a given value.
     *
     * Greedy algorithm solution.
     *
     * @param totalSum The total value in coins that must be made change for.
     * @return The total number of coins that are needed to make change for totalSum.
     */

    public int simpleNumberOfCoinsRequired(int totalSum) {
        /*
            To calculate the number of coins required to give change in
            most sane coin denominations, a simple 'greedy' algorithm
            is sufficient.

            Imagine you need to give change for 42 cents in America.
            First you would take a quarter; you'll  need 17 more cents for change.
            Second you take a dime; you'll need 7 more cents for change.
            Third you take a nickle; you'll need 2 more cents for change.
            Fourth you take a penny; you'll need 1 more cent for change.
            Fifth you take another penny; you're all done making change, and you needed 5 coins.

            For most currency denominations, we can generalize the rule for giving change:
                * When giving change, always take the largest value coin that's less than the
                change you need to give (e.g. if you need 42, take a quarter. If you have 8, take a nickle).
                * Subtract that amount from the total amount of change you need to give.
                * Repeat.

            Assignment: Implement this algorithm below and make testSimpleNumberOfCoinsRequired pass.
        */

<<<<<<< HEAD
        int counter = 0;
        while (totalSum > 0) {
            totalSum = totalSum - findBiggestCoin(denominations, totalSum);
            counter ++;
        }
        //throw new NotImplementedException();
        return counter;
=======
        throw new NotImplementedException();

        int count = 0;
        int denominationIndex = this.denominations.length - 1;
        while (totalSum > 0) {
            if (this.denominations[denominationIndex] <= totalSum) {
                count += Math.floor(totalSum/this.denominations[denominationIndex]);
                totalSum %= this.denominations[denominationIndex];
            } else {
                denominationIndex--;

                if (denominationIndex < 0)
                    break;
            }
        }

        return totalSum == 0 ? count : CHANGE_NOT_POSSIBLE_FLAG;
>>>>>>> upstream/master
    }

    /**
     * Returns the number of coins required to make change for a given value.
     *
     * Memoized algorithm solution.
     *
     * @param totalSum The total value in coins that must be made change for.
     * @return The total number of coins that are needed to make change for totalSum.
     */
    public int numberOfCoinsRequired(int totalSum) {
        /*
            While our simpleNumberOfCoinsRequired works for most
            sane currency denominations, it does not work for all currencies.
            Consider a currency with the denominations 1, 5, 7 and 20.
            Our previous algorithm would say that 3 coins were needed to make
            change for 10, when in fact 2 is the actual solution (2 coins of value 5).

            We must take a different approach to solve for this. Instead of a 'greedy'
            algorithm, we will use memoization.

            Our algorithm must do the following:
                * For each possible value, from 1 to totalSum
                 * If that value is a coin denomination, it's required count is 1
                 * If not, examine that value minus all possible denominations
                    * e.g. If the value was 8, you would look at the number of coins
                      required for 8 - 7, 8 - 5 and 8 - 1.
                 * Take the smallest of those values, plus one
                 * Repeat
                * Return the calculated value for totalSum

            First assignment: Make testNumberOfCoinsRequired pass
            Second assignment: Make testWonderlandDenominations pass
            Third assignment: Make testTerribleDenominations pass
         */

<<<<<<< HEAD
        int[] numberOfCoinsRequiredAtValue = new int[totalSum + 1];
        if (totalSum == 0){
            return 0;
        }
        for (int i = 1; i <= totalSum; i++) {
            if (inDenominations(denominations,i) ) {
                numberOfCoinsRequiredAtValue[i] = 1;
            }
            else {
                // for each coin that is less than i
                // look at it's array[i] and pick the smallest
                int max = CHANGE_NOT_POSSIBLE_FLAG - 1;
                for (int d : denominations) {
                    if (d < i ) {
                        if (numberOfCoinsRequiredAtValue[i - d] < max ) {
                            max = numberOfCoinsRequiredAtValue[i - d];
                        }
                    }
                }
                numberOfCoinsRequiredAtValue[i] = max + 1;
            }
        }

        return numberOfCoinsRequiredAtValue[totalSum];
    }
    public boolean inDenominations(int[]denominations, int value) {
        for (int d : denominations) {
            if (d == value){
            return true;
            }
        }
        return false;
=======
        throw new NotImplementedException();

        // Instructor sample soln: Remove before giving to students:
        // Speed, O(m * n), m = totalSum, n = number of coins
        int[] numberOfCoinsRequiredAtValue = new int[totalSum + 1];

        for (int i = 1; i < numberOfCoinsRequiredAtValue.length; i++) {
            int minimumPreviousValue = CHANGE_NOT_POSSIBLE_FLAG;
            for (int coinValue : this.denominations) {
                if (coinValue == i) {
                    minimumPreviousValue = 1;
                    break;
                } else if (coinValue < totalSum && i - coinValue > 0) {
                    int value = numberOfCoinsRequiredAtValue[i - coinValue];
                    if (value != CHANGE_NOT_POSSIBLE_FLAG)
                        minimumPreviousValue = Math.min(minimumPreviousValue, value + 1);
                } else
                    break;
            }
            numberOfCoinsRequiredAtValue[i] = minimumPreviousValue;
        }

        return numberOfCoinsRequiredAtValue[totalSum];
>>>>>>> upstream/master
    }


}
