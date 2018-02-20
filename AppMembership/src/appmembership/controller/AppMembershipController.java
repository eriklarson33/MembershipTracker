/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.controller;

import appmembership.dao.AppMembershipDao;
import appmembership.dao.AppMembershipDaoImpl;
import appmembership.dto.Member;
import appmembership.ui.AppMembershipView;
import appmembership.ui.UserIO;
import appmembership.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author eriklarson-laptop
 */
public class AppMembershipController {
    
    AppMembershipView view = new AppMembershipView();
    AppMembershipDao dao = new AppMembershipDaoImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listMembers();
                    break;
                case 2:
                    createMember();
                    break;
                case 3:
                    viewMember();
                    break;
                case 4:
                    removeMember();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createMember() {
        view.displayCreateMemberBanner();
        Member newMember = view.getNewMemberInfo();
        dao.addMember(newMember.getMemberId(), newMember);
        view.displayCreateSuccessBanner();
    }
    
    private void listMembers() {
        view.displayShowAllMembersBanner();
        List<Member> memberList = dao.getAllMembers();
        view.displayMemberList(memberList);
    }
    
    private void viewMember() {
        view.displayDisplayMemberBanner();
        String memberId = view.getMemberIdChoice();
        Member member = dao.getMember(memberId);
        view.displayMember(member);
    }
    
    private void removeMember() {
        view.displayRemoveMemberBanner();
        String memberId = view.getMemberIdChoice();
        dao.removeMember(memberId);
        view.displayRemoveSuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
