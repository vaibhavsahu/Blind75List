import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpanner {

    Stack<int []> stack = new Stack<>();
    List<Integer> stocks = new ArrayList<>();

    public StockSpanner() {}

    public int next(int price) {
        int ans = 1;
        stocks.add(price);
        int i = stocks.size()-1;
            int j = i-1;
            if(j >= 0 && stocks.get(j) > stocks.get(i)) {
                return ans;
            }
            while(j >= 0 && stocks.get(j) <= stocks.get(i)) {
                ans++;
                j--;
            }
        return ans;
    }

    public int nextWithMonoStack(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans+=stack.pop()[1];
        }
        stack.push(new int[]{price,ans});
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.nextWithMonoStack(100));
        System.out.println(stockSpanner.nextWithMonoStack(80));
        System.out.println(stockSpanner.nextWithMonoStack(60));
        System.out.println(stockSpanner.nextWithMonoStack(70));
        System.out.println(stockSpanner.nextWithMonoStack(60));
        System.out.println(stockSpanner.nextWithMonoStack(75));
        System.out.println(stockSpanner.nextWithMonoStack(85));

    }
}