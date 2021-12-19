public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        System.out.println(arrayStack);
        arrayStack.push(2);
        System.out.println(arrayStack);
        arrayStack.push(3);
        System.out.println(arrayStack);
        arrayStack.push(4);
        System.out.println(arrayStack);

        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
