package fr.nogachi.dtos.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ArticleSaveDTO {

	private String title;
	

	private String content;
	

	private Date date;
	

	private Long photo_idphoto;
	

	private Long category_idcategory;

}