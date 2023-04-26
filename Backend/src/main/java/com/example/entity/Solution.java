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
    Issues issue;

    public Solution(long solutionId, String solution, Issues issue) {
        this.solutionId = solutionId;
        this.solution = solution;
        this.issue = issue;
    }

    public long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(long solutionId) {
        this.solutionId = solutionId;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }
}