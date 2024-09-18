public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public static void main(String[] args) {
		InsereOrdenadoFilaPrioridade insere = new InsereOrdenadoFilaPrioridade(3);
		insere.add("a", 3);
		insere.add("b", 2);
		insere.add("c", 1);
		
		System.out.println(insere.removeNext());
		System.out.println(insere.removeNext());


	}
	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if (head == -1 && last == -1) {
			head += 1;
		}
		last = (last + 1) % this.fila.length;
		Pair newPair = new Pair(elemento, prioridade);
		fila[last] = newPair;

		int j = last;

		while(j > 0 && fila[j].getPrioridade() > fila[j - 1].getPrioridade()) {
			//swap(j, j - 1);
			Pair aux = fila[j];
			fila[j] = fila[j-1];
			fila[j-1] = aux;
			j--;
		}

	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		Pair aux = this.fila[head];
		head = (head + 1) % this.fila.length;
		return aux.getElemento();
	}

}
