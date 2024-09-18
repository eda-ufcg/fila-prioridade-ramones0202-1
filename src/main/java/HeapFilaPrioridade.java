public class HeapFilaPrioridade implements FilaPrioridade {

	public static void main(String[] args) {
        HeapFilaPrioridade heap = new HeapFilaPrioridade(3);


        heap.add("a",1);
        heap.add("b",2);
		heap.add( "c",3);
        heap.add("d",4);
		heap.add("e",5);
		
        System.out.println(heap.removeNext());
        System.out.println(heap.removeNext());
    }

	private Heap heap;

	public HeapFilaPrioridade(int capacidade) {
		this.heap = new Heap(capacidade);
	}

	// adicionar o pair no heap
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);
		heap.add(newPair);
	}

	// recuperar a raiz
	public String removeNext() {
		return heap.remove().getElemento();
	}

}