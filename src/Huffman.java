import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
	PriorityQueue nodes;
	
	
	public Huffman(){
		nodes = new PriorityQueue();
	}
	
	public ArrayList<Node> read(String fileName) throws FileNotFoundException{
		ArrayList<Node> nodes = new ArrayList<>();
		Scanner fileScanner = new Scanner(new FileReader(fileName));
		
		while(fileScanner.hasNextLine()){
			String s = fileScanner.nextLine();
			for (int i=0; i<s.length(); i++){
				System.out.println("Dodajê: " + s.charAt(i));
				insert(s.charAt(i), nodes);
			}
		}
		fileScanner.close();
		
		System.out.println(nodes);
		return nodes;
	}
	
	private Node search(char c, ArrayList<Node> arr){
		int i = 0;
		while(i < arr.size() && arr.get(i).getSym() != c){
			i++;
		}
		return i != arr.size()? arr.get(i): null;
	}
	
	private void insert(char c, ArrayList<Node> arr){
		if (search(c, arr) != null){
			System.out.println("ten znak wystepuje " + c);
			search(c, arr).addFreq();
		}
		else{
			System.out.println("tworze nowy wezele " + c);
			arr.add(new Node(1, c));
		}
	}
	
	public void addToPriority(ArrayList<Node> arr){
		for (int i=0; i < arr.size(); i++){
//			System.out.println("Po " + i + "dodaniu");
			Node n = arr.get(i);
			nodes.insert(n);
//			System.out.println("--------------------");
		}
		nodes.display();
	}
	
	public Node createHuffmanTree(){
		while (nodes.size > 1){
			Node temp1 = nodes.poll();
			Node temp2 = nodes.poll();
			int sum = temp1.sum() + temp2.sum();
			Node temp = new Node(sum, temp1, temp2);
			nodes.insert(temp);
			System.out.println("Po dodaniu");
			nodes.display();
			System.out.println("--------------------");
		}
		return nodes.poll();
	}

	public void display(Node n, String b){
		if (n.left == null){
			System.out.println(n.toString()+ "kod: "+b);
		}
		else{
		display(n.left, b+"0");
		display(n.right, b+"1");
		}
	}
	
	//!!!!!
	public String codeText(){
		return null;
	}

}
