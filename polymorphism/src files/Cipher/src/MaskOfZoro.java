
public class MaskOfZoro extends Cipher {
	
	//will apply a bitwise XOR with 0xFF
	
	public String apply(String word){
        StringBuilder encoded = new StringBuilder();
        char[] charArray = word.toCharArray();
        byte byteXOR = (byte)0xFF; 
        
        for(char ch : charArray) {
        	int xor = ch^byteXOR;
        	char encodedChar = (char)xor;
        	encoded.append(encodedChar);
        }
        
        return encoded.toString();
    }
	
    public String encodeToken(String word){
        return apply(word);
    }

    public String decodeToken(String word){
        return apply(word);
    }
}
