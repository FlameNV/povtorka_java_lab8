package ua.lviv.iot.restapp.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.restapp.business.BirdService;
import ua.lviv.iot.restapp.model.Bird;

@RequestMapping("/birds")
@RestController
public class BirdController {
	  private Map<Integer, Bird> birds = new HashMap<>();
	  private AtomicInteger idAccount = new AtomicInteger();
	  @Autowired
	  private BirdService birdService;
	  
	  @GetMapping
	  public List<Bird> getAllBirds() {
	    return new LinkedList<Bird>(birds.values());
	  }

	  @GetMapping(path = "/{id}")
	  public Bird getBird(@PathVariable("id") Integer birdId) {
	    System.out.println(birdId);
	    return birds.get(birdId);
	  }

	  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	  public Bird createBird(@RequestBody Bird bird) {
		birdService.createBird(bird);
	    bird.setId(idAccount.incrementAndGet());
	    birds.put(bird.getId(), bird);
	    return bird;
	  }

	  @DeleteMapping(path = "/{id}")
	  public ResponseEntity<Bird> deleteBird(@PathVariable("id") Integer birdId) {
	   HttpStatus status = birds.remove(birdId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
	   return ResponseEntity.status(status).build();

	  }
	  @PutMapping(path= "/{id}")
	  public Bird updateBird(final @PathVariable ("id") Integer birdId, 
	      final @RequestBody Bird bird) {
	    bird.setId(birdId);
	    return birds.put(birdId, bird);
	  }
}
