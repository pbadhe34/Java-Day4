 package app;
 


import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {
    int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    public Integer call() throws InvalidParamaterException, InterruptedException {
        int fact=1;
        if(number < 0)
            throw new InvalidParamaterException("Number must be positive");

        for(int count=number;count>1;count--){
        	Thread.sleep(1000);        	
            fact=fact * count;
            System.out.println("Counting the factorial  "+fact);
        }

        System.out.println("Returning the factorial  "+fact);
        return fact;
    }

    private class InvalidParamaterException extends Exception {
        public InvalidParamaterException(String message) {
            super(message);
        }
    }
}
