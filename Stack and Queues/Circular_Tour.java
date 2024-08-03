class Solution
{
    int tour(int petrol[], int distance[])
    {
 
    int ans = 0;
    int total = 0;
    int fuel = 0;
    for(int i=0; i< petrol.length; i++){
        fuel += petrol[i]-distance[i];
        if(fuel < 0){
            ans = i+1;
            fuel = 0;
        }
        total += petrol[i]-distance[i]; 
    }
    return total<0?-1:ans;
    }
}
