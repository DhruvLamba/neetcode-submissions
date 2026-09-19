class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }
        Stack<Integer> st=new Stack<>();
        for(String t:tokens){
            switch(t){
                case "+": 
                    int a=st.pop();
                    int b=st.pop();
                    int ans=a+b;
                    st.push(ans);
                break;
                case "-": 
                    a=st.pop();
                    b=st.pop();
                    ans=b-a;
                    st.push(ans);
                break;
                case "*": 
                    a=st.pop();
                    b=st.pop();
                    ans=a*b;
                    st.push(ans);
                break;
                case "/": 
                    a=st.pop();
                    b=st.pop();
                    ans=b/a;
                    st.push(ans);
                break;
                default:
                    st.push(Integer.parseInt(t));
            }
        }
        return st.peek();
    }
}
