package devhire.linkedlists;

import java.util.Scanner;

public class FloydAlgorithm {
	public static Node<?> detect(LinkedList<?> l){
		var fast = l.head;
		var slow = l.head;
		
		while(fast !=null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				break;
			}
		}	
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = l.head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	public static void main (String[] args) {
		int len = 0;
		int loop_i = 0;
		var l  = new LinkedList<Integer>();
		try (Scanner scn = new Scanner(System.in)){
			len = scn.nextInt();
			loop_i = scn.nextInt();
			var last = new Node<Integer>(len);
			l.head = last;
			for (int i = len-1; i > 0; i--) {
				var n = new Node<Integer>(i, l.head);
				l.head = n;
				if (i == loop_i) {
					//last.next = n;
				}
			}
		}
		System.out.print(l.head);
		var n = l.head.next;
		
		int charsUntilLoop = 1;
		int charsUntilEnd = 0;
		for (int i = 2; i <= len; i++) {
			System.out.print("->");
			System.out.print(n);
			if (i <= loop_i) {
				charsUntilLoop += 2 + ((int)Math.floor(Math.log10(i)) + 1);
			}
			if (i > loop_i) {
				charsUntilEnd += 2 + ((int)(Math.log10(i)) + 1);
			}
			n = n.next;
		}
		int loopdig = ((int)Math.floor(Math.log10(loop_i)) + 1);
		int lenddig = ((int)Math.floor(Math.log10(len)) + 1);
		System.out.println("\n"+" ".repeat(charsUntilLoop - loopdig) + "^" + " ".repeat(charsUntilEnd - lenddig) + "|");
		System.out.println(" ".repeat(charsUntilLoop - loopdig) + "⌎" + "-".repeat(charsUntilEnd - lenddig) + "⌏");
	
		System.out.println(detect(l));
	}	
	
}
