import java.util.ArrayList;


public class Solution {

	/*	Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	 */

	/* class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
*/
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		
		// Write your code here
        QueueUsingLL<BinaryTreeNode<Integer>> q=new QueueUsingLL<>();
        q.enqueue(root);
        q.enqueue(null);
        Node<BinaryTreeNode<Integer>> head=null;
        Node<BinaryTreeNode<Integer>> tail=null;
         Node<BinaryTreeNode<Integer>> temp=null;
         ArrayList<Node<BinaryTreeNode<Integer>>> output=new ArrayList<>();
        while(q.size()!=1){
            try{
            BinaryTreeNode<Integer> current=q.dequeue(); 
            if(current!=null){
               // Node<BinaryTreeNode<Integer> n=new Node<Integer>(current.data);
                if(current.left!=null)
                q.enqueue(current.left);
                if(current.right!=null)
                q.enqueue(current.right);
                temp=new Node<BinaryTreeNode<Integer>>(current);
               // q.enqueue(null);
            if(head==null){
                head=temp;
                    tail=temp;
            }
                else{
                    tail.next=temp;
                    tail=tail.next;
                }
            }
            if(current==null){
               output.add(head);
                head=null;
                    tail=null;
                q.enqueue(null);
                continue;
            }
        
        //q.enqueue(null);
        
            }catch(QueueEmptyException e){
                
            }
        
        }
        output.add(head);
        return output;
	}


}
