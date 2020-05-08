public class Student extends Person implements Comparable<Student>{

    public static enum CLASS_LEVEL {FR, SO, JR, SR};

    private CLASS_LEVEL level;
    private String id;
    
    //constructor
    public Student(Person person, String id, CLASS_LEVEL level) {
    	super(person);
    	this.setId(id);
    	this.setLevel(level);
    }
    
    //copy constructor
    public Student(Student s) {
    	super(s);
    	this.id = s.id;
    	this.level = s.level;
    }
    
    public CLASS_LEVEL getLevel() {
        return level;
    }

    public void setLevel(CLASS_LEVEL level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public int compareTo(Student other) {
    	if(this.level.compareTo(other.level)<0)	return -1;
    	if(this.level.compareTo(other.level)>0)	return 1;
    	return 0;
    }

    @Override
    public String toString() {
        return  super.toString()    +
                "\nID: " + id       +
                "\nYear: " + level;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)        return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass())   return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (level != other.level)
            return false;
        return true;
    }
    
    
    
}
