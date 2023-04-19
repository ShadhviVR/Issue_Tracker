import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long solutionId
    private String solution;

}