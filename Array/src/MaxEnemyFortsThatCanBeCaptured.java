public class MaxEnemyFortsThatCanBeCaptured {
    //https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured

    public int captureForts(int[] forts) {
        int max = 0;
        int index = -1;

        for(int i = 0; i < forts.length; i++) {
            if(forts[i] != 0) {
                if(index != -1 && forts[i] != forts[index]) {
                    max = Math.max(max, i - index - 1);
                }
                index = i;
            }
        }
        return max;
    }
}
