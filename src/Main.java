import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Huffman h = new Huffman();
		h.read("myText.txt");
		h.displayQ(h.addToPriority());
		
		h.display(h.createHuffmanTree(h.changeNumTo0(h.addToPriority())), "");

		
		
//		System.out.println(h.search('a'));

	}

}
