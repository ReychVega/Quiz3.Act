/*
a. Atributos:
id(int), lastname(String), firstname(String), title(String), birthday(Date)
b. Métodos:
getAge() retorna la edad en años de la persona
toString() redefina y muestre "(ID)"+id +"/(Name)"+lastname+", "+firstname
+ "/(Birthday)"+util.Utility.dateFormat(birthday)+ "/(Title)"+title
+"/(Age)"+ getAge(birthday);
Importante: util.Utility.dateFormat(Date date): retorna la fecha en formato dd/MM/yyyy
getAge(Date date): retorna un valor entero que equivale a la edad en años, de acuerdo a la fecha indicada. 
Es responsabilidad de cada estudiante implementar los métodos correspondientes.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Reychell Vega Pérez.
 */
public class Employee {
//atributos    
private int id;
private String lastname;
private String firstname;
private String title;
private Date birthday;
private Date currentDate;

//constructor
    public Employee(int id, String lastname, String firstname, String title, Date birthday) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.title = title;
        this.birthday = birthday;
        this.currentDate=new Date();
    }

//gets and sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCurrentDate() {
        return currentDate;
    }
    
    //methods
    public int getAge() {
        
        int year = getBirthday().getYear();
        int currentYear=getCurrentDate().getYear();
        return currentYear-year;
    
    }

    public String toString() {
        return "(ID)" + id + "/(Name)" + lastname + ", " + firstname
                + "/(Birthday)" + util.Utility.dateFormat(birthday) + "/(Title)" + title
                + "/(Age)" + getAge();
    }
}
