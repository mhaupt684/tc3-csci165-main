public class Employee{

    private String  name;
    private int     id;
    private double  wage;

    public Employee(){}

    public Employee(String name, int id, double wage) {
        this.name   = name;
        this.id     = id;
        this.wage   = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws EmployeeRecordException{
        if(id < 1000) {
        	throw new EmployeeRecordException(EmployeeErrors.messages[0]);
        } else if(id > 9999) {
        	throw new EmployeeRecordException(EmployeeErrors.messages[1]);
        }
        
        this.id = id;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) throws EmployeeRecordException{
    	if(wage < 9.00) {
        	throw new EmployeeRecordException(EmployeeErrors.messages[2]);
        } else if(wage > 25.00) {
        	throw new EmployeeRecordException(EmployeeErrors.messages[3]);
        }
    	
    	this.wage = wage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(wage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null)    return false;
        if (getClass() != obj.getClass())
            return false;

        Employee other = (Employee) obj;
        if (id != other.id) return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(wage) != Double.doubleToLongBits(other.wage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", wage=" + wage + "]";
    }


}
