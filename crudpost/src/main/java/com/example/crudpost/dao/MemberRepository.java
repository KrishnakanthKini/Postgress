package com.example.crudpost.dao;

import com.example.crudpost.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemberRepository {
 public List<Member> getAllMembers();

    public void addMember(Member member);

   public void updateMember(Member member);

  public void deleteMember(String memberId);
}
