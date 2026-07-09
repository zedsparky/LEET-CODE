


public class missingRepeated_2965 {
    /*
---------------------------------------------------------
BRUTE FORCE APPROACH

Idea:
1. Check every number from 1 to n².
2. For each number, scan the entire matrix.
3. Count how many times the current number appears.
4. If count == 2 → repeated number.
5. If count == 0 → missing number.
6. Return {repeated, missing}.

Time Complexity : O(n⁴)
Space Complexity: O(1)
---------------------------------------------------------
*/
    public static int[] bruteForce(int[][] grid) {
        int n = grid.length;
        int repeated = -1;
        int missing = -1;
        for (int i = 1; i <= n * n; i++) {

            int count = 0;
            for (int row = 0; row < grid.length; row++) {

                for (int col = 0; col < grid.length; col++) {
                    if (i == grid[row][col]) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                repeated = i;
            }
            if (count == 0) {
                missing = i;
            }
        }
        return new int[] { repeated, missing };
    }
/*
---------------------------------------------------------
FREQUENCY ARRAY APPROACH

Idea:
1. Create a frequency array of size (n² + 1).
2. Traverse the matrix only once.
3. Increase the frequency of every number.
4. Traverse the frequency array.
5. Frequency == 2 → repeated number.
6. Frequency == 0 → missing number.
7. Return {repeated, missing}.

Time Complexity : O(n²)
Space Complexity: O(n²)
---------------------------------------------------------
*/
    public static int[] frequencyArrayMethod(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];
        // counting frequency
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                freq[grid[row][col]]++;
            }
        }
        int repeated = -1;
        int missing = -1;
        for (int i = 1; i <= n*n; i++) {
            if (freq[i] == 2) {
                repeated = i;
            }
            if (freq[i] == 0) {
                missing = i;
            }
        }
        return new int[] { repeated, missing };
    }

/*
---------------------------------------------------------
MATHEMATICAL APPROACH

Idea:
1. Calculate Expected Sum of numbers (1 to n²).
2. Calculate Expected Square Sum.
3. Traverse the matrix once to find:
      - Actual Sum
      - Actual Square Sum
4. diff = ActualSum - ExpectedSum
        = Repeated - Missing

5. squareDiff = ActualSquareSum - ExpectedSquareSum
              = Repeated² - Missing²

6. Use:
      Repeated² - Missing²
    = (Repeated - Missing)(Repeated + Missing)

7. Find:
      sum = Repeated + Missing

8. Solve:
      Repeated = (diff + sum) / 2
      Missing  = Repeated - diff

9. Return {repeated, missing}.

Time Complexity : O(n²)
Space Complexity: O(1)
---------------------------------------------------------
*/
    public static int[] mathMethod(int grid[][]) {
        int n = grid.length;
        long N = (long) n * n;
        long expectedSum = N * (N + 1) / 2;
        long expectedSqSum = N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSqSum = 0;
        int repeated = -1;
        int missing = -1;
        for (int[] row : grid) {
            for (int num : row) {
                actualSqSum += (long) num * num;
                actualSum += num;

            }

        }
        long diff = actualSum - expectedSum;
        long sum = ((actualSqSum - expectedSqSum) / diff);

        repeated = (int) ((diff + sum) / 2);
        missing = (int) (repeated - diff);
        return new int[] { repeated, missing };

    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, }, { 2, 4, } };
        // brute force
        int[] ans = bruteForce(grid);
        System.out.println("Brute force approach");
        System.out.println("repeated = " + ans[0]);
        System.out.println("missing = " + ans[1]);
        System.out.println();

        // frequency array method
        int sol[] = frequencyArrayMethod(grid);
        System.out.println("frequency array method ");
        System.out.println("repeated = " + sol[0]);
        System.out.println("missing = " + sol[1]);
        System.out.println();

        // math method
        int math[] = mathMethod(grid);
        System.out.println("math method ");
        System.out.println("repeated = " + math[0]);
        System.out.println("missing = " + math[1]);
        System.out.println();
    }
}
 