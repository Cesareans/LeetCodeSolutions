package usr.cesare.leetcode.p101to200.p146;

import javafx.util.Pair;

import java.util.HashMap;

public class LRUCache {
    class Node{
        Pair<Integer, Integer> pair;
        Node pre, post;

        public Node(Pair<Integer, Integer> pair, Node pre, Node post) {
            this.pair = pair;
            this.pre = pre;
            this.post = post;
        }
    }
    private HashMap<Integer, Node> map;
    private Node head, tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.post = tail;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        node.pre.post = node.post;
        node.post.pre = node.pre;
        head.post.pre = node;
        node.post = head.post;
        node.pre = head;
        head.post = node;
        return node.pair.getValue();
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            Node newNode = new Node(new Pair<>(key, value), head, head.post);
            newNode.post.pre = newNode;
            head.post = newNode;
            map.put(key, newNode);
            if(size < capacity){
                size++;
            }else{
                map.remove(tail.pre.pair.getKey());
                Node preTail = tail.pre.pre;
                preTail.post = tail;
                tail.pre = preTail;
            }
        }else{
            node.pair = new Pair<>(key, value);
            get(key);
        }
    }
}

class Main{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}