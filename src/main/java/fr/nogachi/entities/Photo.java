package fr.nogachi.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namephoto;

    @ManyToOne
    private Article article ;
}
