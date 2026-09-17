class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        Stack<Character> st=new Stack<>();
        HashMap<Character,Character> ht=new HashMap<>();
        ht.put('}', '{');
        ht.put(']', '[');
        ht.put(')', '(');
        for(char t:s.toCharArray()){
            if(ht.containsKey(t)){
                if(!st.isEmpty() && st.peek()==ht.get(t)){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                st.push(t);
            }
        }
        return st.isEmpty();
    }
}

