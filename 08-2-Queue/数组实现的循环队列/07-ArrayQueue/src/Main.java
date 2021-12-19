public class Main {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            //System.out.println(queue);
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//
//        }

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue);

        queue.dequeue();
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();


        System.out.println(queue);
    }
}


