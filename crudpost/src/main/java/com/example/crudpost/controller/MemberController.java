package com.example.crudpost.controller;
import com.example.crudpost.model.Member;
import com.example.crudpost.service.MemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemServiceImpl memberService;
    @PostMapping("/creates")
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/displays")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @DeleteMapping("/deletes/{uuid}")
    public void deleteMember(@PathVariable String uuid) {
        memberService.deleteMember(uuid);
    }
    @PostMapping("/updates")
    public void updateMember(@RequestBody Member member) {
        memberService.updateMember(member);
    }

}
