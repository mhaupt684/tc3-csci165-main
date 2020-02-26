//Michael Haupt

public class Temperature_Driver{

	public static void main(String[] args) {
		
		Temperature temp1 = new Temperature();
		Temperature temp2 = new Temperature(Temperature.Scale.F);
		Temperature temp3 = new Temperature(Temperature.Scale.C, 100);
		Temperature temp4 = new Temperature(Temperature.Scale.C, 100.19f);
		
		//settings
		temp1.setScale(Temperature.Scale.C);
		temp1.setValue(100.19f);
		temp3.setBothScaleValue(Temperature.Scale.F, 212f);
		
		//getters
		System.out.println(temp3.getFahrenheit());
		System.out.println(temp2.getCelsius());
		
		//toString
		System.out.println(temp1.toString());
		System.out.println(temp2.toString());
		System.out.println(temp4.toString());
		
		//equals method
		System.out.println(temp2.equals(temp3));
		System.out.println(temp1.equals(temp4));
		
		//compareTo
		System.out.println(temp3.compareTo(temp4));
		System.out.println(temp1.compareTo(temp4));
		System.out.println(temp3.compareTo(temp2));
		
	}

}
