package cn.mauth.issue.security.agent.controller;

import cn.mauth.issue.common.dao.SysLogLoginDao;
import cn.mauth.issue.common.entity.SysLogLogin;
import cn.mauth.issue.util.annotation.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sysLogLogins")
public class ServerController {

    @Autowired
    private SysLogLoginDao dao;

    @GetMapping
    @Api("查询所有登录日志")
    public List<SysLogLogin>  getAll(){
        return dao.findAll();
    }
}
