public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int repeat = 0;
        if (A >= G || E >= C || F >= D || B >= H) repeat = 0;
        else {
            int w1 = Math.max(A, E), w2 = Math.min(C, G);
            int h1 = Math.max(B, F), h2 = Math.min(D, H);
            repeat = (w2 - w1) * (h2 - h1);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - repeat;
    }
}