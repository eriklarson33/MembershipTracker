/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.dao;

import appmembership.dto.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eriklarson-laptop
 */
public class AppMembershipDaoImpl implements AppMembershipDao {
    
    private Map<String, Member> members = new HashMap();

    @Override
    public Member addMember(String memberId, Member member) {
        Member newMember = members.put(memberId, member);
        return newMember;
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<Member> (members.values());
    }

    @Override
    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    @Override
    public Member removeMember(String memberId) {
        Member removeMember = members.remove(memberId);
        return removeMember;
    }
    
}
