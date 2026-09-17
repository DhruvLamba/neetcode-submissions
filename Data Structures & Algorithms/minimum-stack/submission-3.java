class MinStack {
    int ptr=-1;
    int[] data=new int[10];
    public MinStack() {
            
    }
    
    public void push(int val) {
        if(ptr==data.length-1){
            int[] temp=new int[data.length*2];
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        ptr=ptr+1;
        data[ptr]=val;
    }
    
    public void pop() {
        ptr=ptr-1;
    }
    
    public int top() {
        return data[ptr];
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ptr+1;i++){
            if(data[i]<min){
                min=data[i];
            }
        }
        return min;
    }
}
