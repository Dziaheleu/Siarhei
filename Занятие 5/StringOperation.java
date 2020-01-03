public class StringOperation {

    public boolean isStartWith(String str, String startLetter) {
        return str.startsWith(startLetter);
    }

    public String sergeiReplace(String str) {
        return str.replace("Sergei", "SergeiMan");
    }

    public boolean nameCompareIgnoreCase(String str, String str1) {
        return str.equalsIgnoreCase(str1);
    }

    public String trimmer(String str) {
        return str.trim();
    }

    public char charByIndex(String str, int index) throws StringIndexOutOfBoundsException {
        if (index > str.length() - 1 || index < 0) {
            throw new StringIndexOutOfBoundsException("index out of bounds string length");
        }
        return str.charAt(index);
    }

    public String sergeiMan(String sergei_is_man) {
        return sergei_is_man;
    }
}