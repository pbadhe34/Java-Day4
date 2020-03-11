package com.org;

 

import java.util.ArrayList;
import java.util.List;

 

public class ImmutableObjectTest {

     public static void main(String args[])
     {
    	 Currency $ = Currency.of("Dollar");
    	 Money mon = new Money(345.89,$);
    	 System.out.println("Money Amount is "+mon.getAmount());
    	 System.out.println("Money Currency is "+mon.getCurrency().getValue());
    	 
    	 Currency uk = Currency.of("Pounds");
    	 mon = new Money(512,uk);
    	 
    	 System.out.println("Money Amount is "+mon.getAmount());
    	 System.out.println("Money Currency is "+mon.getCurrency().getValue());
    	
    	 
     } 

     

     
     
}
