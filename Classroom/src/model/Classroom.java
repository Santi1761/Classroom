package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	private List<UserAccount> accounts;
	
	
	
	public Classroom() {
		accounts = new ArrayList <UserAccount>();
		accounts.add(new UserAccount("santi_1761","password123","masculino","system","11/11/1999","browser","photo"));
		
	}
	
	public boolean add(UserAccount newUser) {
		if (accounts.add(newUser)) {
			return true;
		}else {
			return false;
		}
	} 
	
	public boolean userChecker(String user, String password) {
		
		boolean checker = true;
		
		for(int i=0;i<accounts.size();i++) {
			if ((accounts.get(i).getUsername().equals(user) ) && accounts.get(i).getPassword().equals(password)){
				checker = false;
			}	
		}		
		return checker; 
	}
	
	public boolean fieldChecker(String [] uInfo ) { 
		
		boolean incompleteFields = true; 
		
		for(int i=0;i<uInfo.length && !incompleteFields; i++ ) {
			
			if(uInfo[i] == null ) {
				
				incompleteFields = false;
			}
		}
		
		return incompleteFields;
	}
	
	public int userPos(String username,String password) {
		
        int place = -1;
        
        for(int i=0; i< accounts.size();i++) {
        	
            if(username.equals(accounts.get(i).getUsername()) && password.equals(accounts.get(i).getPassword())) {
                place=i;
            }
        }
        
        return place;
	}

	
	public List<UserAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<UserAccount> accounts) {
		this.accounts = accounts;
	}
	
	

}
