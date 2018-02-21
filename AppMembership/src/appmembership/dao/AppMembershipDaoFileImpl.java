/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.dao;

import appmembership.dto.Member;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author eriklarson-laptop
 */
public class AppMembershipDaoFileImpl implements AppMembershipDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, Member> members = new HashMap();

    /* The following, loadRoster(), loads info from the file, ROSTER_FILE. */
    private void loadRoster() throws AppMembershipDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new AppMembershipDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Member currentMember = new Member(currentTokens[0]);
            currentMember.setFirstName(currentTokens[1]);
            currentMember.setLastName(currentTokens[2]);
            currentMember.setAccessLevel(currentTokens[3]);
            members.put(currentMember.getMemberId(), currentMember);
        }
        scanner.close();
    }

    /* The following, writeRoster(), loads data to the file, ROSTER_FILE. */
    private void writeRoster() throws AppMembershipDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new AppMembershipDaoException("Could not save student data.", e);
        }

        List<Member> memberList = this.getAllMembers();
        for (Member currentMember : memberList) {
            out.println(currentMember.getMemberId() + DELIMITER
                    + currentMember.getFirstName() + DELIMITER
                    + currentMember.getLastName() + DELIMITER
                    + currentMember.getAccessLevel());
            out.flush();
        }
        out.close();
    }

    @Override
    public Member addMember(String memberId, Member member) 
            throws AppMembershipDaoException {
        Member newMember = members.put(memberId, member);
        writeRoster();
        return newMember;
    }

    @Override
    public List<Member> getAllMembers()
            throws AppMembershipDaoException {
        loadRoster();
        return new ArrayList<Member>(members.values());
    }

    @Override
    public Member getMember(String memberId) 
            throws AppMembershipDaoException {
            loadRoster();
            return members.get(memberId);
    }

    @Override
    public Member removeMember(String memberId) 
    throws AppMembershipDaoException {
        Member removedMember = members.remove(memberId);
        writeRoster();
        return removedMember;
    }

}
