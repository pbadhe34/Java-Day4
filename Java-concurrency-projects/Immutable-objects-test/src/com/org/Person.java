package com.org;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public final class Person {
    private final String name;
    private final LocalDate dob;
    private final List<String> hobbies;
    
    public Person(String name, LocalDate dob, List<String> listDetails) {
        this.name = new String(name);
        this.dob = dob;
        
        this.hobbies =listDetails;
        
        
        // //Copy the elements from parm list to object list
        
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
    	
        return hobbies;
        
    	/*ArrayList list = (ArrayList) hobbies;
    	
    	return (List<String>) list.clone();
    	*/
    	
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", dob=" + dob + ", hobbies=" + hobbies + "]";
    }
    
   
}
