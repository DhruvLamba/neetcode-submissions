class MinStack {
    int ptr = -1;
    int[] data = new int[10];
    int[] minTracker = new int[10]; // minTracker[i] = min of data[0..i]

    public void push(int val) {
        if (ptr == data.length - 1) {
            data = Arrays.copyOf(data, data.length * 2);
            minTracker = Arrays.copyOf(minTracker, minTracker.length * 2);
        }
        ptr++;
        data[ptr] = val;
        minTracker[ptr] = (ptr == 0) ? val : Math.min(val, minTracker[ptr - 1]);
    }

    public void pop() {
        ptr--;
    }

    public int top() {
        return data[ptr];
    }

    public int getMin() {
        return minTracker[ptr];
    }
}