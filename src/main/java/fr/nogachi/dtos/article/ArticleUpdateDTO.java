package fr.nogachi.dtos.article;

import fr.nogachi.entities.Category;
import fr.nogachi.entities.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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


	private Category namecategory;

}
