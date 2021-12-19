package fr.nogachi.dtos.articledtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class articleUpdateDTO {

	private Long id;
	

	private String titre;
	

	private String contenu;
	

	private Date date;
	

	private long photo_idphoto;
	

	private String categorie_idcategorie;

}
