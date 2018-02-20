/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.dao;

import appmembership.dto.Member;
import java.util.List;

/**
 *
 * @author eriklarson-laptop
 */
public interface AppMembershipDao {
    
    Member addMember(String memberId, Member member);
    
    List<Member> getAllMembers();
    
    Member getMember(String memberId);
    
    Member removeMember(String memberId);
    
}
