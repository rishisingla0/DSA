class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<num.length(); i++) {
            while(!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            } 
            stack.push(num.charAt(i));
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(char i : stack) {
            sb.append(i);
        }

        int i=0;
        while(i<sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        String result = sb.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}