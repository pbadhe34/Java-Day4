package com.org;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public final class Person_UnmodifiableList {
    private final String name;
    private final LocalDate dob;
    private final List<String> hobbies;
    
    public Person_UnmodifiableList(String name, LocalDate dob, List<String> listDetails) {
        this.name = new String(name);
        this.dob = dob;
        
        this.hobbies = listDetails;
        
        //Copy the elements from parm list to new list  and assign 
        // to oobject instance
        /*List<String> currentList = new ArrayList<String>();
        currentList.addAll(listDetails);
        this.hobbies = currentList;*/
    }
    public String getName() {
        String val = new String(name);
        return val;
    }
    public LocalDate getDob() {
        return dob;
    }
    
    public void setDob(LocalDate newDate) {         
    	 //throw new UnsupportedException();
    	 
    }
    public List<String> getHobbies() {
    	 //Return the current list  wrapped with Unmodifiable Collection
    	return Collections.unmodifiableList(hobbies);
    	
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", dob=" + dob + ", hobbies=" + hobbies + "]";
    }
    
   
}
