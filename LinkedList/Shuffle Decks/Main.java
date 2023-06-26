
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int key){
        data = key;
        next = null;
    }
}

class Main{
    static Node head;
    static Node temp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head = null;
		temp = null;
		addToTheLast(a1);
		
		for(int i = 1; i < n; i++){
			int data = sc.nextInt();
			addToTheLast(data);
		}
        sc.close();
		Solution ans = new Solution();
		Node node = ans.shuffleDeck(head);
		printList(node);
		System.out.println();
    }
    
    public static void addToTheLast(int data){
        if(head == null){
			head = new Node(data);
			temp =head;
			return ;
		}
		else{
			Node new_node = new Node(data);
			temp.next = new_node;
			temp=temp.next;
			return;		
		}
    }
    
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Solution{

	// private static int size(Node node)
	// {
	// 	int l  = 0;
	// 	while(node != null)
	// 	{
	// 		l++;
	// 		node = node.next;
	// 	}
	// 	return l;
	// }
	private static Node reverse(Node node)
	{
		Node curr = node;
		Node prev = null;
		while(curr != null)
		{
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
    public Node shuffleDeck(Node node){
       //your code here.
		
		Node dummy = new Node(-1);
		Node d = dummy;

		Node slow = node;
		Node fast = slow.next;
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		Node x = node;
		Node y = slow.next;
		slow.next = null;
		Node rev = reverse(y);

		while(x != null || rev != null)
		{
			if(x != null)
			{
				d.next = x;
				d = d.next;
				x = x.next;
			}
			if(rev != null)
			{
				d.next = rev;
				d = d.next;
				rev = rev.next;
			}
		}

		return dummy.next;
    }
}









