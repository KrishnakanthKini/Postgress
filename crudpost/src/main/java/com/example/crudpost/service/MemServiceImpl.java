package com.example.crudpost.service;

import com.example.crudpost.dao.MemberRepositoryImpl;
import com.example.crudpost.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemServiceImpl implements MemService {
    @Autowired
    public MemberRepositoryImpl memberRepository;

    @Override
    public Member addMember(Member member) {
        memberRepository.addMember(member);
        return member;

    }
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    @Override
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    @Override
    public void deleteMember(UUID uuid) {
        memberRepository.deleteMember(uuid);
    }
}
