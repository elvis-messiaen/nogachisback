package fr.nogachi.dtos.article;

import fr.nogachi.entities.Category;
import fr.nogachi.entities.Photo;
import fr.nogachi.enumeration.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ArticleSaveDTO {

	private String title;
	

	private String content;
	

	private LocalDate date;


	private String nametype;

	private Photo namephoto;
	

	private Category namecategory;

}
