/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

import com.example.entity.Issue;
import com.example.entity.Label;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository  extends JpaRepository<Issue,Long>{

    public  List<Issue> findByTitleContainingIgnoreCase(String title);
     
    public List<Issue> findByTitleContainingIgnoreCaseAndLabel(String title, Label label);

    public List<Issue> findByLabel(Label label);
    
}
