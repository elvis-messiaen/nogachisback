package fr.nogachi.repositories;

import fr.nogachi.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Photo findById(int id);

    public Photo save(Photo photo);
}
