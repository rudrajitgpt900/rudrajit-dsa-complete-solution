package rudy.dsa.LinkedList;


class Node{
    String url;
    Node next;
    Node prev;

    Node(String url){
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}
public class BrowserHistory {

    public Node current;
    public BrowserHistory(String homepage) {
        this.current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        this.current.next = newNode;
        newNode.prev = current;
        this.current = newNode;
    }

    public String back(int steps) {
        while (steps !=0){
            if(this.current.prev!=null){
                this.current = this.current.prev;
            }
            else {
                break;
            }
            steps--;
        }
        return this.current.url;
    }

    public String forward(int steps) {
        while (steps !=0){
            if(this.current.next!=null){
                this.current = this.current.next;
            }
            else {
                break;
            }
            steps--;
        }
        return this.current.url;
    }


    public static void main(String[] args) {

        //[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
        //["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedIn.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));



    }
}
