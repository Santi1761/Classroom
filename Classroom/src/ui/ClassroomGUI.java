package ui;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;
import javafx.collections.*;


public class ClassroomGUI {
	
	
    @FXML
    private RadioButton optionM;

    @FXML
    private RadioButton optionF;

    @FXML
    private RadioButton optionO;

    @FXML
    private CheckBox optionS; 

    @FXML
    private CheckBox optionT;

    @FXML
    private CheckBox optionI;
		
	@FXML
	private Pane mainPane;
	
    @FXML
    private TextField writeUser, writePassword;

    @FXML
    private Button btnSignup, btnLogin;
    
    @FXML
    private TextField signupName;
    
    @FXML
    private PasswordField signupPassword;

    @FXML
    private TextField directionOfPhoto;

    @FXML
    private VBox vboxRegister;
    
    @FXML
    private Label nameUser;
    
    @FXML
    private ImageView photoUser;
    

    @FXML
    private TableView<UserAccount> tvList;
    
    @FXML
    private TableColumn<UserAccount, String> aName;

    @FXML
    private TableColumn<UserAccount, String> aGender;

    @FXML
    private TableColumn<UserAccount, String> aCareer;

    @FXML
    private TableColumn<UserAccount, String> aBirthday;

    @FXML
    private TableColumn<UserAccount, String> aBrowser;
    
    private ObservableList<UserAccount> observable;
    
    private Classroom classroom;
    
    @FXML
    private MenuButton mBrowser;

    @FXML
    private MenuItem mChrome;

    @FXML
    private MenuItem mFirefox;

    @FXML
    private MenuItem mSafari;
    
    @FXML
    private DatePicker dateBirthday;
    

    public ClassroomGUI() {
    	classroom = new Classroom();    	
    }
    
    
   
    /**
     private void initialize() throws Exception{
           	
    	observable = FXCollections.observableArrayList(classroom.getAccounts());
    	aName.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("username"));
    	aGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("gender"));
    	aCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("career"));
    	aBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("birthday"));
    	aBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("browser"));
    }
    */ 
    
    @FXML
    public void createUser(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		fxmlLoader.setController(this);
		Parent register = fxmlLoader.load();
		mainPane.getChildren().setAll(register);

    }
    
    @FXML
    public void loginUser(ActionEvent event) throws Exception {
    	
    	int place = 0;
    	String user = writeUser.getText();
    	String password = writePassword.getText();
    	
    	
    	if(classroom.userChecker(user, password)) {
    		
         	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
        	fxmlLoader.setController(this);
        	Parent aList = fxmlLoader.load();
        	mainPane.getChildren().setAll(aList);
        	place = classroom.userPos(user, password);
            photoUser.setId(classroom.getAccounts().get(place).getPhoto());
        	//initialize();
        	
    	}else{
    		
			Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Classroom");
	    	alert.setHeaderText("ERROR");
	    	alert.setContentText("The username or the Password is incorrect, please verify and change :)");
	    	alert.showAndWait();
    	}
    	

    }
    
    
    @FXML
    public void searchPhoto(ActionEvent event) {
    	    	
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Search Photo :)");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
         
        Stage stage = (Stage)vboxRegister.getScene().getWindow();
        File imgFile = fileChooser.showOpenDialog(stage);  
           

    } 
        

    @FXML
    public void finishCreation(ActionEvent event) {
    	
    	if(classroom.fieldChecker(getUserInfo())==true ) {
    		    		
    		classroom.add(new UserAccount(getUserInfo()[0], getUserInfo()[1], getUserInfo()[2], getUserInfo()[3], getUserInfo()[4], getUserInfo()[5], getUserInfo()[6]));
    		    		
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("The account Has been created :D");
	    	alert.setHeaderText("Yesss :)");
	    	alert.setContentText("Congratulations ;)");
	    	alert.showAndWait();

    	}else{
    		
			Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("To ocurred a error :(");
	    	alert.setHeaderText("ERROR ;(");
	    	alert.setContentText("Missing data to fill");
	    	alert.showAndWait();
    	}

    }
       
    

    @FXML
    public void returnMainPane(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(this);
		Parent register = fxmlLoader.load();
		mainPane.getChildren().setAll(register);
    }
    
    @FXML
    public void logOut(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(this);
		Parent register = fxmlLoader.load();
		mainPane.getChildren().setAll(register);

    }
    
    
    
    
    public String  getBirthday() {
    	
    	String birth = null;
    	LocalDate date = dateBirthday.getValue();
    	
    	if(date!=null) {
    		
    		birth = date.toString();
    	}
    		
    	return birth;
    }
    
    
    
    public String getCareers()
    {
    	String career = "";
    		
    	if(optionS.isSelected()) {
    		
    		career +=  optionS.getText() +"";
    	}
    	
    	if(optionT.isSelected()) {
    		
    		career += optionT.getText() +"";
    	}
    	
    	if(optionI.isSelected()) {
    		career += optionI.getText() +"";
    	}
    	
    	return career;
    }
    
    public String[] getUserInfo() {
    	
    	String username, password, photo, gender = null, career, birthday,	browser;
    	   	
    	username = signupName.getText(); 
    	password = signupPassword.getText();
    	photo = directionOfPhoto.getText();
    	birthday = getBirthday();
    	career = getCareers();
    	browser = mBrowser.getText();
    	
    	String[] userInfo = {username, password, gender, career, birthday, browser, photo};
    	
    	return userInfo;
    }

       

    public Label getNameUser() {
		return nameUser;
	}

	public void setNameUser(Label nameUser) {
		this.nameUser = nameUser;
	}

	
	
	
	
	public ImageView getPhotoUser() {
		return photoUser;
	}

	public void setPhotoUser(ImageView photoUser) {
		this.photoUser = photoUser;
	}
	
	@FXML
    public void setOption1(ActionEvent event) 
    {
    	mBrowser.setText(mChrome.getText());
    }

    @FXML
    public void setOption2(ActionEvent event) 
    {
    	mBrowser.setText(mFirefox.getText());
    }

    @FXML
    public void setOption3(ActionEvent event) 
    {
    	mBrowser.setText(mSafari.getText());
    }

    
    
    
    
    
    
    
    

}
