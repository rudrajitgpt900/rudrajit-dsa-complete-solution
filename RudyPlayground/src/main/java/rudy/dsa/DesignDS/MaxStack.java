package rudy.dsa.DesignDS;
class DataMax{
    int val;
    int max;
    DataMax next;
    DataMax prev;

    DataMax(int val, int min){
        this.val=val;
        this.max = min;

        this.prev=null;
        this.next=null;
    }
}
public class MaxStack {

    int max;
    DataMax head;
    DataMax tail;
    int size;
    public MaxStack() {
        this.max = Integer.MIN_VALUE;
        this.head = new DataMax(-1, max);
        this.tail = new DataMax(-1, max);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        size=2;
    }


    public void push(int val) {
        //  Data node = new Data(val, this.min);
        if(this.head.next == this.tail){
            max = val;
            DataMax node = new DataMax(val, max);
            add(node);
            this.size++;
            return;
        }
        max = Math.max(val, this.head.next.max);//-2, -3
        DataMax node = new DataMax(val, max);
        add(node);
        this.size++;
    }
    public void pop() {
        if(this.head.next==this.tail)
            return;
        remove(this.head.next);
        this.size--;
    }

    public void popLast(){
        if(this.head.next==this.tail)
                return;
        removeLast(this.tail.prev);
        this.size--;
    }

    public int top() {
        return this.head.next.val;
    }

    public int getMax() {
        return this.head.next.max;
    }

    public int getSize(){
        return this.size-2;
    }

    public void print(){
        if(this.head.next==this.tail)
            return;
        var temp = this.head.next;
        while (temp!=tail){
            System.out.print(temp.val+"->");
            temp= temp.next;
        }
        System.out.println("NULL");
    }

    private void add(DataMax node){
        DataMax next = this.head.next;// -1 ->20->-1
        node.next= next;
        next.prev=node;
        node.prev=this.head;
        this.head.next=node;

    }
    private void remove(DataMax node){
        //-1->10->20->-1

        DataMax next= node.next; //20
        this.head.next= next;
        next.prev = this.head;


    }

    private void removeLast(DataMax node){

        //-1 ->10->20->-1
        var prev = node.prev;
        
        prev.next = this.tail;


    }
}
