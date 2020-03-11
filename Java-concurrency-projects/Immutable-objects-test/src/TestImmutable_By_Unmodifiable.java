 
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.org.Person;
import com.org.Person_UnmodifiableList;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

 
 

public class TestImmutable_By_Unmodifiable {
    public static void main(String[] args) {
        ArrayList<String> hobbiesList = new ArrayList<String>();
         
        hobbiesList.add("Painting");
        hobbiesList.add("Cooking");
         
        
        LocalDate date = LocalDate.now();
        
        String uname = "Vijay";
        
        Person_UnmodifiableList per = new Person_UnmodifiableList(uname,date,hobbiesList);      
        
      
        System.out.println("The list  original is "+per.getHobbies());
        List currentlist = per.getHobbies();
        //java.lang.UnsupportedOperationException to add new element
      
        //currentlist.add("Ploitics");        
        
        System.out.println("The list  moified is "+currentlist);
        System.out.println("The person list after first  modification is "+per.getHobbies());
        
        //Assign new List
        currentlist = new ArrayList<String>();
        System.out.println("The person list after second modification is "+per.getHobbies());
        
        //Update original Assigned list object
        
        //Person is assigned a ref to hobbiesList..Change that to 
        //adding elements from hobbiesList to Person current list
        
        hobbiesList.add("Robbery");
         
        System.out.println("The person list after third modification is "+per.getHobbies());
        
        
    }
}
 