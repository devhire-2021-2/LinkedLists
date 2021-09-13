package devhire.linkedlists;

/**
 * Célula de lista simplesmente ligada. Deve ser usado com
 * {@link devhire.linkedlists.LinkedList}.
 * 
 * @author <a href='https://github.com/jowme/'>João Gabriel Josephik</a> *
 * @param <T> Tipo de dado a ser guardado.
 */
public class Node<T> {
	/**
	 * Referência para a próxima célula da lista.
	 */
	public Node<T> next;
	
	/**
	 * Valor da célula
	 */
	public T data;

	/**
	 * Cria célula com valor determinado.
	 * 
	 * @param d Valor da célula.
	 */
	public Node(T d) {
		data = d;
	}

	/**
	 * Cria célula com valor e referência determinados.
	 * 
	 * @param d Valor da célula.
	 * @param n Referência para a próxima célula.
	 */
	public Node(T d, Node<T> n) {
		this(d);
		next = n;
	}

	/**
	 * Retora a representação textual do valor.
	 */
	@Override
	public String toString() {
		return data.toString();
	}
}