package se.chalmers.dm;

public class User {

    private int id;
    private String ssn;
    private String fname;
    private String lname;
    private String email;
    private Boolean isActive;


    public User(int id , String ssn, String fname , String lname , String email , Boolean isActive){

        this.id = id;
        this.ssn = ssn;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.isActive = isActive;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    @Override
    public String toString() {
        return "Id=" + id +
                ", Ssn='" + ssn + '\'' +
                ", Fname='" + fname + '\'' +
                ", Lname='" + lname + '\'' +
                ", Email='" + email + '\'' +
                ", Is active=" + isActive;
    }
}
