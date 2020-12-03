/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tlholo Makhene
 */

public class Person implements Serializable{
    //we implementing the serializable marker interface inorder to allow us to store an object of this class
    //in a persistent format or send over a network
    
    private String idNumber;
    //this is the national id number that will be used to get the gender,
    //the date of birth and age of the person
//reason for idnumber is that we will store it in our db and we want the date of birth and age to be 
    //determined by the application making it a bit more dynamic
    private String fName;//first name
    private String lName;//last name or surname

  
    public enum Gender
    {
    Male,
    Female,
    }
    private Gender gender;
    
    private Date sDOB; //date of birth
    private int age;

    public Person(String idNumber, String fName, String lName) {
        this.idNumber = idNumber;
        this.fName = fName;
        this.lName = lName;
         int actualYear;
         int sGenderValidationValue = Integer.parseInt( idNumber.substring(6,10));
if(sGenderValidationValue < 5000)
{
    this.gender = Gender.Female;
}
else
{
    this.gender = Gender.Male;
}
       //we will set the gender and everything here using the idnumber
       String scurrentDOB = idNumber.substring(0, 6);
       // System.out.println(scurrentDOB); Testing
       int curYear = Integer.parseInt(scurrentDOB.substring(0, 2));//yearplaceholder
        
       String actaulMonth = scurrentDOB.substring(2,4);//month
       
       String actualDay = scurrentDOB.substring(4,6);//day
      
       if(curYear >25)
       {
           actualYear = 1900 + curYear;
       }
       else
       {
          actualYear = 2000 + curYear; 
       }
        Calendar now = Calendar.getInstance();
        int Celendaryear = now.get(Calendar.YEAR);
        //System.out.println(Celendaryear); Testing
        this.age = Celendaryear - actualYear;
        try
        {
            String DateOfBirth = actualDay+"/"+actaulMonth +"/"+actualYear; 
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(DateOfBirth); 
        this.sDOB = date1; 
        }
        catch(ParseException ex)
        {System.out.println("Error occurred");}
       
       
    }

    public Person() {
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters&Setters">
 public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber =  (idNumber.isEmpty()) ? "None":idNumber ;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName =  (fName.isEmpty()) ? "None":fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = (lName.isEmpty()) ? "None":lName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getsDOB() {
        return sDOB;
    }

    public void setsDOB(Date sDOB) {
        this.sDOB = sDOB;
    }

  

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

// </editor-fold>

    
    public String FormateDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
    String strDate= formatter.format(this.sDOB); 
    return strDate;
    }
    @Override
    public String toString() {
         
        return "Person{" + "idNumber=" + idNumber + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", sDOB=" + FormateDate() + ", age=" + age + '}';
    }

   //<editor-fold defaultstate="collapsed" desc="polymorphism">
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

       @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idNumber);
        hash = 97 * hash + Objects.hashCode(this.fName);
        hash = 97 * hash + Objects.hashCode(this.lName);
        hash = 97 * hash + Objects.hashCode(this.gender);
        hash = 97 * hash + Objects.hashCode(this.sDOB);
        hash = 97 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.idNumber, other.idNumber)) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.sDOB, other.sDOB)) {
            return false;
        }
        return true;
    }
   
    
      //</editor-fold>

    
    
    public int compareTo(Person o) {
     return this.fName.compareTo(o.fName) & this.lName.compareTo(o.lName); 
    }
}
