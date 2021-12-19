package fr.nogachi.dtos.categoriedtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategorieUpdateDTO {
    private Long id;
    private String nom;
}
