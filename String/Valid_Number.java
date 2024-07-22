class Solution {
    public boolean isNumber(String s) {
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean dotCheck = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numberSeen = true;
            } else if (ch == '+' || ch == '-') {
                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')){
                    return false;
                }
            } else if (ch == '.') {
                if (dotCheck || eSeen) {
                    return false;
                }
                dotCheck = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberSeen = false;
            } else {
                return false; 
            }
        }

        return numberSeen;
    }
}