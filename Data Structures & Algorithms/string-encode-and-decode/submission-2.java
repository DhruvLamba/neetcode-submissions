class Solution {
    public String encode(List<String> strs) {
        StringBuilder main=new StringBuilder();
        for(int i=0;i<strs.size();i++){
          main.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        return main.toString();
    }

    public List<String> decode(String str) {
        List<String> res= new ArrayList<>();
        int i=0,j=0;
        while(i<str.length()){
            j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String main=str.substring(j+1,j+len+1);
            res.add(main);
            i=j+len+1;
            j=i+1;
        }
        return res;
    }
}
