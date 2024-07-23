class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> res=new ArrayList<>();
        for (String s:string_list){
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String str=new String(temp);
            if (!map.containsKey(str)){
                List<String> tempArr=new ArrayList<>();
                tempArr.add(s);
                map.put(str,tempArr);
            }
            else{
                 List<String> tempArr=map.get(str);
                 tempArr.add(s);
                 map.put(str,tempArr);

            }
            
       }
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            List<String> t1=entry.getValue();
            if (t1.size()!=0) res.add(t1);
        }
        return res;
    }
}

