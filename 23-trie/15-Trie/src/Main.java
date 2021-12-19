public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("word");
        trie.add("hello");
        trie.add("world");
        trie.add("Python");
        trie.add("Java");
        trie.add("JavaScript");
        trie.add("C++");

        boolean contain = trie.contains("word");
        System.out.println(contain);

        contain = trie.contains("hello");
        System.out.println(contain);

        contain = trie.contains("world");
        System.out.println(contain);

        contain = trie.contains("Python");
        System.out.println(contain);

        contain = trie.contains("Java");
        System.out.println(contain);

        contain = trie.contains("JavaScript");
        System.out.println(contain);

        contain = trie.contains("C++");
        System.out.println(contain);

        contain = trie.contains("Pandas");
        System.out.println(contain);


    }
}
