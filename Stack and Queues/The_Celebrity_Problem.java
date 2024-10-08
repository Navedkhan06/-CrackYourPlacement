class Solution {
    
    //Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][])
    {
    	int n = mat.length;
    	int can = 0;
    	
    	for(int i = 1 ; i < n ;i++){
    	    if(knows(can , i , mat)){
    	        can = i;
    	    }
    	}
    	
    	if(isCeleb(can , mat)){
    	    return can;
    	}
    	
    	return -1;
    }
    
    boolean knows(int a , int b , int mat[][]){
        
        return mat[a][b] == 1;
    }
    
    boolean isCeleb(int can , int mat[][]){
        
        int n = mat.length;
        
        for(int i = 0 ; i < n ; i++){
            
            if(i != can && (knows(can , i , mat) || !knows(i , can , mat))){
                return false;
            }
        }
        return true;
    }
    
    
}