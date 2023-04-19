
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueId
    private  long userID
    private String label;
    private String issue;
    private Date date;
}