package com.example.crudpost.service;
import com.example.crudpost.model.Member;

import java.util.List;
import java.util.UUID;

public interface MemService {

    public List<Member> getAllMembers();

    public Member addMember(Member member);

    public void updateMember(Member member);

    public void deleteMember(String uuid);

}
