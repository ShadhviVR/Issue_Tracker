
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueId
    private  long userID
    private String label;
    private String issue;
    private Date date;
    User createdBy;
    private List<Solution> solutions = new ArrayList<>();

    public Issues(long issueId, long userID, String label, String issue, Date date, User createdBy) {
        this.issueId = issueId;
        this.userID = userID;
        this.label = label;
        this.issue = issue;
        this.date = date;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "created_by_user_id", nullable = false)
        this.createdBy = createdBy;
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