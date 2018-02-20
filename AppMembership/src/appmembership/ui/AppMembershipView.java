/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.ui;

import appmembership.dto.Member;
import java.util.List;

/**
 *
 * @author eriklarson-laptop
 */
public class AppMembershipView {
    
    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. List Member ID's");
            io.print("2. Create New Member");
            io.print("3. View a Member");
            io.print("4. Remove a Member");
            io.print("5. Exit");
            
            return io.readInt("Please select from the above choices.", 1, 5);
    }
    
    public Member getNewMemberInfo() {
        String memberId = io.readString("Please enter the Member ID.");
        String firstName = io.readString("Please enter the First Name.");
        String lastName = io.readString("Please enter the Last Name.");
        String accessLevel = io.readString("Please enter the Access Level.");
        
        Member currentMember = new Member(memberId);
        currentMember.setFirstName(firstName);
        currentMember.setLastName(lastName);
        currentMember.setAccessLevel(accessLevel);
        return currentMember;
    }
    
    public void displayMemberList(List<Member> memberList) {
        for (Member currentMember : memberList) {
            io.print(currentMember.getMemberId() + ": " 
            + currentMember.getFirstName() + ": "
            + currentMember.getLastName());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayMember(Member member) {
        if (member != null) {
            io.print(member.getMemberId());
            io.print(member.getFirstName() + " " + member.getLastName());
            io.print(member.getAccessLevel());
            io.print("");
        } else {
            io.print("No such member exists");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayCreateMemberBanner() {
        io.print("=== Create Member ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("Member successfully created.  Please hit enter to continue.");
    }
    
    public void displayShowAllMembersBanner() {
        io.print("=== Display All Members ===");
    }
    
    public void displayDisplayMemberBanner() {
        io.print("=== Display Member ===");
    }
    
    public void displayRemoveMemberBanner() {
        io.print("=== Remove Member ===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed.  Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public String getMemberIdChoice() {
        return io.readString("Please Enter the Member ID.");
    }
    
}
