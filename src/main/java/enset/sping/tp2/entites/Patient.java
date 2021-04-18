package enset.sping.tp2.entites;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name="PATIENTS")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NOM",length = 25)
    @NotNull
    @Size(min=5,max=15)
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateNaissance;
     @DecimalMin("4")
    private int score;
    private Boolean malade=false;
}
