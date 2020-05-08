
public class FlexibleCaeser extends Caeser {
	
	public FlexibleCaeser(int shift) {
		this.ENCODE = shift;
	}
	
	private final int SIZE   = 26;
    private int ENCODE = 0;
    private int DECODE = SIZE - ENCODE;

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
    	DECODE = SIZE - ENCODE;
        return apply(word, DECODE);
    }
	
}
