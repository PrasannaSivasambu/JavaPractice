 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
public class AddTwoNumsListNode {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode ln=l1;
        StringBuffer val=new StringBuffer();
        while (ln!=null) {
          val.append(Integer.toString(ln.val));
          ln=ln.next;
        }
        ln=l2;
        System.out.println("val1 "+val);


        StringBuffer valu=new StringBuffer();
        while (ln!=null) {
            valu.append(Integer.toString(ln.val));
            ln=ln.next;
          }
          System.out.println("val2 "+valu);
        
        int total= Integer.parseInt(val.toString())+Integer.parseInt(valu.toString()); 
        StringBuffer strb = new StringBuffer(Integer.toString(total)).reverse();
        int result=Integer.parseInt(strb.toString());
        System.out.println("total "+total);
        String h= Integer.toString(total); 
        boolean b=true;
        ListNode m1=null,j=null,k=null;
       
        while (result>0) {
            int value=result%10;
            System.out.println(value);
            if (b) {
                m1= new ListNode(value);
                j=m1;
                result/=10;
                b=false;
                continue;
            }
           m1= new ListNode(value,j);
            j=m1;
            result/=10;     
        }
        return j;

        
    }
    public static void main(String[] args) {
        ListNode l1= new ListNode(3);
        ListNode l2= new ListNode(4,l1);
        ListNode l3= new ListNode(2,l2);

        ListNode n1= new ListNode(4);
        ListNode n2= new ListNode(6,n1);
        ListNode n3= new ListNode(5,n2);


       ListNode o=addTwoNumbers(l3,n3);
       System.out.println(o.val+" "+o.next.val+" "+o.next.next.val+" ");

    }
    
}
