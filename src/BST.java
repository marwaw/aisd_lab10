
public class BST {
	BSTNode root;
	
	public BST(){}
	
	public void insert(char s, String code){
		root = insert (root, s, code);
	}
	
	protected BSTNode insert(BSTNode t, char s, String code){
		if( t == null){
			t = new BSTNode(s, code);
		}
		else{
			int com = ((Character)s).compareTo((Character)t.symbol);
			if ( com < 0){
				t.left = insert(t.left, s, code);
			}
			else if ( com > 0 ){
				t.right = insert(t.right, s, code);
			}
		}
		return t;
	}
	
	public BSTNode search (char s){
		return search(s, root);
	}
	
	public BSTNode search(char s, BSTNode t){
		if (t == null || ((Character)t.symbol).compareTo((Character)s) == 0){
			return t;
		}
		if (((Character)s).compareTo((Character)t.symbol) < 0){
			return search(s, t.left);
		}
		return search(s, t.right);
	}
	
	public void inOrder(BSTNode node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.toString());
			inOrder(node.right);
		}
	}

}
