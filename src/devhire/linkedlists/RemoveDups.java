package devhire.linkedlists;

public class RemoveDups {
	/**
	 * 	Remove nós duplicados.
	 * @param list Lista a ser operada
	 */
	public static void Remove(LinkedList<Integer> list) {
		Node<Integer> fixado = list.head;
		while(fixado !=null && fixado.next != null) {
			var comparar = fixado;
			while(comparar !=null && comparar.next != null) {
				if (comparar.next.data == fixado.data) {
					comparar.next = comparar.next.next; 
				}
				comparar = comparar.next;
			}
			fixado = fixado.next;
		}
	}	
}
