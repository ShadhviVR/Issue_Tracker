/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author fizak
 */
@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueId;

    private String label;
    private String issue;
    private Date date;


   /* on spécifie que chaque instance de Issues peut avoir plusieurs instances de Solution
   (relation OneToMany), que le champ solutions est mappé sur la propriété issue de la classe
   Solution (grâce à l'attribut mappedBy), et que la suppression d'une instance de Issues
   entraîne la suppression de toutes les instances de Solution associées
   (grâce à l'attribut cascade avec la valeur CascadeType.ALL). L'attribut orphanRemoval est
   également spécifié pour indiquer que les instances de Solution orphelines
   (c'est-à-dire sans référence à une instance de Issues) doivent être supprimées.*/
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment = new ArrayList<>();

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private User createdBy;

    public Issue(  String label, String issue, Date date) {

        this.label = label;
        this.issue = issue;
        this.date = date;
      //  this.createdBy = createdBy;
    }


    public Issue() {

    }

    public long getIssueId() {
        return issueId;
    }

    public String getLabel() {
        return label;
    }

    public String getIssue() {
        return issue;
    }

    public Date getDate() {
        return date;
    }


    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }



    public void setLabel(String label) {
        this.label = label;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
