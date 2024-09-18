import java.util.ArrayList;
import java.util.Iterator;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	public static void main(String[] args) {
		InsereFinalFilaPrioridade insere = new InsereFinalFilaPrioridade(5);
		insere.add("a", 1);
		insere.add("b", 2);
		insere.add("c", 3);
		insere.add("d", 4);
		insere.add("e", 5);

		System.out.println(insere.removeNext());
		System.out.println(insere.removeNext());

	}

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);
		this.fila.add(newPair);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		Pair maiorPair = this.fila.get(0);
		for (Pair pair : fila) {
			if (pair.getPrioridade() > maiorPair.getPrioridade()) {
				maiorPair = pair;
			}
		}
		String ret = maiorPair.getElemento();
		fila.remove(maiorPair);
		return ret;
	}
}
