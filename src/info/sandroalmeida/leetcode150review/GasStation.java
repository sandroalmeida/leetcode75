package info.sandroalmeida.leetcode150review;

/* Leetcode 134 */
public class GasStation {

  public static void main(String[] args) {
    int[] gas = new int[]{3,3,4};
    int[] cost = new int[]{3,4,4};
    System.out.println(canCompleteCircuit(gas, cost));
  }

  //Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
  //Output: 3
  //Explanation:
  //Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
  //Travel to station 4. Your tank = 4 - 1 + 5 = 8
  //Travel to station 0. Your tank = 8 - 2 + 1 = 7
  //Travel to station 1. Your tank = 7 - 3 + 2 = 6
  //Travel to station 2. Your tank = 6 - 4 + 3 = 5
  //Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
  //Therefore, return 3 as the starting index.
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    for(int i = 0; i < gas.length; i++) {
      if(checkForIdx(gas, cost, i)) {
        return i;
      }
    }
    return -1;
  }

  private static boolean checkForIdx(int[] gas, int[] cost, int start) {
    boolean next = true;
    int currentGas = 0;
    int current = start;
    while(next) {
      int calcGas = currentGas + gas[current] - cost[current];
      if(calcGas >= 0) {
        if(current < gas.length - 1)
          current++;
        else
          current = 0;
        currentGas = calcGas;
      } else {
        next = false;
      }
      if(current == start) break;
    }
    return next;
  }
}
