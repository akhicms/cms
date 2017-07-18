package com.spring.controller;

import java.util.List;

import com.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.dto.ContentDTO;

/**
 * Created by mvani on 03/07/17.
 */
@RestController
public class ContentRestController {

	@Autowired
	private ContentService contentService;


	@RequestMapping(value = "/contents", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getContentList()
	{
		List<ContentDTO> contentDTOList =  contentService.getAllContents();
		if(contentDTOList == null){
			return new ResponseEntity("No Content List found ", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(contentDTOList, HttpStatus.OK);
	}

	@RequestMapping(value = "/contents/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity getContentById(@PathVariable("id") Long id) {

		ContentDTO contentDTO = contentService.getContentById(id);
		if (contentDTO == null) {
			return new ResponseEntity("No Content found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(contentDTO, HttpStatus.OK);
	}


	@RequestMapping(value = "/contents/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity deleteContentById(@PathVariable("id") Long id) {


		if (null == contentService.deleteContent(id)) {
			return new ResponseEntity("No Content Object found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}


	@RequestMapping(value = "/contents/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateContentById(@PathVariable("id") Long id,@RequestBody ContentDTO contentDTO) {
		contentService.updateContent(id,contentDTO);
		return new ResponseEntity(id, HttpStatus.OK);
	}


	@RequestMapping(value = "/contents", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity createContent(@RequestBody ContentDTO contentDTO) {
		contentService.createContent(contentDTO);
		return new ResponseEntity(contentDTO, HttpStatus.OK);


	}

}