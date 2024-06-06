package bookstore_group3.Library_API.reviewFolder;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    private String _id;
    private LocalDate ratedOn;
    private int starRating;
}