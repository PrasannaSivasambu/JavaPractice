
class Solution {
    public boolean isMatch(String s, String p) {

        if (!p.contains("*") && p.contains("?") && (s.length() != p.length()))
            return false;
        if (!p.contains("*") && !p.contains("?") && (s.length() != p.length()))
            return false;
        if (s.equals(p)) {
            return true;
        }
            System.out.println("hello");
        boolean b = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {

                if(p.substring(i + 1)=="") return true;
                if (p.substring(i + 1) == s.substring(i + 1)) {
                    return true;
                } else {
                    System.out.println("hello");
                    return false;
                }
            }

            if (p.charAt(i) == '?') {
                continue;
            }
            if (s.charAt(i)!=p.charAt(i)) {
                return false;
            }

        }
        return true;
    }
}

public class WildcardMatching {

    public static void main(String[] args) {

    }

}
