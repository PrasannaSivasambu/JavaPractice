public class MinimumWindowSubstring {

    public static void main(String[] args) {
        
        String s = "ADOBECODEBANC", t = "ABC",resultString="";

        int i=0,j=t.length()-1;
        StringBuilder strb = new StringBuilder();
        
        // s.contains(Character.toString(t.charAt(0)));
        while(j<s.length()){

            if(t.chars().mapToObj(Character::toString).allMatch(e->s.substring(i,j+1).contains(e))){

                if (resultString.length()>s.substring(i,j+1).length()) {
                    resultString=s.substring(i,j+1);
                }
                i=j+1;
                      
            }

            j++;

        }
    }
    
}
