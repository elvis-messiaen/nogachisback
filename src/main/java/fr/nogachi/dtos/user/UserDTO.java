package fr.nogachi.dtos.user;


import fr.nogachi.entities.Article;
import fr.nogachi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private Role role;
    private List<Article> articleList;
}
