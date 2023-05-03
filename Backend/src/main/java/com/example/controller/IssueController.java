package com.example.controller;

import java.util.List;
import com.example.entity.Issues;
import com.example.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/api")
public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

    @GetMapping
    public List<Issues> getAllIssues() {
        return issueRepository.findAll();
    }

    @PostMapping("/issues")
    public ResponseEntity<Issues> createIssue(@RequestBody Issues issue) {
        Issues newIssue = issueRepository.save(issue);
        return new ResponseEntity<>(newIssue, HttpStatus.CREATED);
    }
}