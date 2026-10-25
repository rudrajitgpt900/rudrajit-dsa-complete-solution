package rudy.playground.pg1;

/*
* Rough
* head->20->30->40->Null
*50
*
* 10->20->30->40->50->
*prev =null
* current = head //10
* */
class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next= null;
    }

}
public class CustomLinkedList<T> {
    private Node<T> head;

    CustomLinkedList(T head){
        this.head = new Node<>(head);
    }

    //always add it in last
    public void addNode(T data){
        Node<T> newNode = new Node<>(data);
        //if your list is empty or not
        if(head==null){
            this.head = newNode;
        }else{
           Node<T> current = head;
           while(current.next!=null){
               current = current.next; //40
           }
          current.next = newNode;

        }

    }

    public void removeNode(T nodeToDelete){
        //Node nextRef = node.next; //30
        Node<T> current = head;
        Node<T> prev = null;
        while(current!=null){
            if(current.data.equals(nodeToDelete)){
                if(prev!=null){
                    prev.next = current.next;//shifting the link
                }
                else{
                    this.head = current.next;
                }
                break;
            }
            prev = current;
            current = current.next;
        }
    }

    public void printList(){
        Node<T> current = head;
        while(current!=null){
            if(current.next!=null)
                 System.out.print(current.data + "->");
            else
                System.out.print(current.data );
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CustomLinkedList<Object> list = new CustomLinkedList<>(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.printList();
        list.removeNode(20);
        list.removeNode(50);
        System.out.println("After removal");
        list.printList();
        System.out.println("Adding string");
        list.addNode("Java");
        list.addNode(90.6);
        list.addNode("Programming");
        list.printList();
    }
}
