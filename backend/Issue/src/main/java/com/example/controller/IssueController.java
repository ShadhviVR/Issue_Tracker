
package com.example.controller;

import com.example.entity.Issue;
import com.example.entity.Label;

import com.example.entity.User;
import com.example.repository.IssueRepository;
import com.example.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class IssueController {
    
    @Autowired
    IssueRepository issueRep;
   
    @Autowired
    UserRepository userRep;

  @GetMapping("/issues")
    public List<Issue> getAllIssues() {

        return issueRep.findAll();
    }
    
 /// CREATE ISSUE
   @PostMapping("/issues")
  public ResponseEntity<Issue> createIssueWithRandomUser(@RequestBody Issue issue) {
    // Créer un nouvel utilisateur aléatoire
    User user = new User();
    user.setCode(generateRandomCode()); // Générer un code aléatoire pour l'utilisateur
    user.setName(generateRandomName()); // Générer un nom aléatoire pour l'utilisateur
    
    // Enregistrer l'utilisateur dans la base de données
    userRep.save(user);
    
    // Associer l'utilisateur à l'issue
    issue.setUser(user);
    
    
    // Enregistrer l'issue dans la base de données
    Issue newIssue = issueRep.save(issue);
    
    // Retourner une réponse avec l'issue nouvellement créée
    return new ResponseEntity<>(newIssue, HttpStatus.CREATED);
}



///FILTRE WITH TITLE 
@GetMapping("/issues/filtre")
public ResponseEntity<List<Issue>> searchIssues(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) Label label
    ) {
    List<Issue> issues;
    
    if (title != null && label != null) {
        // Recherche des issues par titre et label
        issues = issueRep.findByTitleContainingIgnoreCaseAndLabel(title, label);
    } else if (title != null) {
        // Recherche des issues par titre
        issues = issueRep.findByTitleContainingIgnoreCase(title);
    } else if (label != null) {
        // Recherche des issues par label
        issues = issueRep.findByLabel(label);
    } else {
        // Récupération de toutes les issues si aucun filtre n'est appliqué
        issues = issueRep.findAll();
    }
    
    // Retourner une réponse avec les issues trouvées
    return new ResponseEntity<>(issues, HttpStatus.OK);
}

////UPDATE ISSUE 
@PutMapping("/issues/{id}")
public ResponseEntity<Issue> updateIssue(@PathVariable Long id, @RequestBody Issue issueUpdates) {
    if (id == null) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    Optional<Issue> optionalIssue = issueRep.findById(id);
    if (optionalIssue.isPresent()) {
        Issue issue = optionalIssue.get();
        
        // Vérifier que l'issue mise à jour contient des valeurs valides
        if (issueUpdates.getTitle() != null) {
            issue.setTitle(issueUpdates.getTitle());
        }
        if (issueUpdates.getDescription() != null) {
            issue.setDescription(issueUpdates.getDescription());
        }
        if (issueUpdates.getLabel() != null) {
            issue.setLabel(issueUpdates.getLabel());
        }
        
        issueRep.save(issue);
        return new ResponseEntity<>(issue, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

private String generateRandomCode() {
        int length = 8; // Longueur du code généré
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // Génère un chiffre aléatoire entre 0 et 9
        }
        return sb.toString();
    }

private String generateRandomName() {
    return RandomStringUtils.randomAlphabetic(10);
}
    
}
