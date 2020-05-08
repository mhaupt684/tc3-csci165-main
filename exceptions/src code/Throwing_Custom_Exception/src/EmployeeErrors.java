public class EmployeeErrors{

    // The employee number is not numeric, less than 1000, or more than 9999.
    // The hourly pay rate is not numeric, less than $9.00, or more than $25.00.

    public static final int     ID_MIN  = 1000;
    public static final int     ID_MAX  = 9999;
    public static final double  WAGE_MIN = 9;
    public static final double  WAGE_MAX = 25;

    public static final String[] messages = {"Employee ID cannot be less than "      + ID_MIN,
                                             "Employee ID cannot be larger than "    + ID_MAX,
                                             "Pay rate can not be less than $"       + WAGE_MIN,
                                             "Pay rate can not be larger than $"     + WAGE_MAX};
}
