public class FOX_dots{
	public static void main(String[] args){

		//prints the F
		for (int i = 5; i > 0;i--){
			for (int j = 1; j <= i; j++){
				System.out.printf("*");
			}
			System.out.println("");
		}

		//prints the O
		for (int i = 5; i > 0;i--){
			if(i == 5 || i == 1){
				System.out.println("*****");
			} else {
				System.out.println("*   *");
			}
		}

		//prints the X
		for (int i = 5; i > 0;i--){
			if(i % 5 == 0){
				System.out.println("*****");
			} else if (i % 2 == 0) {
				System.out.println(" *** ");
			} else if (i % 3 == 0) {
				System.out.println(" **   ");
			} else if (i == 1) {
				System.out.println("*****");
			}
		}
	}

}
