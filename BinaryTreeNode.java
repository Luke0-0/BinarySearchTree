// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
// Copyright 2017 Hussein Suleman, University of Cape Town

public class BinaryTreeNode
{
   Account a;
   BinaryTreeNode left;
   BinaryTreeNode right;
   
   public BinaryTreeNode (Account a, BinaryTreeNode l, BinaryTreeNode r )
   {
      this.a = a;
      left = l;
      right = r;
   }
   
   BinaryTreeNode getLeft () { return left; }
   BinaryTreeNode getRight () { return right; }
}
