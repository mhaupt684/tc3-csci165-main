//Michael Haupt

public class Temperature {
	
	//class features
	public static enum Scale{C,F}; 											//Celsius or Fahrenheit scales
	public static final float PRECISION = 1;
	public static final int LARGER = 1;
	public static final int SMALLER = -1;
	public static final int EQUAL = 0;
	
	//instance features
	private float temperatureValue; 										//numeric value of temperature
	private Scale scale = Scale.F; 											//sets scale to Fahrenheit by default
	
	
	
	//constructors
	public Temperature(){} 													//no argument constructor
	public Temperature(Scale scale) { 										//constructor takes scale
		setScale(scale);
	}
	public Temperature(Scale scale, float tValue) { 						//constructor takes scale and value
		setScale(scale);
		setValue(tValue);
		
	}
	
	
	//Setters
	public void setValue(float value) { 									//set temperature value
		this.temperatureValue = roundDecimal(value);
	}
	public void setScale(Scale scale) { 									//set the scale, C or F
		this.scale = scale;
	}
	public void setBothScaleValue(Scale scale, float value) { 				//set both the scale and the value
		this.scale = scale;
		this.temperatureValue = roundDecimal(value);
	}
	
	
	//Getters
	public float getCelsius() { 											//get the temperature in Celsius
		if(scale == Scale.C) {
			return this.temperatureValue;
		} else {
			float degreesC = roundDecimal(5*(temperatureValue - 32)/9);
			return degreesC;
		}
	}
	public float getFahrenheit() { 											//get the temperature in Fahrenheit
		if(scale == Scale.F) {
			return this.temperatureValue;
		} else {
			float degreesF = roundDecimal((9*(temperatureValue)/5) + 32);
			return degreesF;
		}		
	}
	
	
	//take a floating point number and round it to one decimal place
	public float roundDecimal(float value) {
		int scaleUp = (int) Math.pow(10, PRECISION); 						//multiplier is 10^PRECISION
		return (float) Math.round(value * scaleUp) / scaleUp; 				//multiplier*value -> round -> divide back down to decimal
	}
	
	
	//is a given temperature instance equal to this.instance
	public boolean equals(Temperature t) {
		if(scale == t.scale) { 												//if the scale is the same, directly test
			return temperatureValue == t.temperatureValue;
		} else { 															//else the scales are different
			if(scale == Scale.C) { 											//if this.scale is C, then convert to F and test
				return getFahrenheit() == t.temperatureValue;
			} else { 														//else this.scale is F, convert to C and test
				return getCelsius() == t.temperatureValue;
			}
		}
	}
	
	
	
	//compares given temperature instance to this.instance
	public int compareTo(Temperature t) {
		if(scale == t.scale) {												//if the scale is the same
			if(this.temperatureValue > t.temperatureValue) { 				//this.temp larger?
				return LARGER;
			} else if(this.temperatureValue < t.temperatureValue) { 		//this.temp smaller?
				return SMALLER;
			} else { 														//this.temp must be equal
				return EQUAL;
			}
		} else {															//else scale is not the same 
			if(scale == Scale.C) {											//if scale is C
				float convertedTemp = getFahrenheit();						//convert the temp to F
				if(convertedTemp > t.temperatureValue) { 					
					return LARGER;
				} else if(convertedTemp < t.temperatureValue) { 			
					return SMALLER;
				} else { 													
					return EQUAL;
				}
			} else { 														//else scale is F
				float convertedTemp = getCelsius();							//convert temp to C
				if(convertedTemp > t.temperatureValue) { 					
					return LARGER;
				} else if(convertedTemp < t.temperatureValue) { 			
					return SMALLER;
				} else { 													
					return EQUAL;
				}//end if
			}//end nested else
		}//end else
	}//end if
	
	
	@Override
	public String toString() {
		String state = "";
		state = String.format("%.1f %s %s %.1f %s",							//format to String
				temperatureValue,
				(scale == Scale.C  ? "Degrees C" : "Degrees F"),
				"=",
				(scale == Scale.C ? getFahrenheit() : getCelsius()),
				(scale == Scale.C  ? "Degrees F" : "Degrees C"));
		return state;
	}
	
	
	
}
