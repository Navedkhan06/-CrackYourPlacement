class Solution {
    public boolean isPalindrome(ListNode head) {
       List<Integer> list=new ArrayList<Integer>();
        while(head!=null){
           list.add(head.val);
           head=head.next;
        }
        int n=list.size();
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)!=list.get(n-1-i)){
               return false;
            }
        }
        return true;
    }
}