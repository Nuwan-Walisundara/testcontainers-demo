package com.nuwan.testcontainersdemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.nuwan.testcontainersdemo.records.Album;
import com.nuwan.testcontainersdemo.records.Photo;

@RestController
@RequestMapping("/api")
public class AlbumController {
	
	  private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);
	  private final PhotoServiceClient photoServiceClient;

	  AlbumController(PhotoServiceClient photoServiceClient) {
	    this.photoServiceClient = photoServiceClient;
	  }
	  
	  @GetMapping("/albums/{albumId}")
	  public ResponseEntity<Album> getAlbumById(@PathVariable("albumId") Long albumId) {
	    try {
	      List<Photo> photos = photoServiceClient.getPhotos(albumId);
	      return ResponseEntity.ok(new Album(albumId, photos));
	    } catch (WebClientResponseException e) {
	      logger.error("Failed to get photos", e);
	      return new ResponseEntity<>(e.getStatusCode());
	    }
	  }

}
