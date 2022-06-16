public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int pairsFound = 0;
        char[] stack = new char[s.length()];
        int currentIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ')' || current == '}' || current == ']') {
                char popped;
                if (currentIndex - 1 < 0) {
                    return false;
                } else {
                    popped = stack[--currentIndex];
                }
                if (current == ')') {
                    if (popped != '(') {
                        return false;
                    }
                } else if (current == '}') {
                    if (popped != '{') {
                        return false;
                    }
                } else {
                    if (popped != '[') {
                        return false;
                    }
                }
                pairsFound++;
            } else {
                stack[currentIndex++] = current;
            }
        }
        return pairsFound == s.length() / 2;
    }


    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }
}
