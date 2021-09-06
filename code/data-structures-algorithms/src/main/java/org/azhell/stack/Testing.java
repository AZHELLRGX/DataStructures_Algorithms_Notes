package org.azhell.stack;

public class Testing {

    public static void main(String[] args) {
        testingStack();
    }

    public static void testingStack(){
        ArrayStack<String> arrayStack = new ArrayStack<>(3);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        System.out.println(arrayStack.isFull());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isEmpty());
        arrayStack.push("D");
        arrayStack.push("E");
        System.out.println(arrayStack.isFull());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isEmpty());
    }

}
