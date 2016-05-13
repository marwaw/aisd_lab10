public class PriorityQueue {
	int size;
	Element head;
	
	public PriorityQueue(){
		clear();
	}
	
	public void clear(){
		size = 0;
		head = new Element(null);
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void insert(Node val){
		if ( size == 0){
			head.setNext(new Element(val));
		}
		else{
			Element temp = head.getNext();
			if (temp.value.compareTo(val) >= 0){
				Element e = new Element(val, temp);
				head.setNext(e);
			}
			else{
				while (temp.hasNext() && (temp.next.value).compareTo(val) <= 0){
					temp = temp.getNext();
				}
				Element e = new Element(val, temp.next);
				temp.setNext(e);
			}
		}
		size++;
	}
	
	public Node poll(){
		Element e = head.getNext();
		head.setNext(e.getNext());
		size--;
		return e.value;
	}
	
	public Element get(int ind){
		Element e = head.getNext();
		for (int i = 0; i < ind; i++){
			e = e.getNext();
		}
		return e;
	}
	
	public void display(){
		for (int i = 0; i < size; i++){
			System.out.println(get(i).value.toString());
		}
	}

}
