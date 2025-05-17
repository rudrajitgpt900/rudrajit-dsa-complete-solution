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
    Node next;

    Node(T data){
        this.data = data;
        this.next= null;
    }
}
public class CustomLinkedList {
    private Node head;

    CustomLinkedList(int head){
        this.head = new Node(head);
    }

    //always add it in last
    public void addNode(Object data){
        Node newNode = new Node(data);
        //if your list is empty or not
        if(head==null){
            this.head = newNode;
        }else{
           Node current = head;
           while(current.next!=null){
               current = current.next; //40
           }
          current.next = newNode;

        }

    }

    public void removeNode(Object nodeToDelete){
        //Node nextRef = node.next; //30
        Node current = head;
        Node prev = null;
        while(current!=null){
            if(current.data.equals(nodeToDelete)){
                if(prev!=null){
                    prev.next = current.next;//shifting the link
                    break;
                }
                else{
                    this.head = current.next;
                    break;
                }


            }
            else{
                prev = current;
                current = current.next;
            }
        }
    }

    public void printList(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }


    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.printList();
       // list.removeNode(20);
        list.removeNode(50);
        System.out.println("After removal");
        list.printList();
        System.out.println("Adding string");
        list.addNode("rudra");
        list.printList();
    }
}

/*
* Employee tqble
* you have duplicate records
* emp name age and salary id
*
*
* from employee emp
*
*
* */
