package com.example.sweproject;

import java.util.ArrayList;

public class Team {

    private ArrayList<Machine> machines;
    private ArrayList<Member> members;
    private Admin admin;
    private ArrayList<Project> projects;
    private String name;

    // Constructor for Team class
    public Team(String name) {
        this.name = name;
        this.machines = new ArrayList<>();
        this.members = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    // add a machine to the team
    public void addMachine(Machine machine) { ///////// not complete /////////////
        machines.add(machine);
    }

    // Method to remove a machine from the team
    public void removeMachine(Machine machine) { ///////// not complete /////////////
        machines.remove(machine);
    }

    // add a member to the team
    public void addMember(Member member) {
        members.add(member);
        member.setTeam(this); // Set this team as the member's team
    }

    // set an admin for the team
    public void addAdmin(Admin admin) {
        this.admin = admin;
        admin.setTeam(this); // Set this team as the admin's team
    }

    // remove a member from the team
    public void removeMember(Member member) {
        members.remove(member);
    }

    // add a project to the team
    public void addProject(Project project) {
        projects.add(project);
    }

    // remove a project from the team
    public void removeProject(Project project) {
        projects.remove(project);
    }

    // Getter for machines
    public ArrayList<Machine> getMachines() {
        return machines;
    }

    // Getter for members
    public ArrayList<Member> getMembers() {
        return members;
    }

    // Getter for projects
    public ArrayList<Project> getProjects() {
        return projects;
    }

    // Getter for admin
    public Admin getAdmin() {
        return admin;
    }

    // Getter for team name
    public String getName() {
        return name;
    }
}