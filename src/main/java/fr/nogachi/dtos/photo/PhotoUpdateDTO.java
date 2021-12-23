package fr.nogachi.dtos.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PhotoUpdateDTO {

    private Long id;
    private String nom;
}
