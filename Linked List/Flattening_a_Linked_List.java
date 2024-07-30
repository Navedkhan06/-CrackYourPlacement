class Solution {
    // Function to flatten a linked list
Node flatten(Node root)
    {
      if(root.next==null || root==null){
          return root;
      }
      
     Node mg=flatten(root.next);
      
      return merge(root,mg);
      
      
     }
     
     public static Node merge(Node root1,Node root2){
         
         Node dummy=new Node(-1);
         Node res=dummy;
         
         while(root1!=null && root2!=null){
             
         if(root1.data<root2.data){
             res.bottom=root1;
             res=root1;
             root1=root1.bottom;
         }
         else{
             res.bottom=root2;
             res=root2;
             root2=root2.bottom;
         }
     }
     
      if(root1!=null){
         res.bottom=root1;
     }
     
     if(root2!=null){
         res.bottom=root2;
     }
     
     return dummy.bottom;
     
  }
}