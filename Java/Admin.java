package com.example.sweproject;

public class Admin extends Member {

    // Constructor to create an Admin with a team
    public Admin(String email, String name, Team team) {
        super(email, name, team);
    }

    // Constructor to create an Admin without a team
    public Admin(String email, String name) {
        super(email, name);
    }



    // throws Exception if the project with the same name already exists in the team.

    public void assignProject(Team team, Project project) throws Exception {
        // Iterate through existing projects in the team
        for (Project existingProject : team.getProjects()) {
            // Check for project name duplication
            if (existingProject.getName().equals(project.getName())) {
                throw new Exception("Project with the same name is already assigned to this team.");
            }
        }

        // Add project to the team if no duplication found
        team.addProject(project);
    }


    // throws Exception if the member is already part of the team.

    public void assignTeam(Member member, Team team) throws Exception {
        // Check if the member is already part of the team
        if (team.getMembers().contains(member)) {
            throw new Exception("Member is already part of this team.");
        }

        // Add member to the team
        team.addMember(member);
    }

    // Overrides the setTeam method from the Member class
    public void setTeam(Team team) {
        super.setTeam(team);
    }
}