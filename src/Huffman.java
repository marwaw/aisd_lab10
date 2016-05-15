import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
	PriorityQueue nodes;
	Node huffmanTree;
	BST symbolBook = new BST();
	
	
	public Huffman(String fileName) throws IOException{
		nodes = addToPriority(read(fileName));
		huffmanTree = createHuffmanTree();
		createSymbolBook(huffmanTree, "");
		codeText(fileName, "codedText.txt", symbolBook);
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
			symbolBook.insert(c, null);
		}
	}
	
	public PriorityQueue addToPriority(ArrayList<Node> arr){
		PriorityQueue queue = new PriorityQueue();
		for (int i=0; i < arr.size(); i++){
			Node n = arr.get(i);
			queue.insert(n);
		}
		return queue;
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

	public void createSymbolBook(Node n, String b){
		if (n.left == null){
			System.out.println(n.toString()+ "kod: "+b);
			symbolBook.search(n.getSym(), symbolBook.root).setCode(b);
		}
		else{
		createSymbolBook(n.left, b+"0");
		createSymbolBook(n.right, b+"1");
		}
	}
	
	public void codeText(String fileFrom, String fileTo, BST symbolBook) throws IOException{
		Scanner fileScanner = new Scanner(new FileReader(fileFrom));
		FileWriter writer = new FileWriter(fileTo);
		
		while(fileScanner.hasNextLine()){
			String s = fileScanner.nextLine();
			for (int i = 0; i < s.length(); i++){
				char c = s.charAt(i);
				writer.write(symbolBook.search(c).code);
			}
			writer.close();
		}
		fileScanner.close();
	}

}
