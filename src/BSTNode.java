public class BSTNode {
	char symbol;
	String code;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(char s){
		symbol = s;
	}
	
	public BSTNode(char s, String c){
		symbol = s;
		code = c;
	}
	
	public BSTNode(char s, String c, BSTNode left){
		symbol = s;
		code = c;
		this.left = left;
	}
	
	public BSTNode(char s, String c, BSTNode right, BSTNode left){
		symbol = s;
		code = c;
		this.left = left;
		this.right = right;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public String toString(){
		return "Symbol: " + symbol + " kod: " + code;
	}

}
