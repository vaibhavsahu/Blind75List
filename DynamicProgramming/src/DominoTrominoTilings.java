public class DominoTrominoTilings {
    public int numTilings(int n) {

        if(n== 1) return 1;
        if(n==2) return 2;

        int MOD = 1_000_000_007;
        long [] ftable = new long[n+1];

        ftable[1] = 1L;
        ftable[2] = 2L;
        ftable[3] = 5L;

        for(int i = 4; i <= n; i++){
            ftable[i] = (2*ftable[i-1]+ftable[i-3]) % MOD;
        }

        return (int)(ftable[n] % MOD);
    }
}
