package devhire.linkedlists;
import java.util.Scanner;
/**
 * Implementação de lista simplesmente ligada.
 * @author <a href='https://github.com/jowme/'>João Gabriel Josephik</a> 
 *
 * @param <T> Tipo de dado a ser guardado.
 */
public class LinkedList<T>{
	
	/**
	 * Cria lista vazia.
	 */
	public LinkedList() {
		
	}
	/**
	 * Cria lista com cabeça definida.
	 * @param n Cabeça da lista.
	 */
	public LinkedList(Node<T> n) {
		head = n;
	}
	
	/**
	 *	Cabeça da lista
	 */
	public Node<T> head;	
	
	/**
	 * Percorre a lista até o índice i, e retorna a célula nesse índice.
	 * @param i Index of the node to be returned.
	 * @return Célula no index i.
	 */
	public Node<T> nodeAt(int i){
		Node<T> n = head;
		for (; i > 0 && n != null; i--) {
			n = n.next;
		}
		return n;
	}
	/**
	 * Percorre a lista até o final, e mede seu tamanho.
	 * @return Tamanho da lista.
	 */
	public int length() {
		Node<T> n = head;
		int ans = 0;
		while (n != null) {
			ans += 1;
			n = n.next;
		}
		return ans;
	}
	/**
	 * Adiciona nó na frente da lista, substituindo sua cabeça.
	 * @param n Célula a ser adicionada.
	 */
	public void appendNodeHead(Node<T> n) {
		n.next = n;
		head = n;
	}
	/**
	 * Cria célula com valor d e a adiciona na frente da lista, substituindo sua cabeça.
	 * @param d Valor da célula a ser adicionada.
	 */
	public void appendHead(T d){
		head = new Node<T>(d, head);
	}
	/**
	 * Remove a célula na frente da lista, substituindo sua cabeça.
	 * @return Retorna true se alguma célula foi removida. Senão, retorna false.
	 */
	public boolean removeHead(){
		if(head != null) {
			head = head.next;
			return true;
		}
		return false;
	}	
	/**
	 * Adiciona célula após n, modificando a lista como necessário para manter sua integridade.
	 * @param n Célula anterior à adicionado.
	 * @param d Valor da nova célula.
	 */
	public void appendAfter(Node<T> n, T d) {
		n.next = new Node<T>(d, n.next);
	}
	/**
	 * Adiciona célula no índice determinado.
	 * @param i	Índice da célula a ser adicionada
	 * @param d Valor da célula a ser adicionada.
	 */
	public void appendAtIndex(int i, T d) {		
		if(i < 1) {
			appendHead(d); 
			return;
		}
		Node<T> n = nodeAt(i - 1);
		if(n!= null)
			appendAfter(n, d);
	}
	/**
	 * Remove a célula após n, modificando a lista como necessário para manter sua integridade.
	 * @param n Célula anterior à removida.
	 */
	public void removeAfter(Node<T> n) {
		if(n.next != null)
			n.next = n.next.next;
	}
	/**
	 * Remove a célula no índice determinado.
	 * @param i Índice da célula a ser removida.
	 * @return Retorna true se alguma célula foi removida. Senão, retorna false.
	 */
	public boolean removeAtIndex(int i) {		
		if(i < 1) {
			removeHead();
			return true;
		}
		Node<T> n = nodeAt(i - 1);
		if(n== null)
			return false;
		removeAfter(n);
		return true;
	}
	/**
	 * Busca valor na lista, e, se encontrado, retorna a primeira célula que o contém.
	 * @param d	Valor a ser procurado.
	 * @return Primeira célula de valor d.
	 */
	public Node<T> search(T d) {
		Node<T> n = head;
		while (n != null && n.data != d) {
			n = n.next;
		} 
		return n;
	}
	/**
	 * Busca valor na lista, e, se encontrado, retorna o índice da primeira célula que o contém.
	 * @param d	Valor a ser procurado.
	 * @return Índice da primeira célula de valor d.
	 */
	public int searchIndex(T d) {
		Node<T> n = head;
		int i = 0;
		while (n != null && n.data != d) {
			n = n.next;
			i += 1;
		} 
		return n != null ? i : -1;
	}
	/**
	 * Busca valor na lista, e, se encontrado, remove primeira célula que o contém.
	 * @param d	Valor a ser procurado.
	 * @return Retorna true se alguma célula foi removida. Senão, retorna false.
	 */
	public boolean searchAndRemove(T d) {
		int index = searchIndex(d);
		if (index == -1) {
			return false;
		}
		removeAtIndex(index);
		return true;
	}
	/**
	 * Retorna representação textual dos itens da lista, separados por '->'.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		if(head != null) {
		sb.append(head.data);
			for (Node<T> n = head.next; n != null; n = n.next) {
				sb.append("->");
				sb.append(n.data);
			}
		}
		return sb.toString();
		
	}
	/**
	 * Console para teste da lista.
	 */
	public static void main(String[] args) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		System.out.print("> ");
		try(Scanner scn = new Scanner(System.in)){
			while(scn.hasNext()) {				
				String act = scn.next();
				switch (act) {
					case "I":{
						int index = scn.nextInt();
						int data = scn.nextInt();
						L.appendAtIndex(index, data);
						break;}
					case "R":{
						int index = scn.nextInt();						
						L.removeAtIndex(index);
						break;}
					case "A":{
						int data = scn.nextInt();
						L.appendHead(data);	
						break;
					}
					case "L":
						System.out.println(L.length());
						break;
					
					case "@":
						System.out.println(L.nodeAt(scn.nextInt()));
						break;	
						
					case "RD":
						RemoveDups.Remove(L);
						break;
						
					case "P":
						Partition.part(L, scn.nextInt());
						break;
								
				}	
				System.out.println(L);
				System.out.print("> ");
			}
			
		}
		
		
		
	}
}
