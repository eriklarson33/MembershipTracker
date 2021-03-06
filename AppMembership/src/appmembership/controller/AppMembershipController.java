/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.controller;

import appmembership.dao.AppMembershipDao;
import appmembership.dao.AppMembershipDaoException;
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
    
    /* Declarations of member fields for Dependency Injection: */
    AppMembershipView view;
    AppMembershipDao dao;
    
    /* 
    Create a constructor for the class to use Constructor Injection for DI 
    */
    /* 
    Creating this constructor makes it so that the Controller isn't 
    responsible for injecting the correct implementation of the view or dao.
    */
    public AppMembershipController(AppMembershipView view, AppMembershipDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
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
        } catch (AppMembershipDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createMember() throws AppMembershipDaoException {
        view.displayCreateMemberBanner();
        Member newMember = view.getNewMemberInfo();
        dao.addMember(newMember.getMemberId(), newMember);
        view.displayCreateSuccessBanner();
    }
    
    private void listMembers() throws AppMembershipDaoException {
        view.displayShowAllMembersBanner();
        List<Member> memberList = dao.getAllMembers();
        view.displayMemberList(memberList);
    }
    
    private void viewMember() throws AppMembershipDaoException {
        view.displayDisplayMemberBanner();
        String memberId = view.getMemberIdChoice();
        Member member = dao.getMember(memberId);
        view.displayMember(member);
    }
    
    private void removeMember() throws AppMembershipDaoException {
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
