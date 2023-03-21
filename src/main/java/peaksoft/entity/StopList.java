package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "stop_lists")
@NoArgsConstructor
@ToString
public class StopList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stop_list_seq")
    @SequenceGenerator(name = "stop_list_seq")
    private Long id;
    private String reason;
    private LocalDate date;

    @OneToOne(mappedBy = "stopList", cascade = CascadeType.ALL, orphanRemoval = true)
    private MenuItem menuItem;

}