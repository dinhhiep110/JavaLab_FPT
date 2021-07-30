public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor() {};

    public Doctor(String name, String specialization, int availability) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void display() {
        // System.out.printf("%-17s%-15s%-15s%-15s\n",code,name,specialization,availability);

        System.out.printf("%-10s%-20s%-20s\n",name,specialization,availability);
    }

    
    


}
