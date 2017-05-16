package tree.test;

import java.util.Arrays;

import list.DoublyLinkedList;
import list.List;
import tree.LinkedTree;

public class LinkedTreeTest {

	public static void main(String[] args) {
		LinkedTree<String> tree = new LinkedTree<String>("A");
		
		//내부클래스라서 클래스명.내부클래스 로 접근
		LinkedTree.TreeNode<String> root = tree.getRoot();
		LinkedTree.TreeNode<String> nodeB = tree.insertLeft(root, "B");
		LinkedTree.TreeNode<String> nodeC = tree.insertRight(root, "C");
		
		LinkedTree.TreeNode<String> nodeD =tree.insertLeft(nodeB, "D");
		LinkedTree.TreeNode<String> nodeE =tree.insertRight(nodeB, "E");
		
		LinkedTree.TreeNode<String> nodeF =tree.insertLeft(nodeC, "F");
		LinkedTree.TreeNode<String> nodeG =tree.insertRight(nodeC, "G");
		
		//단말노드는 객체화 필요 없음
		tree.insertLeft(nodeD, "H");
		tree.insertRight(nodeD, "I");
		
		tree.insertLeft(nodeE, "J");
		
		tree.insertRight(nodeF, "K");
		
		tree.insertLeft(nodeG, "L");
		tree.insertRight(nodeG, "M");
		
		List<String> list = new DoublyLinkedList<String>();
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));
		
		list.removeAll();
		tree.traversalPreorder( list );
		System.out.println( Arrays.toString( list.toArray() ) );
		
		list.removeAll();
		tree.traversalInorder( list );
		System.out.println( Arrays.toString( list.toArray() ) );


	}

}
