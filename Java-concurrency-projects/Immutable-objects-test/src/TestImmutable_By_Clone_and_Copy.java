 
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import com.org.Person;
 

public class TestImmutable_By_Clone_and_Copy {
    public static void main(String[] args) {
        ArrayList<String> hobbiesList = new ArrayList<String>();
         
        hobbiesList.add("Painting");
        hobbiesList.add("Cooking");
        
        //The LocalDate is immutable by default
        
        LocalDate date = LocalDate.now();
        
        String uname = "Ashok";
        
        Person per = new Person(uname,date,hobbiesList);
        
        //per.setDob(LocalDate.now()); 
        System.out.println("The dob  original is "+per.getDob());
        
        per.getDob().plusDays(12);
        //return new Localdate..doesnot modify orinka LocalDate
      
        //return new Localdate..doesnot modify orinka LocalDate
        per.getDob().plusMonths(8);
        
        System.out.println("The dob  now is "+per.getDob());        
        
        LocalDate current =  per.getDob() ;
        //assign new LocalDate Instance
        current = LocalDate.of(2014, Month.JANUARY, 11);
        System.out.println("The new dob  is "+current); 
        System.out.println("The person original dob   is "+per.getDob());       
        
        //Modify com.org.Person getHobbies() to return clone of original ArrayList

        System.out.println("The list  original is "+per.getHobbies());
        List currentlist = per.getHobbies();
        currentlist.add("Trekking");        
        
        System.out.println("The list  moifiedd is "+currentlist);
        System.out.println("The person list after modification is "+per.getHobbies());
        
        //Assign new List
        currentlist = new ArrayList<String>();
        System.out.println("The person list after second modification is "+per.getHobbies());
        
        //Update original Assigned list object
        
        //Person is assigned a ref to hobbiesList..Change that to 
        //adding elements from hobbiesList to Person current list
        
        hobbiesList.add("Drawing");        
        System.out.println("The person list after third modification is "+per.getHobbies());
        
        
    }
}
 