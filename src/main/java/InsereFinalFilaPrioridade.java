import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

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
		int maiorPrioridade = fila.get(0).getPrioridade();
		String elemento = fila.get(0).getElemento();
		for (Pair pair : fila) {
			if (pair.getPrioridade() > maiorPrioridade) {
				maiorPrioridade = pair.getPrioridade();
				elemento = pair.getElemento();
			}
		}

		return elemento;
	}

}
