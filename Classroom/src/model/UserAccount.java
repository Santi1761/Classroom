package model;

public class UserAccount {
	
	private String username;
	private String password;
	private String gender;
	private String career;
	private String birthday; 
	private String browser;
	private String photo;
	
	
	
	public UserAccount(String username, String password, String gender, String career, String birthday, String browser, String photo) {
		
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.career = career; 
		this.birthday = birthday;
		this.browser = browser;
		this.photo = photo;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	
	
}
