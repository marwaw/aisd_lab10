
public class Element {
	Element next;
	Node value;
	
	public Element(Node val){
		value = val;
		next = null;
	}
	
	public Element(Node val, Element next){
		value = val;
		this.next = next;
	}
	
	public void setNext(Element elem){
		next = elem;
	}
	
	public boolean hasNext(){
		return next != null;
	}
	
	public Element getNext(){
		return next;
	}

}
