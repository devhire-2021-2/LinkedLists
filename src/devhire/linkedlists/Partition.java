package devhire.linkedlists;

public class Partition {
	/**
	 * Particiona lista. 
	 * @param list Lista a ser particionado.
	 * @param x    Valor de partição.
	 */
	public static void part(LinkedList<Integer> list, int x) {
		var menores = new LinkedList<Integer>();
		Node<Integer> caudaMenores = null;
		var node = list.head;
		list.head= null; 
		while(node != null){			
			var next = node.next;
			if(node.data < x) {
				if(caudaMenores == null) {
					caudaMenores = node;
				}
				node.next = menores.head;
				menores.head = node;
			}else {
				node.next = list.head;
				list.head = node;
			}
			node = next;			 
		}
		caudaMenores.next = list.head;
		list.head = menores.head;		
	}
	/*public static void part(LinkedList<Integer> list, int x) {
		var node = list.head;
		while (node.next != null) {
			var comp = node;
			while(comp != null && comp.data < x) {
				node.next = comp.next.next;
				list.appendNodeHead(comp.next);
				comp = node;
			}
			node = node.next; 
		}
	} */
}
