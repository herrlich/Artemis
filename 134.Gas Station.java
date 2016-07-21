public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) return (gas[0] >= cost[0]) ? 0 : -1;
        int p1 = 0, p2 = 0, count = 0;
        int res = 0;
        while (p1 < gas.length) {
            while (count < gas.length) {
                if (res >= 0) {
                    res += (gas[p2] - cost[p2]);
                    p2 = (p2 + 1) % gas.length;
                    ++count;
                }
                else break;
            }
            if (res >= 0 && count == gas.length) return p1;
            while (p1 < gas.length && res < 0) {
                res -= (gas[p1] - cost[p1]);
                ++p1;
                --count;
            }
        }
        return -1;
    }
}
 