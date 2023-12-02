// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman
// Copyright 2017 Hussein Suleman, University of Cape Town

public class BinarySearchTree
{
   public void preOrder () {
      preOrder (root);
  }
  public void preOrder ( BinaryTreeNode node ) {
      if (node != null) {
          System.out.println (node.a.name);
          preOrder (node.getLeft ());
          preOrder (node.getRight ());
      }
  }

   BinaryTreeNode root = null;
   public void insert ( Account a )
   {
      if (root == null)
         root = new BinaryTreeNode (a, null, null);
      else
         insert (a, root);
   }
   public void insert ( Account a, BinaryTreeNode node )
   {
      if (a.toString().compareTo (node.a.name) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode (a, null, null);
         else
            insert (a, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode (a, null, null);
         else
            insert (a, node.right);
      }
   }
   
   public BinaryTreeNode find ( String a )
   {
      if (root == null)
         return null;
      else
         return find (a, root);
   }
   public BinaryTreeNode find ( String a, BinaryTreeNode node )
   {
      if (a.compareTo (node.a.name) == 0) 
         return node;
      else if (a.compareTo (node.a.name) < 0)
         return (node.left == null) ? null : find (a, node.left);
      else
         return (node.right == null) ? null : find (a, node.right);
   }
   
   public void delete ( String a )
   {
      root = delete (a, root);
   }   
   public BinaryTreeNode delete ( String a, BinaryTreeNode node )
   {
      if (node == null) return null;
      if (a.compareTo (node.a.name) < 0)
         node.left = delete (a, node.left);
      else if (a.compareTo (node.a.name) > 0)
         node.right = delete (a, node.right);
      else if (node.left != null && node.right != null )
      {
         node.a.name = findMin (node.right).a.toString();
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode removeMin ( BinaryTreeNode node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   public void insert(int i) {
   }
   public void inOrder() {
   }
public char[] find(int i) {
    return null;
}
public void delete(int i) {
}
   
}
