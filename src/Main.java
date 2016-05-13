import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Huffman h = new Huffman();
		h.addToPriority(h.read("myText.txt"));
		h.display(h.createHuffmanTree(), "");
		
		
//		System.out.println(h.search('a'));

	}

}
