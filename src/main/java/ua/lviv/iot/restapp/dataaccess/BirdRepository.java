package ua.lviv.iot.restapp.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.restapp.model.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer>{

}
