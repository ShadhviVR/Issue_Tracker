package com.example.entity;

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

@Entity
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueId;
    private  long userID;
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
    private List<Solution> solutions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private User createdBy;

    public Issues(long issueId, long userID, String label, String issue, Date date, User createdBy) {
        this.issueId = issueId;
        this.userID = userID;
        this.label = label;
        this.issue = issue;
        this.date = date;
        this.createdBy = createdBy;
    }

    public Issues() {

    }

    public long getIssueId() {
        return issueId;
    }

    public long getUserID() {
        return userID;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public void setUserID(long userID) {
        this.userID = userID;
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

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}