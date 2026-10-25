package rudy.playground.pg1;
/*
* LRU-Cache
*
* cache will have capacity
* it should have put(key , val)
* it should get(key)
* eviction if the capacity is full then evict out the least recently used
*
*
* ex:
* capacity : 5
* [1, 1],
* [2,2]
* [2,3]
* [3,3]
* 4,4
* 5,5
* get(1)-ok
* get(3)-ok
*
*
*
* [6,6]
* */

import java.util.HashMap;
import java.util.Map;

/*
* head(-1,-1) ->tail(-1,-1)
* */
class NodeData{
    public int key;
    public int val;
    NodeData next;
    NodeData prev;
    long timeOfInsertion;

    NodeData(int key , int val){
        this.key = key;
        this.val = val;
        this.next=null;
        this.prev =null;
        this.timeOfInsertion = System.currentTimeMillis();

    }
}

public class LRU_CACHE {

    int capacity;
    Map<Integer, NodeData>map;
    NodeData head;
    NodeData tail;

    LRU_CACHE(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new NodeData(-1,-1);
        tail = new NodeData(-1,-1);
        head.next = tail;
        tail.prev = head;
        //monitor();
    }

    public synchronized void put(int key, int val){
        if(this.map.containsKey(key)){
            NodeData existingNode = this.map.get(key); //Node
            existingNode.val = val;
            remove(existingNode);
            insert(existingNode);
        }else{
            if(map.size()==capacity){
                NodeData leastRecentlyNode = this.tail.prev;
                map.remove(leastRecentlyNode.key);
                remove(leastRecentlyNode);
            }
        }
        NodeData newNode = new NodeData(key ,val);
        map.put(key ,newNode);
        insert(newNode);
    }
    public synchronized int get(int key){
        if(this.map.containsKey(key)){
            NodeData existingNode = this.map.get(key);
            int ans = existingNode.val;
            remove(existingNode);
            insert(existingNode);
            return ans;
        }
        return -9999;
    }
    public void cleanUpCache(){
        for(Map.Entry<Integer,NodeData>entry: map.entrySet()){
            var key= entry.getKey();
            var val = entry.getValue();
            if(System.currentTimeMillis() - val.timeOfInsertion >=5){
                this.map.remove(key);
                remove(val);
            }
        }
    }

    public void monitor(){
        while (true){
            cleanUpCache();
        }
    }

    // head-> 10->20->30->tail
    public void remove(NodeData currentNode){
        NodeData prev = currentNode.prev; //10
        NodeData next = currentNode.next; //30
        prev.next =next;
        next.prev = prev;
    }
    //// head-> 10->20->30->tail
    public void insert(NodeData currentNode){
        NodeData temp = this.head.next; //10
        this.head.next = currentNode;
        currentNode.prev = this.head;
        currentNode.next = temp;
        temp.prev = currentNode;

    }
    public static void main(String[] args) {

        LRU_CACHE cache = new LRU_CACHE(5);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        cache.put(4,40);
        cache.put(5,50);

        System.out.println(cache.get(1)); //10
        System.out.println(cache.get(2)); //20;

        cache.put(6,60);
        System.out.println(cache.get(6));//60;
        System.out.println(cache.get(3));


    }
}


/*
* 1,10
* 2,20
* 3,30
* 4,40
*
* 4,40 ->3,30 ->2,20->1,10
*
* get(1)
* 1,10->4,40 ->3,30 ->2,20->
* get(2)
*
* 2,20->1,10->4,40 ->3,30 ->
*
* put(5,50)
*
* */