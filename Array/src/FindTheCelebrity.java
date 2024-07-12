public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int survivor = 0;
        for(int i = 1; i < n; i++){
            if(knows(survivor, i)) survivor = i;
        }
        for(int p = 0; p < n; p++){
            if(p != survivor){
                if(knows(survivor, p) || !knows(p, survivor)){
                    return -1;
                }
            }
        }
        return survivor;
    }

    //test double implementation
    public boolean knows(int a, int b){
        return true;
    }
}
