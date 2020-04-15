public class CipherDriver{

    public static void main(String[] args){
        String text = "here is some text to encrypt";
        String encrypt = "";
        String decrypt = "";

        Caeser c = new Caeser();
        Transpose t = new Transpose();
        MaskOfZoro m = new MaskOfZoro();
        FlexibleCaeser f = new FlexibleCaeser(5);

        Cipher[] ciphers = {c,t,m,f};
        for(Cipher cipher : ciphers){
            System.out.println("OG: " + text);
            encrypt = cipher.encryptText(text);
            System.out.println("ENC: " + encrypt + " by " + cipher.getClass());
            decrypt = cipher.decryptText(encrypt);
            System.out.println("DCR: " + decrypt);
            System.out.println("=================================");
        }
    }
}
