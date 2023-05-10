/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;
import java.util.List;
import com.example.demo.entity.Issue;
import com.example.demo.repository.IssueRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author fizak
 */

@Controller()
@RequestMapping("/api")
//@EnableJpaRepositories("com.example.demo.repository")
public class IssueController {
    
   //@Autowired
    private IssueRepository issueRepository;

    @GetMapping
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @PostMapping("/issues")
    public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
        Issue newIssue = issueRepository.save(issue);
        return new ResponseEntity<>(newIssue, HttpStatus.CREATED);
    }
    
    
}
