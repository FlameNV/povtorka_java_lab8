package ua.lviv.iot.restapp.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.restapp.dataaccess.BirdRepository;
import ua.lviv.iot.restapp.model.Bird;

@Service
public class BirdService {
  @Autowired
  private BirdRepository birdRepository;
  
  public Bird createBird(Bird bird) {
    return birdRepository.save(bird);
  }

  public Bird deleteBird(Integer birdId) {
    Bird oldOption = birdRepository.findById(birdId).orElse(null);
    if (oldOption != null) {
    	birdRepository.deleteById(birdId);
    }
    return oldOption;
  }
  
  public Bird getBird(Integer birdId) {
    return birdRepository.findById(birdId).get();
  }

  public List<Bird> getAllBirds() {
    return birdRepository.findAll();
  }

  public Bird updateBird(Integer birdId, Bird bird) {
    Bird oldOption = null;
    Bird temporaryOption = birdRepository.findById(birdId).orElse(null);
    if (temporaryOption != null) {
    	oldOption = new Bird();
    	BeanUtils.copyProperties(temporaryOption, oldOption);
    	birdRepository.save(bird);
    }
    return oldOption;
  }

}