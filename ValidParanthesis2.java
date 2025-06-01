public class ValidParanthesis2 {
    public boolean checkValidString(String s) {
    int low = 0;  // min possible '(' count
    int high = 0; // max possible '(' count

    for (char c : s.toCharArray()) {
        if (c == '(') {
            low++;
            high++;
        } else if (c == ')') {
            if (low > 0) low--;
            high--;
        } else if (c == '*') {
            // * can be '(', ')', or ''
            if (low > 0) low--; // treat * as ')'
            high++;             // treat * as '('
        }

        // Too many closing brackets
        if (high < 0) return false;
    }

    // If low == 0, it's a valid string
    return low == 0;
}

}
