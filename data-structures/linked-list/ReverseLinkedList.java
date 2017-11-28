class ReverseLinkedList {

  private final class Node {
    public Node next;
    public int data;
  }

  private final Node reverse(Node head) {

    Node current = head;
    Node prev = null;
    Node next;


    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
    return head;
  }

  private void printLinkedList( Node head){

    Node current = head;

    while(current != null){
      System.out.println(current.data);
      current = current.next;
    }
  }


  public void doWork() {

    Node n1 = new Node();
    Node n2 = new Node();
    Node n3 = new Node();
    Node n4 = new Node();

    n1.data = 1;
    n1.next = n2;
    n2.data = 2;
    n2.next = n3;
    n3.data = 3;
    n3.next = n4;
    n4.data = 4;

    System.out.println("Normal");
    this.printLinkedList(n1);
    Node reversedLinkedList = this.reverse(n1);
    System.out.println("Reversed");
    this.printLinkedList(reversedLinkedList);
  }


  public static void main(String[] args) {

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    reverseLinkedList.doWork();

  }
}
