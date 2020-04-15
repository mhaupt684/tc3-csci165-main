public class Caeser extends Cipher{

    private final int SIZE   = 26;
    private final int ENCODE = 3;
    private final int DECODE = SIZE - ENCODE;

    public String apply(String word, int scale){
        StringBuilder encoded = new StringBuilder();
        for (int index = 0; index < word.length(); ++index) {
            char ch = word.charAt(index);
            ch = (char) ('a' + (ch - 'a' + scale) % 26);
            encoded.append(ch);
        }
        return encoded.toString();
    }
    public String encodeToken(String word){
        return apply(word, ENCODE);
    }

    public String decodeToken(String word){
        return apply(word, DECODE);
    }
}
