package rudy.dsa.DesignDS;

import java.util.HashMap;
import java.util.Map;

class Node {
    int value;
    int key;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
public class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            int ans = existingNode.value;
            remove(existingNode);
            insert(existingNode);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            existingNode.value = value;
            remove(existingNode);
            insert(existingNode);
        } else {
            if (map.size() == capacity) {
                Node leastRecentlyUsed = tail.prev;
                map.remove(leastRecentlyUsed.key);
                remove(leastRecentlyUsed);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insert(node);
        }
    }

    public void insert(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

}