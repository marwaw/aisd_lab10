public class Node implements Comparable<Node>{
	private int value;
	private char symbol;
	Node left;
	Node right;
	
	public Node(int v, char s){
		value = v;
		symbol = s;
	}
	
	public Node(int v, Node l, Node r){
		value = v;
		left = l;
		right = r;
	}
	
	public void addFreq(){
		value++;
	}
	
	public char getSym(){
		return symbol;
	}
	
	public int sum(){
		return value;
	}
	
	public String toString(){
		return "Znak: " + symbol + " waga: " + value;
	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		int com = ((Integer)value).compareTo((Integer)arg0.sum());
		return com;
		
	}

}
