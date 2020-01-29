public class HelloWorld2{
	public static void main(String[] args){
		System.out.printf("Hello");
		for (String s : args)
			System.out.printf(" "+ s);
		
		System.out.println(". Nice work processing the arguments!");
		
	}

}
