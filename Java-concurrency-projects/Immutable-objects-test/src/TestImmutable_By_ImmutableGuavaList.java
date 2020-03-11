 
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;
 
import com.org.Person_ImmutableList;
 

import java.time.LocalDate;
 

 
 

public class TestImmutable_By_ImmutableGuavaList {
    public static void main(String[] args) {
    	ImmutableList <String> hobbiesList = ImmutableList.of("abc","pqr","xyz");
         
    	//java.lang.UnsupportedOperationException
       /* hobbiesList.add("Painting");
        hobbiesList.add("Cooking");*/
        
    	//java.lang.UnsupportedOperationException
       // hobbiesList.set(1, "NewAnalytics");
         
        
        LocalDate date = LocalDate.now();
        
        String uname = "Baba";
        
        Person_ImmutableList per = new Person_ImmutableList(uname,date,hobbiesList);      
        
      
        System.out.println("The list  original is "+per.getHobbies());
        List currentlist = per.getHobbies();
        //java.lang.UnsupportedOperationException to add new element
      
        ////java.lang.UnsupportedOperationException
        currentlist.add("Politics");        
        
        System.out.println("The list  moified is "+currentlist);
        System.out.println("The person list after first  modification is "+per.getHobbies());
        
        //Assign new List
        currentlist = new ArrayList<String>();
        
       // currentlist = ImmutableList.copyOf(arg0)
       // currentlist=	(List) ImmutableList.toImmutableList();
        
        currentlist =  ImmutableList.of("Newdata");
        System.out.println("The person list after second modification is "+per.getHobbies());
        
        //Update original Assigned list object
        
        //Person is assigned a ref to hobbiesList..Change that to 
        //adding elements from hobbiesList to Person current list
        
        //java.lang.UnsupportedOperationException
        hobbiesList.add("Robbery");
        
      //java.lang.UnsupportedOperationException
        hobbiesList.set(3, "DataWares");
        
        hobbiesList.asList() ;//returns new Immuatble List
         
        System.out.println("The person list after third modification is "+per.getHobbies());
        
       // hobbiesList.subList(fromIndex, toIndex)
    }
}
 