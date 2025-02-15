package com.example.sweproject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;


public  class Controller  {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button addButton;
    @FXML
    private Button mee;
    @FXML
    private TextField memberName;
    @FXML
    private TextField machinereserveID;
    @FXML
    private TextField Year ;
    @FXML
    private TextField Month ;
    @FXML
    private TextField Day ;
    @FXML
    private TextField Hour ;
    @FXML
    private TextField Minute ;
    @FXML
    private TextField memberEmail;
    @FXML
    private TextField memberRi;
    @FXML
    private TextField researchID;
    @FXML
    private TextField TeamNAmeID;
    @FXML
    private TextField ProjectNameID;
    @FXML
    private TextField TeamToReserve;
    @FXML
    private TextField TeamToAssignWith;
    @FXML
    private TextField MachinetNameID;
    @FXML
    private Label checkIfteamIsAvalible;
    @FXML
    private Label checkIfteamIsAvalible2;
    @FXML
    private Label checkIfteamIsAvalible3;
    @FXML
    public ChoiceBox<String> teamCheckBox;
    public ArrayList<Object> members = new ArrayList<>();

    @FXML
    private Label sweTeamLabel1;
    @FXML
    private Label sweTeamLabel2;
    @FXML
    private Label sweTeamLabel3;
    @FXML
    private Label sweTeamLabel4;
    @FXML
    private Label sweTeamLabel5;
    BufferedWriter writer = new BufferedWriter(new FileWriter("l.txt",true));







    public boolean flag=true;

    public Controller() throws IOException {
    }


    public void switchToMember(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("memberPage.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddMachinePage(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("addMachinePage.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToReserve(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("reserveFunction.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdmin(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMain(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("KFUPMProject.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTeamPage1(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("teamPage1.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTeamPage2(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("teamPage2.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddMemberPage(ActionEvent event) throws Exception {

        root = FXMLLoader.load(getClass().getResource("AddMemberPage.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddTeamFunction(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("addTeamFunction.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddProjectPage(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("addProjectPage.fxml"));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public void addChoices(){
        if (flag){
            teamCheckBox.getItems().add("swe team");
            teamCheckBox.getItems().add("cs team");
            flag=false;
        }
//
    }


    public void refresh() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("l.txt"));
            sweTeamLabel1.setText(reader.readLine());
            sweTeamLabel2.setText(reader.readLine());
            sweTeamLabel3.setText(reader.readLine());
            sweTeamLabel4.setText(reader.readLine());
            sweTeamLabel5.setText(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void addTeam(){
        kfupmProject.page.newTeam(TeamNAmeID.getText());
        TeamNAmeID.clear();
        System.out.println(kfupmProject.page.teams.get(0).getName());
    }

    public void addProject(){
        System.out.println(kfupmProject.page.searchTeam(TeamToAssignWith.getText()));
        System.out.println(TeamToAssignWith.getText());
        System.out.println(kfupmProject.page.teams.get(0));
        if (kfupmProject.page.searchTeam(TeamToAssignWith.getText())){
            checkIfteamIsAvalible.setText("Good");
            checkIfteamIsAvalible.setStyle("-fx-text-fill: green;");
        }
        else {
            checkIfteamIsAvalible.setText("NO you IDIOT!");
            checkIfteamIsAvalible.setStyle("-fx-text-fill: red;");
        }


    }
    public void addMember(){
        kfupmProject.page.newMember(memberEmail.getText(),memberName.getText());
        System.out.println(kfupmProject.page.searchTeam(TeamToAssignWith.getText()));
        System.out.println(TeamToAssignWith.getText());
        System.out.println(kfupmProject.page.teams.get(0));
        if (kfupmProject.page.searchTeam(TeamToAssignWith.getText())){
            checkIfteamIsAvalible.setText("Good");
            checkIfteamIsAvalible.setStyle("-fx-text-fill: green;");
        }
        else {
            checkIfteamIsAvalible.setText("NO you IDIOT!");
            checkIfteamIsAvalible.setStyle("-fx-text-fill: red;");
        }


    }
    public void addMachine(){
        kfupmProject.page.newMachine(MachinetNameID.getText(),researchID.getText());
        MachinetNameID.clear();
        researchID.clear();
        System.out.println("/////");
    }

    public void reserve(){

        Team team;
        Machine machine;
        if (kfupmProject.page.searchTeam(TeamToReserve.getText())){
            checkIfteamIsAvalible.setText("Good");
            checkIfteamIsAvalible.setStyle("-fx-text-fill: green;");
            team = kfupmProject.page.searchTeamByName(TeamToReserve.getText());
        }
        else {
            checkIfteamIsAvalible.setText("NO");
            checkIfteamIsAvalible.setStyle("-fx-text-fill: red;");
            team = null;
        }
        if (kfupmProject.page.searchMachine(machinereserveID.getText())){
            checkIfteamIsAvalible2.setText("Good");
            checkIfteamIsAvalible2.setStyle("-fx-text-fill: green;");
            machine = kfupmProject.page.searchMachineByName(machinereserveID.getText());
        }
        else {
            checkIfteamIsAvalible2.setText("NO you IDIOT!");
            checkIfteamIsAvalible2.setStyle("-fx-text-fill: red;");
            machine = null;
        }


        if (machine.reserveMachine(Integer.parseInt(Year.getText()),Integer.parseInt(Month.getText()),Integer.parseInt(Day.getText()),Integer.parseInt(Hour.getText()),Integer.parseInt(Minute.getText()), team)){
            checkIfteamIsAvalible3.setText("Good");
            checkIfteamIsAvalible3.setStyle("-fx-text-fill: green;");

        }
        else {
            checkIfteamIsAvalible3.setText("Conflict");
            checkIfteamIsAvalible3.setStyle("-fx-text-fill: red;");
        }

    }


}
