package com.kucw.security.controller;


import com.kucw.security.dao.MemberDao;
import com.kucw.security.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberDao memberDao;

    @PostMapping("/register")
    public Member register(@RequestBody Member member) {
        //省略參數的檢查(ex: email是否被註冊)

        //在資料庫中插入member的數據
        Integer memberId = memberDao.createMember(member);

        return memberDao.getMemberById(memberId);
    }
}
