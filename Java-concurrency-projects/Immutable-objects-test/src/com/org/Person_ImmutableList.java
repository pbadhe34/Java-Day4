package com.org;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public final class Person_ImmutableList {
    private final String name;
    private final LocalDate dob;
    private final List<String> hobbies;
    
    public Person_ImmutableList(String name, LocalDate dob, List<String> listDetails) {
        this.name = new String(name);
        this.dob = dob;
        
        this.hobbies =listDetails;     
        
        
    }
    public String getName() {
        String val = new String(name);
        return val;
    }
    public LocalDate getDob() {
        return dob;
    }
    
     
    public List<String> getHobbies() {
    	
        return hobbies;      
    	 
    	
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", dob=" + dob + ", hobbies=" + hobbies + "]";
    }
    
   
}
