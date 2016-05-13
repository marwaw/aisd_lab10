import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Huffman {
	ArrayList<Node> nodes;
	
	
	public Huffman(){
		nodes = new ArrayList<>();
	}
	
	public void read(String fileName) throws FileNotFoundException{
		Scanner fileScanner = new Scanner(new FileReader(fileName));
		
		while(fileScanner.hasNextLine()){
			String s = fileScanner.nextLine();
			for (int i=0; i<s.length(); i++){
				System.out.println("Dodajê: " + s.charAt(i));
				insert(s.charAt(i));
			}
		}
		fileScanner.close();
		
		System.out.println(nodes);
	}
	
	private Node search(char c){
		int i = 0;
		while(i < nodes.size() && nodes.get(i).getSym() != c){
			i++;
		}
		return i != nodes.size()? nodes.get(i): null;
	}
	
	private void insert(char c){
//		if (c == ' ') c = '_';
		if (search(c) != null){
			System.out.println("ten znak wystepuje " + c);
			search(c).addFreq();
		}
		else{
			System.out.println("tworze nowy wezele " + c);
			nodes.add(new Node(1, c));
		}
	}
	
	public PriorityQueue<Node> addToPriority(){
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for (int i=0; i < nodes.size(); i++){
//			System.out.println("Po " + i + "dodaniu");
			Node n = nodes.get(i);
			n.setNum(i);
			queue.add(n);
//			System.out.println("--------------------");
		}
		return queue;
	}
	
	public Node createHuffmanTree(PriorityQueue<Node> q){
		int i = 1;
		while (q.size() > 1){
			Node temp1 = q.poll();
			Node temp2 = q.poll();
			int sum = temp1.sum() + temp2.sum();
			Node temp = new Node(sum, temp1, temp2);
			temp.setNum(i);
			q.add(temp);
			System.out.println("Po dodaniu");
			q = displayQ(q);
			System.out.println("--------------------");
			i++;
		}
		return q.poll();
	}
	
//	public void decode(Node n, char k){
//		StringBuffer code = new StringBuffer();
//		if(n != null){
//			if (k =='l') code.append("0");
//			else if (k == 'r') code.append("1");
//			decode(n.left, 'l');
//			decode(n.right, 'r');
//			if (n.left == null && n.right == null){
//				System.out.println(n.toString()+ "kod: "+ code);
//			}
//		}
//	}

	public void display(Node n, String b){
		if (n.left == null){
			System.out.println(n.toString()+ "kod: "+b);
		}
		else{
		display(n.left, b+"0");
		display(n.right, b+"1");
		}
	}
	
	public PriorityQueue<Node> displayQ(PriorityQueue<Node> q){
		PriorityQueue<Node> queue = new PriorityQueue<>();
		while (!q.isEmpty()){
			Node temp = q.poll();
			System.out.println(temp.toString());
			queue.add(temp);
		}
		return queue;
	}
	
	public PriorityQueue<Node> changeNumTo0(PriorityQueue<Node> q){
		Iterator<Node> it = q.iterator();
		while(it.hasNext()){
			it.next().toZero();
		}
		return q;
	}
	
	
//	public static Comparator<Node> freqComparator = new Comparator<Node>(){
//		@Override
//		public int compare(Node arg0, Node arg1) {
//			int com = 0;
//			if (arg0.getFreq() > arg1.getFreq()) com = 1;
//			else if (arg0.getFreq() < arg1.getFreq()) com = -1;
//			else com = 0;
//			return com;
//		}
//	};

}
