package fr.nogachi.dtos.article;

import fr.nogachi.entities.Category;
import fr.nogachi.entities.Photo;
import fr.nogachi.enumeration.TypesCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ArticleUpdateDTO {

	private Long id;
	

	private String title;
	

	private String content;
	

	private Date date;


	private Photo namephoto;

	private TypesCard nametype;


	private Category namecategory;

}
