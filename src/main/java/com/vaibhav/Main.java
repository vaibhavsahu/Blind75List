package com.vaibhav;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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

public class Main {
    public static void main(String[] args) {
//        List<A> aList = List.of(new A());
//        List<B> bList = List.of(new B());
//        List<C> cList = List.of(new C());
//        print(Collections.singletonList(bList));

    }

    public static void print(List< ? super A> list){
        A a = new A();
        B b = new B();
        C c = new C();
      //  list.stream().forEach( it -> it.printingA());
        list.add(a);
        list.add(b);
        list.add(c);
        list.stream().forEach(System.out::println);
    }
}