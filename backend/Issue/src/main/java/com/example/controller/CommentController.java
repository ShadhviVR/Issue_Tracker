
package com.example.controller;

import com.example.dto.CommentRequest;
import com.example.entity.Comment;
import com.example.entity.Issue;
import com.example.repository.CommentRepository;
import com.example.repository.IssueRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class CommentController {
    
    
    @Autowired
    IssueRepository issueRep;
   
    @Autowired
    CommentRepository commentRep;
    
    
    
      @GetMapping("/comments")
    public List<Comment> getAllComments() {

        return commentRep.findAll();
    }
    
    
    
    ////CREATE COMMENT 
    @PostMapping("/issues/{id}/comments")
public ResponseEntity<Comment> createComment(@PathVariable("id") Long id, @RequestBody CommentRequest commentRequest) {
    // Récupérer l'issue parente
    Optional<Issue> optionalIssue = issueRep.findById(id);
    if (optionalIssue.isPresent()) {
        Issue issue = optionalIssue.get();
        
        // Vérifier que le contenu du commentaire n'est pas vide
        if (commentRequest.getText() == null || commentRequest.getText().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        // Créer un nouveau commentaire
        Comment comment = new Comment();
        comment.setIssue(issue);
        comment.setText(commentRequest.getText());
        
        // Enregistrer le commentaire dans la base de données
        try {
            Comment createdComment = commentRep.save(comment);
            
            // Ajouter le commentaire à l'issue parente
            issue.getComments().add(createdComment);
            issueRep.save(issue);
            
            // Retourner une réponse avec le commentaire créé
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
        } catch (Exception e) {
            // Retourner une réponse avec un code d'erreur approprié si l'enregistrement du commentaire échoue
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } else {
        // Retourner une réponse avec un code d'erreur approprié si l'issue n'existe pas
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    

}
