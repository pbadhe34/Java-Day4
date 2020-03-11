  ImmtableLIst usage

 1. Customize list by implmenting List interface to avoid or block add operations.

  2. Use com.google.common.collect.ImmutableList class from google Guava library

  3. In Person class to return

  
  public List<Account> getAccounts() {
            	
  return Collections.unmodifiableList(accounts);



    	  
    }