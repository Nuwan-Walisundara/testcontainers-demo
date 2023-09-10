package com.nuwan.testcontainersdemo;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.nuwan.testcontainersdemo.records.Photo;

public interface PhotoServiceClient {
	@GetExchange("/albums/{albumId}/photos")
	  List<Photo> getPhotos(@PathVariable("albumId") Long albumId);
}
