import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


class A{
    void printingA(){
        System.out.println("A");
    }
}
class B extends A{
    @Override
    void printingA() {
        super.printingA();
    }

    void printingB(){
        System.out.println("B");
    }
}

class C extends B {
    @Override
    void printingA() {
        super.printingA();
    }

    @Override
    void printingB() {
        System.out.println("B");
    }

    void printingC(){
        System.out.println("C");
    }
}

 class Animal { }
 class Dog extends Animal { }
 class Cat extends Animal { }

 class TextDownloader implements Runnable {

    @Override
    public void run() {
        // Download text from server
        System.out.println("I am downloading the file containing text to a directory");
        //,-3,5,3,6,7

//        try {
//            Thread.sleep(2000); // for simulating download wait time
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
public class Main {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 3, -1));
        System.out.println(set.last());
      // CombinationSum2.combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27);
//
//        CompletableFuture.runAsync( () -> {
//            // Download text from server
//            System.out.println("I am downloading the file containing text to a directory");
//            System.out.println("runAsync Thread: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000); // for simulating download wait time
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).thenRunAsync( () -> {
//            System.out.println("I am processing the downloaded file");
//            System.out.println("thenRunAsync Thread: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(2000); // for simulating download wait time
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).join();





    }

//        List<A> aList = List.of(new A());
//        List<B> bList = List.of(new B());
//        List<C> cList = List.of(new C());
//        print(Collections.singletonList(bList));

//        List<?>           l1 = new ArrayList<>();
//        List<? extends Animal> l2 = new ArrayList<>();
//        List<? super   Animal> l3 = new ArrayList<>();
//
//        List<? super Animal> l = new ArrayList<>();
//        l.add(new Animal());
//        l.add(new Dog());
//        l.add(new Cat());
//        for(Object obj : l){
//            System.out.println(obj);
//        }



    public static void print(List< ? super B> list){
//        A a = new A();
//        B b = new B();
//        C c = new C();
//        //  list.stream().forEach( it -> it.printingA());
////        list.add(a);
//        list.add(b);
//  //      list.add(c);
//        list.stream().forEach(System.out::println);
    }


    public static int shortestArrayWithSumAtLeastK(int [] arr, int k){
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                if(sum >= k){
                    minCount = Math.min(j-i+1, minCount);
                    break;
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    public static List<Integer> slidingWindowMaximum(int [] P, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < P.length; i++) {
            if(i < k){
                while (!dq.isEmpty() && P[dq.peekLast()] <= P[i]) {
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            if(i+1 == k){
                result.add(P[dq.peekFirst()]);
            }
            if( i >= k){
                while (!dq.isEmpty() && P[dq.peekLast()] <= P[i]){
                    dq.removeLast();
                }
                while (!dq.isEmpty() && dq.peekFirst()  == i-k) {
                    dq.removeFirst();
                }
                dq.addLast(i);
                result.add(P[dq.peekFirst()]);
            }
        }
        return result;
    }

    public static List<Integer> slidingWindowFirstNegative(int [] P, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < P.length; i++) {
            if(i < k){
                while (!dq.isEmpty() && P[dq.peekLast()] >= 0) {
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            if(i+1 == k){
                result.add(Math.min(P[dq.peekFirst()], 0));
            }
            if( i >= k){
                while (!dq.isEmpty() && P[dq.peekLast()] >= 0){
                    dq.removeLast();
                }
                while (!dq.isEmpty() && dq.peekFirst()  == i-k) {
                    dq.removeFirst();
                }
                dq.addLast(i);
                result.add(Math.min(P[dq.peekFirst()], 0));
            }
        }
        return result;
    }
}