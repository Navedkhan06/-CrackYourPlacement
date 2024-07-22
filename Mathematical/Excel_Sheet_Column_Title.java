class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) return "";
        columnNumber--;
        char c = (char) ('A' + columnNumber % 26);
        return convertToTitle(columnNumber / 26) + c;
    }
}