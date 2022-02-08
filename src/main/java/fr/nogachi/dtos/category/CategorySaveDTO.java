package fr.nogachi.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategorySaveDTO {
    private Long id;
    private String namecategory;
}
