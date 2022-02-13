package fr.nogachi.dtos.article;

import fr.nogachi.entities.Category;
import fr.nogachi.entities.Photo;
import fr.nogachi.enumeration.TypesCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ArticleSaveDTO {

	private String title;
	

	private String content;
	

	private LocalDate date;


	private TypesCard nametype;

	private String namephoto;
	

	private String namecategory;

}
