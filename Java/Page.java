package com.example.sweproject;

import java.util.ArrayList;

public class Page {
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    public ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();

    private ArrayList<Machine> machines= new ArrayList<>();

    public Admin newAdmin(String email, String name){
        Admin admin = new Admin(email, name);
        admins.add(admin);
        return admin;
    }

    public Member newMember(String email, String name){
        Member member = new Member(email, name);
        members.add(member);
        return member;
    }
    public Machine newMachine(String name ,String researchInterest) {
        Machine machine = new Machine(name ,researchInterest);
        machines.add(machine);
        return machine;
    }

    public Team newTeam(String name){
        Team team = new Team(name);
        teams.add(team);
        return team;
    }

    public Project newProject(String name, Team team){
        Project project = new Project(name, team);
        projects.add(project);
        return project;
    }

    // Search methods
    public boolean searchAdmin(String name, String email){
        return admins.stream().anyMatch(admin -> admin.getName().equals(name) || admin.getEmail().equals(email));
    }

    public boolean searchMember(String name, String email){
        return members.stream().anyMatch(member -> member.getName().equals(name) || member.getEmail().equals(email));
    }

    public boolean searchMachine(String name) {
        return machines.stream().anyMatch(machine -> machine.getName().equals(name));
    }



    public boolean searchTeam(String name){
        return teams.stream().anyMatch(team -> team.getName().equals(name));
    }

    public boolean searchProject(String name){
        return projects.stream().anyMatch(project -> project.getName().equals(name));
    }


    public Machine searchMachineByName(String name) {
        for (Machine machine : machines) {
            if (machine.getName().equals(name)) {
                return machine;
            }
        }
        return null; // or throw an exception if you prefer
    }

    public Team searchTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null; // or throw an exception if you prefer
    }


}
