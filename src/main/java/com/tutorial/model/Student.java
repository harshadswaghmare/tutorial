package com.tutorial.model;

public class Student {
    private long studentID;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

   private Tutorial tutorial;
   private String title;
   private String description;

   private boolean isPublished;



   public Student()
   {

   }


 /*   public Student(long studentID, String firstName, String lastName, String address, String gender) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }*/

    public Student(String firstName, String lastName, String address, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return  title;
    }
   public void setTitle(String title)
   {
       this.title = title;
  }

   public String getDescription()
   {
       return description;
    }

  public void setDescription(String description)
  {
       this.description = description;
   }

   public Boolean getIsPublished()
   {
      return isPublished;
   }
  // public void setPublished( Boolean isPublished)
   //{
   //   this.isPublished= isPublished;
  // }


    @Override
    public String toString() {
        return "Student [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ",gender =" + gender + "]";
    }
}