package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu_Jeter_Method extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
			// create gridpane
			GridPane gridPane = new GridPane();
			// set alignment and gaps
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.setPadding(new Insets(25));
			
			// labels and textfields
			Label userNameLabel = new Label("Username:");
			TextField userNameField = new TextField();
			Label passwordLabel = new Label("Password:");
			PasswordField passwordField = new PasswordField();
			
			// add the nodes to the grid
			gridPane.add(userNameLabel, 0, 0);
			gridPane.add(userNameField, 1, 0);
			gridPane.add(passwordLabel, 0, 1);
			gridPane.add(passwordField, 1, 1);
			
			Button loginBtn = new Button("Login");
			gridPane.add(loginBtn, 1, 2);
			
			// set alignment of login btn
			GridPane.setHalignment(loginBtn, HPos.RIGHT);
			
			loginBtn.setOnAction(e->{
				String user = userNameField.getText();
				String pw = passwordField.getText();
				
				boolean valid = validLogin(user, pw);
				
				if(valid) {
					popUpSelection(primaryStage);
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("LOGIN FAILED");
					alert.setHeaderText(null);
					alert.setContentText("USERNAME OR PASSWORD IS INCORRECT");
					alert.showAndWait();
				}
			});
			
			
			// create scene and add login screen
			Scene scene = new Scene(gridPane, 400, 400);
			primaryStage.setTitle("SCCC Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public boolean validLogin(String user, String pw) {
		return user.equals("admin") && pw.equals("admin");
	}
	
	private void popUpSelection(Stage primaryStage) {
		// pop up buttons
		Button studentBtn = new Button("Student");
		Button instructorBtn = new Button("Instructor");
		
		studentBtn.setStyle("-fx-font-size: 12px; -fx-min-height: 200px; -fx-min-width: 200px;");
        instructorBtn.setStyle("-fx-font-size: 12px; -fx-min-height: 200px; -fx-min-width: 200px;");

		// set a split pane to have split screen 
		SplitPane root = new SplitPane();
		root.setOrientation(Orientation.HORIZONTAL);
		
		// stack pane for the buttons
		StackPane studentStackPane = new StackPane();
		studentStackPane.getChildren().add(studentBtn);
		
		StackPane instructorStackPane = new StackPane();
		instructorStackPane.getChildren().add(instructorBtn);
		
		// split the pane in half
		root.setDividerPositions(0.5);
		
		// add item into the pane
		root.getItems().addAll(studentStackPane, instructorStackPane);
		
		studentBtn.setOnAction(e ->{
			// once student is selected be prompted to add or find a student
			HBox forStudentSelection = new HBox(10);
			forStudentSelection.setAlignment(Pos.CENTER);
			forStudentSelection.setPadding(new Insets(15));
			
			Label askToFindOrAdd = new Label("Would you like to find or add a student?");
			ChoiceBox addOrFind = new ChoiceBox();
			String[] options = {"Add Student", "Find Student"};
			addOrFind.getItems().addAll(options);
		
			Button selectOption = new Button("Select");
			selectOption.setAlignment(Pos.BOTTOM_RIGHT);
			
			selectOption.setOnAction(e1 -> {
				/* 
				 * depending on what is selected, 
				 * if add is selected prompt screen to add a student
				 * if find is selected then prompt with parameters to search for student
				 * also add "Edit" "Remove "button after person is found
				 */
				String selectedOption = addOrFind.getSelectionModel().getSelectedItem().toString();
				
				switch(selectedOption) {
				
				case "Add Student":
					addStudentPane(primaryStage);
					break;
				case "Find Student":
					findStudentPane(primaryStage);
					break; 
				default:
					System.out.println("Invalid Option Selected");
					break;
				}
				
			});
			
			forStudentSelection.getChildren().addAll(askToFindOrAdd, addOrFind, selectOption);
			
			Scene choiceScene = new Scene(forStudentSelection);
			primaryStage.setScene(choiceScene);
			primaryStage.show();
			
		});
		
		instructorBtn.setOnAction(e ->{
			// once instructor is selected be prompted to add or find a instructor
			HBox forInstructorSelection = new HBox(10);
			forInstructorSelection.setAlignment(Pos.CENTER);
			forInstructorSelection.setPadding(new Insets(15));
			
			Label askToFindOrAdd = new Label("Would you like to find or add a Instructor?");
			ChoiceBox addOrFind = new ChoiceBox();
			String[] options = {"Add Instructor", "Find Instructor"};
			addOrFind.getItems().addAll(options);
			
			Button selectOption = new Button("Select");
			selectOption.setAlignment(Pos.BOTTOM_RIGHT);
			
			selectOption.setOnAction(e1 -> {
				/* 
				 * depending on what is selected, 
				 * if add is selected prompt screen to add a instructor
				 * if find is selected then prompt with parameters to search for instructor
				 * also add "Edit" "Remove "button after person is found
				 */
				
				String selectedOption = addOrFind.getSelectionModel().getSelectedItem().toString();
				
				switch(selectedOption) {
				
				case "Add Instructor":
					// add instructor screen
					break;
				case "Find Instructor":
					// find instructor screen - edit / remove options
				}
			});
			
			forInstructorSelection.getChildren().addAll(askToFindOrAdd, addOrFind, selectOption);
			
			Scene choiceScene = new Scene(forInstructorSelection);
			primaryStage.setScene(choiceScene);
			primaryStage.show();
		});
		
		
		Scene selectionScene = new Scene(root, 400, 200);
		primaryStage.setTitle("Selection");
		primaryStage.setScene(selectionScene);
		primaryStage.show();
	}

	private void addStudentPane(Stage primaryStage) {
		// hbox to ask for the student's information
		VBox addStudentPane = new VBox(20);
		addStudentPane.setAlignment(Pos.CENTER);
		addStudentPane.setPadding(new Insets(15));
		// create the label and text area
		Label addStudentLabel = new Label("Enter Student Information:");
		TextArea addStudentTextArea = new TextArea();
		addStudentTextArea.setPrefWidth(200);
		addStudentTextArea.setPrefHeight(200);
		// buttons to add the student
		Button addStudentFromTextArea = new Button("Add");
		addStudentFromTextArea.setAlignment(Pos.CENTER);
		addStudentFromTextArea.setOnAction(e -> {
			// action to add the student into the bag
		});
		// add the label and fields
		addStudentPane.getChildren().addAll(addStudentLabel, addStudentTextArea,
				addStudentFromTextArea);
		// set the add student box 
		Scene addStudentScene = new Scene(addStudentPane, 400, 400);
		primaryStage.setScene(addStudentScene);
		primaryStage.show();
	}
	
	private void findStudentPane(Stage primaryStage) {
		/*
		 *  hbox to ask for the students info to search for them, 
		 * along w exit and remove button
		 */
		VBox findStudentPane = new VBox(20);
		findStudentPane.setAlignment(Pos.CENTER);
		findStudentPane.setPadding(new Insets(15));
		// create the list of parameters to search with 
		ObservableList<String> items = FXCollections.observableArrayList(
                "Name", "GPA","Major");
		//create listview and add items
		ListView<String> listView = new ListView<>(items);
        listView.setPrefSize(200, 150);
        // list view different selection changes
        listView.getSelectionModel().selectedItemProperty().addListener((observable, 
        		oldValue, newValue) -> {
        	if(newValue != null) {
        		// action depending on what was selected
        	}
        });
        // buttons for find edit and remove
        Button findStudent = new Button("Find");
		findStudent.setAlignment(Pos.CENTER);
		findStudent.setOnAction(e -> {
			// find student on click, once student is found have screen w edit and remove button
		});
		
        
		
		findStudentPane.getChildren().addAll(listView, findStudent);
		
		// set the scene
		Scene scene = new Scene(findStudentPane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	
	

}
