package fr.nogachi.dtos.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PhotoUpdateDTO {

    private Long id;
    private MultipartFile namephoto;
}
