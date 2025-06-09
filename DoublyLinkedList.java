public class DoublyLinkedList<E> {

    static class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;
        
        Node(E data, Node<E> next, Node<E> prev){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
        Node(E data){
            this.data=data;
        }
        Node(){

        }
    }
    Node<E> head;
    Node<E> tail;

    DoublyLinkedList(){

    }

    public void add(E element){
        Node<E> node = new Node<E>(element);
        if(this.head==null){
           this.head=node;
           this.tail=node;
            return;
        }

        this.tail.next=node;
        node.prev=this.tail;
        this.tail=node;
    }

    public boolean remove(E element){
        Node<E> e=head;

        while (e!=null) {
            if(e.data==element){
               if (e.prev != null) {
                e.prev.next = e.next;
            } else {
                // Removing the head
                head = e.next;
            }

            if (e.next != null) {
                e.next.prev = e.prev;
            } else {
                // Removing the tail
                tail = e.prev;
            }
               e.next=null;
               e.prev=null;
               return true; 
            }
            e=e.next;
        }
        return false;
    }
    public static void main(String[] args) {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    dll.add(10);
    dll.add(20);
    dll.add(30);
    dll.add(40);

    // dll.displayForward();   // 10 <-> 20 <-> 30 <-> 40 <-> null

    System.out.println( dll.remove(10));         // Remove head
    dll.remove(40);         // Remove tail
    dll.remove(30);         // Remove middle

     

    // dll.displayForward();   // 20 <-> null
}
}
