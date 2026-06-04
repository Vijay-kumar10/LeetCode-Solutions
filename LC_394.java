import java.util.Stack;

public class LC_394 {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == ']') {

                sb.setLength(0); // <-- Added
                while(st.peek() != '[') {
                    sb.append(st.pop());
                }
                st.pop(); // remove '['

                int k = 0;
                int base = 1;
                while(!st.isEmpty() && Character.isDigit(st.peek())) {
                    k += (st.pop() - '0') * base;
                    base *= 10;
                }

                sb.reverse();
                String str = sb.toString(); // <-- Added
                //iterate k times and push all character from str into stack
                while(k > 0) {
                    for(char ch : str.toCharArray()) {
                        st.push(ch);
                    }
                    k--;
                }

            } else {
                st.push(curr);
            }
        }

        //empty the string to store the answer
        sb.setLength(0);
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
