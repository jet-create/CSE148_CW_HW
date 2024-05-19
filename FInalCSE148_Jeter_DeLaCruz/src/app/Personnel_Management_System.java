package app;

import java.io.File;
import java.util.function.Predicate;

import File_Handler.FileHandler;
import Bag.PersonBag;
import Enums.Major;
import Enums.Rank;
import Persons.Person;
import Persons.Student;
import Persons.Instructor;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Personnel_Management_System extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// give title to the stage
		primaryStage.setTitle("Main Menu");
		// borderpane to hold all of my buttons
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		// Main menu for the pane
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menuBar);
		// menus for our menu bar
		Menu fileMenu = new Menu("File");
		// items for that file menu
		// menu items to import students/instructors
		Menu importMenu = new Menu("Import");
		MenuItem importStudent = new MenuItem("Student");
		importStudent.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			// default directory
			File defaultDirectory = new File("/Users/jeterd");
			fileChooser.setInitialDirectory(defaultDirectory);

			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Text Files", "*.txt"),
					new FileChooser.ExtensionFilter("All Files", "*.*"));

			File file = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				PersonBag.getInstance().importStudents(file.getPath());
			}
		});
		MenuItem importInstructor = new MenuItem("Instructor");
		importInstructor.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			// default directory
			File defaultDirectory = new File("/Users/jeterd");
			fileChooser.setInitialDirectory(defaultDirectory);

			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
					new FileChooser.ExtensionFilter("All Files", "*.*"));

			File file = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				PersonBag.getInstance().importInstructors(file.getPath());
			}

		});
		importMenu.getItems().addAll(importStudent, importInstructor);

		// menu items for everything else
		MenuItem exportItem = new MenuItem("Export");
		exportItem.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Export Data");
			File file = fileChooser.showOpenDialog(primaryStage);
			if(file != null) {
				PersonBag.getInstance().exportData(file.getPath());
			}
		});
		MenuItem backupItem = new MenuItem("Backup");
		backupItem.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Backup Data");
			File file = fileChooser.showOpenDialog(primaryStage);
			if(file != null) {
				FileHandler.saveToFile(PersonBag.getInstance());
			}
		});
		MenuItem restoreItem = new MenuItem("Restore");
		restoreItem.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Restore Data");
			File file = fileChooser.showOpenDialog(primaryStage);
			if(file != null) {
				FileHandler.loadFromFile();
			}
		});
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(e -> Platform.exit());

		fileMenu.getItems().addAll(importMenu, exportItem, new SeparatorMenuItem(), backupItem, restoreItem,
				new SeparatorMenuItem(), exitItem);

		// Menu + items to switch between views
		Menu optionsMenu = new Menu("Options");
		MenuItem studentView = new MenuItem("Student View");
		studentView.setOnAction(e -> {

			Scene initialScene = primaryStage.getScene();
			primaryStage.setTitle("Student");
			GridPane studentPane = new GridPane();
			studentPane.setAlignment(Pos.CENTER);
			studentPane.setHgap(10);
			studentPane.setVgap(10);
			studentPane.setPadding(new Insets(20));
			Scene studentScene = new Scene(studentPane, 600, 400);
			primaryStage.setScene(studentScene);
			primaryStage.show();

			// text fields for the borderpane
			TextField nameField = new TextField();
			TextField gpaField = new TextField();
			TextField majorField = new TextField();
			TextField idField = new TextField();

			studentPane.add(new Label("Name:"), 0, 0);
			studentPane.add(nameField, 1, 0);
			studentPane.add(new Label("Major:"), 0, 1);
			studentPane.add(majorField, 1, 1);
			studentPane.add(new Label("GPA:"), 0, 2);
			studentPane.add(gpaField, 1, 2);
			studentPane.add(new Label("ID#:"), 0, 3);
			studentPane.add(idField, 1, 3);

			// continue to implement stuff for students
			Button insertBtn = new Button("Insert");
			insertBtn.setOnAction(a -> {
				String name = nameField.getText();
				String major = majorField.getText();
				String gpa = gpaField.getText();
				String id = idField.getText();
				
				if(name.isEmpty()||major.isEmpty()||gpa.isEmpty()) {
					Alert emptyAlert = new Alert(AlertType.ERROR);
					emptyAlert.setTitle("Fields are empty.");
					emptyAlert.setContentText("Not able to add student.");
					emptyAlert.showAndWait();
				} else { 
					Person student = new Student(name, Double.parseDouble(gpa), 
							Major.valueOf(major));
					PersonBag.getInstance().insert(student);
					Alert insertAlert = new Alert(AlertType.INFORMATION);
					insertAlert.setTitle("Student Inserted");
					insertAlert.setContentText("Successfully inserted Student!");
					insertAlert.showAndWait();
				}
			});
			Button searchBtn = new Button("Search");
			searchBtn.setOnAction(a -> {
				String id = idField.getText();

				if (!id.isEmpty()) {
					Predicate<Person> idFind = s -> s.getId().equals(id);
					Person[] foundStudent = PersonBag.getInstance().search(idFind);

					if (foundStudent.length > 0) {
						Student student = (Student) foundStudent[0];
						nameField.setText(student.getName());
						majorField.setText(String.valueOf(student.getMajor()));
						gpaField.setText(String.valueOf(student.getGpa()));
						idField.setText(student.getId());
					} else {
						Alert notFoundAlert = new Alert(AlertType.ERROR);
						notFoundAlert.setTitle("Student Not Found");
						notFoundAlert.setContentText("No student found with ID: " + id);
						notFoundAlert.showAndWait();
					}

				} else {
					Alert emptyAlert = new Alert(AlertType.WARNING);
					emptyAlert.setTitle("Empty ID");
					emptyAlert.setContentText("Please enter an ID to search.");
					emptyAlert.showAndWait();
				}

			});
			Button removeBtn = new Button("Remove");
			removeBtn.setOnAction(a -> {
				String id = idField.getText();
				if (!id.isEmpty()) {
					Predicate<Person> idSearch = s -> s.getId().equals(id);
					Person[] removeStudents = PersonBag.getInstance().delete(idSearch);

					if (removeStudents.length > 0) {
						nameField.clear();
						majorField.clear();
						gpaField.clear();
						idField.clear();
						Alert removedAlert = new Alert(AlertType.CONFIRMATION);
						removedAlert.setTitle("Student removed");
						removedAlert.setContentText("Student removed with ID: " + id);
						removedAlert.showAndWait();
					} else {
						Alert notFoundAlert = new Alert(AlertType.ERROR);
						notFoundAlert.setTitle("Student Not Found");
						notFoundAlert.setContentText("No student found with ID: " + id);
						notFoundAlert.showAndWait();
					}
				} else {
					Alert emptyAlert = new Alert(AlertType.WARNING);
					emptyAlert.setTitle("Empty ID");
					emptyAlert.setContentText("Please enter an ID to search.");
					emptyAlert.showAndWait();
				}
			});
			Button updateBtn = new Button("Update");
			updateBtn.setOnAction(a -> {
				String id = idField.getText();
				if (!id.isEmpty()) {
					String updatedName = nameField.getText();
					Major updatedMajor = Major.valueOf(majorField.getText());
					double updatedGPA = Double.parseDouble(gpaField.getText());

					Predicate<Person> idFound = s -> s.getId().equals(id);
					Person[] foundStudent = PersonBag.getInstance().search(idFound);

					if (foundStudent.length > 0) {
						Student student = (Student) foundStudent[0];
						// update information based on the field
						if (!updatedName.isEmpty()) {
							student.setName(updatedName);
						}

						student.setMajor(updatedMajor);

						student.setGpa(updatedGPA);

						Alert updateAlert = new Alert(AlertType.INFORMATION);
						updateAlert.setTitle("Student Updated");
						updateAlert.setContentText("Student ID: " + id + " updated!");
						updateAlert.showAndWait();

						// update the fields after change
						nameField.setText(student.getName());
						majorField.setText(student.getMajor().toString());
						gpaField.setText(String.valueOf(student.getGpa()));
					} else {
						Alert notFoundAlert = new Alert(AlertType.ERROR);
						notFoundAlert.setTitle("Student Not Found");
						notFoundAlert.setContentText("No student found with ID: " + id);
						notFoundAlert.showAndWait();
					}
				} else {
					Alert emptyAlert = new Alert(AlertType.WARNING);
					emptyAlert.setTitle("Empty ID");
					emptyAlert.setContentText("Please enter an ID to search.");
					emptyAlert.showAndWait();
				}
			});

			studentPane.add(insertBtn, 0, 4);
			studentPane.add(searchBtn, 1, 4);
			studentPane.add(removeBtn, 2, 4);
			studentPane.add(updateBtn, 3, 4);

			Button backBtn = new Button("Back");
			backBtn.setOnAction(b -> {
				primaryStage.setScene(initialScene);
				primaryStage.setTitle("Main Menu");
				primaryStage.show();

				// clear fields when button is pressed
				nameField.clear();
				gpaField.clear();
				majorField.clear();
				idField.clear();
			});

			// align back button
			studentPane.add(backBtn, 0, 5);
			GridPane.setHalignment(backBtn, HPos.LEFT);

		});

		MenuItem instructorView = new MenuItem("Instructor View");
		instructorView.setOnAction(e -> {
			Scene initialScene = primaryStage.getScene();

			primaryStage.setTitle("Instructor");
			GridPane instructorPane = new GridPane();
			instructorPane.setAlignment(Pos.CENTER);
			instructorPane.setHgap(10);
			instructorPane.setVgap(10);
			instructorPane.setPadding(new Insets(20));
			Scene instructorScene = new Scene(instructorPane, 600, 400);
			primaryStage.setScene(instructorScene);
			primaryStage.show();

			// text fields for the borderpane
			TextField nameField = new TextField();
			TextField salaryField = new TextField();
			TextField rankField = new TextField();
			TextField idField = new TextField();

			instructorPane.add(new Label("Name:"), 0, 0);
			instructorPane.add(nameField, 1, 0);
			instructorPane.add(new Label("Rank:"), 0, 1);
			instructorPane.add(rankField, 1, 1);
			instructorPane.add(new Label("Salary:"), 0, 2);
			instructorPane.add(salaryField, 1, 2);
			instructorPane.add(new Label("ID#:"), 0, 3);
			instructorPane.add(idField, 1, 3);

			Button insertBtn = new Button("Insert");
			insertBtn.setOnAction(a -> {
				String name = nameField.getText();
				String rank = rankField.getText();
				String salary = salaryField.getText();
				String id = idField.getText();
				
				if(name.isEmpty()||rank.isEmpty()||salary.isEmpty()) {
					Alert emptyAlert = new Alert(AlertType.ERROR);
					emptyAlert.setTitle("Fields are empty.");
					emptyAlert.setContentText("Not able to add student.");
					emptyAlert.showAndWait();
				} else { 
					Person instructor = new Instructor(name, Double.parseDouble(salary), 
							Rank.valueOf(rank));
					PersonBag.getInstance().insert(instructor);
					Alert insertAlert = new Alert(AlertType.INFORMATION);
					insertAlert.setTitle("Instructor Inserted");
					insertAlert.setContentText("Successfully inserted Instructor!");
					insertAlert.showAndWait();
				}
			});
			Button searchBtn = new Button("Search");
			searchBtn.setOnAction(a -> {
				String id = idField.getText();
				if (!id.isEmpty()) {
					Predicate<Person> idFind = s -> s.getId().equals(id);
					Person[] foundInstructor = PersonBag.getInstance().search(idFind);

					if (foundInstructor.length > 0) {
						Instructor instructor = (Instructor) foundInstructor[0];
						nameField.setText(instructor.getName());
						rankField.setText(String.valueOf(instructor.getRank()));
						salaryField.setText(String.valueOf(instructor.getSalary()));
						idField.setText(instructor.getId());
					} else {
						Alert notFoundAlert = new Alert(AlertType.ERROR);
						notFoundAlert.setTitle("Instructor Not Found");
						notFoundAlert.setContentText("No instructor found with ID: " + id);
						notFoundAlert.showAndWait();
					}

				} else {
					Alert emptyAlert = new Alert(AlertType.WARNING);
					emptyAlert.setTitle("Empty ID");
					emptyAlert.setContentText("Please enter an ID to search.");
					emptyAlert.showAndWait();
				}

			});
			Button removeBtn = new Button("Remove");
			removeBtn.setOnAction(a -> {
				String id = idField.getText();
				if (!id.isEmpty()) {
					Predicate<Person> idSearch = s -> s.getId().equals(id);
					Person[] removeInstructors = PersonBag.getInstance().delete(idSearch);

					if (removeInstructors.length > 0) {
						nameField.clear();
						rankField.clear();
						salaryField.clear();
						idField.clear();
						Alert removedAlert = new Alert(AlertType.CONFIRMATION);
						removedAlert.setTitle("Instructor removed");
						removedAlert.setContentText("Instructor removed with ID: " + id);
						removedAlert.showAndWait();
					} else {
						Alert notFoundAlert = new Alert(AlertType.ERROR);
						notFoundAlert.setTitle("Instructor Not Found");
						notFoundAlert.setContentText("No instructor found with ID: " + id);
						notFoundAlert.showAndWait();
					}
				} else {
					Alert emptyAlert = new Alert(AlertType.WARNING);
					emptyAlert.setTitle("Empty ID");
					emptyAlert.setContentText("Please enter an ID to search.");
					emptyAlert.showAndWait();
				}
			});
			Button updateBtn = new Button("Update");
			updateBtn.setOnAction(a -> {
				String id = idField.getText();
				if (!id.isEmpty()) {
					String updatedName = nameField.getText();
					Rank updatedRank = Rank.valueOf(rankField.getText());
					double updatedSalary = Double.parseDouble(salaryField.getText());

					Predicate<Person> idFound = s -> s.getId().equals(id);
					Person[] foundInstructor = PersonBag.getInstance().search(idFound);

					if (foundInstructor.length > 0) {
						Instructor instructor = (Instructor) foundInstructor[0];
						// update information based on the field
						if (!updatedName.isEmpty()) {
							instructor.setName(updatedName);
						}

						instructor.setRank(updatedRank);

						instructor.setSalary(updatedSalary);

						Alert updateAlert = new Alert(AlertType.INFORMATION);
						updateAlert.setTitle("Instructor Updated");
						updateAlert.setContentText("Instructor ID: " + id + " updated!");
						updateAlert.showAndWait();

						// update the fields after change
						nameField.setText(instructor.getName());
						rankField.setText(instructor.getRank().toString());
						salaryField.setText(String.valueOf(instructor.getSalary()));
					} else {
						Alert notFoundAlert = new Alert(AlertType.ERROR);
						notFoundAlert.setTitle("Student Not Found");
						notFoundAlert.setContentText("No student found with ID: " + id);
						notFoundAlert.showAndWait();
					}
				} else {
					Alert emptyAlert = new Alert(AlertType.WARNING);
					emptyAlert.setTitle("Empty ID");
					emptyAlert.setContentText("Please enter an ID to search.");
					emptyAlert.showAndWait();
				}
			});

			instructorPane.add(insertBtn, 0, 4);
			instructorPane.add(searchBtn, 1, 4);
			instructorPane.add(removeBtn, 2, 4);
			instructorPane.add(updateBtn, 3, 4);

			Button backBtn = new Button("Back");
			backBtn.setOnAction(b -> {
				primaryStage.setScene(initialScene);
				primaryStage.setTitle("Main Menu");
				primaryStage.show();

				// clear fields when button is pressed
				nameField.clear();
				rankField.clear();
				salaryField.clear();
			});

			// align back button
			instructorPane.add(backBtn, 0, 5);
			GridPane.setHalignment(backBtn, HPos.LEFT);

		});

		MenuItem displayBtn = new MenuItem("Display");
		displayBtn.setOnAction(e -> {
			ObservableList<Object> personList = FXCollections.observableArrayList();
			ListView<Object> personListView = new ListView<>(personList);

			for (Person p : PersonBag.getInstance().getAllPersons()) {
				personList.add(p.toString());
			}

			personListView.setItems(personList);

			VBox view = new VBox(10);
			view.getChildren().add(personListView);
			Scene personView = new Scene(view, 400, 400);
			primaryStage.setTitle("Data Base");
			primaryStage.setScene(personView);
			primaryStage.show();

		});

		optionsMenu.getItems().addAll(studentView, instructorView, displayBtn);

		menuBar.getMenus().addAll(fileMenu, optionsMenu);

	}

//	public void addFunctionalBtns(GridPane gridPane, Stage primaryStage) {
//		Button importBtn = new Button("Import");
//		importBtn.setOnAction(e -> {
//			FileChooser fileChooser = new FileChooser();
//			// default directory
//			File defaultDirectory = new File("/Users/jeterd/Documents");
//			fileChooser.setInitialDirectory(defaultDirectory);
//
//			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
//					new FileChooser.ExtensionFilter("All Files", "*.*"));
//
//			File file = fileChooser.showOpenDialog(primaryStage);
//			if (file != null) {
//				PersonBag.getInstance().importBoth(file.getPath());
//			}
//		});
//		Button searchBtn = new Button("Search");
//		searchBtn.setOnAction(e -> {
//
//		});
//		Button removeBtn = new Button("Remove");
//		removeBtn.setOnAction(e -> {
//
//		});
//		Button updateBtn = new Button("Update");
//		updateBtn.setOnAction(e -> {
//
//		});
//
//		gridPane.add(importBtn, 0, 4);
//		gridPane.add(searchBtn, 1, 4);
//		gridPane.add(removeBtn, 2, 4);
//		gridPane.add(updateBtn, 3, 4);
//	}

}
