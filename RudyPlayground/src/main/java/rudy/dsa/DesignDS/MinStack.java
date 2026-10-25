package rudy.dsa.DesignDS;

class Data{
    int val;
    int min;
    Data next;
    Data prev;

    Data(int val, int min){
        this.val=val;
        this.min= min;

        this.prev=null;
        this.next=null;
    }
}
public class MinStack {

    int min;
    Data head;
    Data tail;
    public MinStack() {
        this.min= Integer.MAX_VALUE;
        this.head = new Data(-1, min);
        this.tail = new Data(-1,min);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }


    public void push(int val) {
      //  Data node = new Data(val, this.min);
        if(this.head.next == this.tail){
            min = val;
            Data node = new Data(val,min);
            add(node);
            return;
        }
        min = Math.min(val, this.head.next.min);//-2, -3
        Data node = new Data(val, min);
        add(node);
    }

    //(-3,-3),(0,-2),(-2,-2);
    //min = -3
    public void pop() {
        remove(this.head.next);
        //min = this.head.next.min;
    }

    public int top() {
       return this.head.next.val;
    }

    public int getMin() {
        return this.head.next.min;
    }

    public void add(Data node){
        Data next = this.head.next;// -1 ->20->-1
        node.next= next;
        next.prev=node;
        node.prev=this.head;
        this.head.next=node;

    }
    public void remove(Data node){
        //-1->10->20->-1

        Data next= node.next; //20
        this.head.next= next;
        next.prev = this.head;
        node.next=null;
        node.prev=null;

    }
}
