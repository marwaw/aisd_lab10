public class Node implements Comparable<Node>{
	private int value;
	private char symbol;
	Node left;
	Node right;
//	int num;
	
	public Node(int v, char s){
		value = v;
		symbol = s;
//		num = 0;
	}
	
	public Node(int v, Node l, Node r){
		value = v;
		left = l;
		right = r;
	}
	
//	public void setNum(int n){
//		num = n;
//	}
//	
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
		return "Znak: " + symbol + " waga: " + value /*+ " numer porz¹dkowy " + num*/;
	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		int com = ((Integer)value).compareTo((Integer)arg0.sum());
//		if ( com == 0) return ((Integer)num).compareTo((Integer)arg0.num) ;
		return com;
//		int com;
//		if (this.value < arg0.sum()) com = -1;
//		else if ( com = 1;
//		return com;
		
	}

}
