package com.example.crudpost.dao;

import com.example.crudpost.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class MemberRepositoryImpl implements  MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Member> getAllMembers() {
        String query = "SELECT * from member";
        List<Member> members = jdbcTemplate.query (query,
                new BeanPropertyRowMapper(Member.class));
        return members;
    }

    @Override
    public void addMember(Member member) {

        String query = "INSERT INTO member( memberId, personId,  prefix,  firstName,  middleName,  lastName, suffix,  dob, gender,  ssn, horizonEmployeeIndicator) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,member.getMemberId(),member.getPersonId(),member.getPrefix(),member.getFirstName(),member.getMiddleName(),member.getLastName(),member.getSuffix(),member.getDob(),member.getGender(),member.getSsn(),true);

    }

    @Override
    public void deleteMember(String memberId) {

        String query = "DELETE FROM member WHERE memberId=?";
        jdbcTemplate.update(query, memberId);
    }

    @Override
    public void updateMember(Member member) {
        String query="update member set prefix='"+member.getPrefix()+"', firstName='"+member.getFirstName()+"',middleName='"+member.getMiddleName()+"',lastName='"+member.getLastName()+"',suffix='"+member.getSuffix()+"',dob='"+member.getDob()+"',gender='"+member.getGender()+"',ssn='"+member.getSsn()+"' where memberId='"+member.getMemberId()+"' ";
        jdbcTemplate.update(query);
    }
}
