import java.util.Stack;

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        
        // Agar minSt khaali hai ya current val ab tak ke minimum se chota/barabar hai
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }
    
    public void pop() {
        // Agar main stack se hatne wala element hi minimum hai, toh use minSt se bhi hatayein
        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}