
public class Transpose extends Cipher {
	
	//will reverse the word
	public String apply(String word){
        StringBuilder encoded = new StringBuilder(word);
        encoded.reverse();
        return encoded.toString();
    }
	
    public String encodeToken(String word){
        return apply(word);
    }

    public String decodeToken(String word){
        return apply(word);
    }
}
