package com.spring.service;

import com.spring.dto.ContentDTO;
import com.spring.model.Contenet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.spring.dao.ContentDao;

/**
 * Created by mvani on 03/07/17.
 */
@Service
public class ContentService {


    @Autowired
    private ContentDao contentDao;

    /**
     * Get all contents
     *
     * @return
     */
    public List<ContentDTO> getAllContents() {
        List<ContentDTO> contenets = new ArrayList();

        List < Contenet > content =  contentDao.findAll();

        if(content != null) {
            ContentDTO contentDTO = null;
            for (Contenet c: content){
                 contentDTO = new ContentDTO();
                contentDTO.setId(c.getId());
                contentDTO.setName(c.getName());
                contentDTO.setDisplayName(c.getDisplayName());
                contentDTO.setContent(new String(c.getContent()));
                contentDTO.setCreatedDate(c.getCreatedDate());
                contentDTO.setStatus(c.getStatus());
                contentDTO.setVersion(c.getVersion());

                contenets.add(contentDTO);
            }
        }

        return contenets;
    }

    /**
     * Get content by contentId
     *
     * @param id
     * @return
     */
    public ContentDTO getContentById(long id) {

        Contenet contenet = contentDao.find(id);
        ContentDTO contentDTO = new ContentDTO();
        if(contenet != null){
                contentDTO.setId(contenet.getId());
                contentDTO.setName(contenet.getName());
                contentDTO.setDisplayName(contenet.getDisplayName());
                contentDTO.setContent(new String(contenet.getContent()));
                contentDTO.setCreatedDate(contenet.getCreatedDate());
                contentDTO.setStatus(contenet.getStatus());
                contentDTO.setVersion(contenet.getVersion());

        }

        return contentDTO;
    }

    /**
     *
     * Delete content by contentId
     *
     * @param id
     * @return
     */
    public Long deleteContent(long id) {

        Contenet contenet =  contentDao.find(id);
        if(contenet != null){
            contentDao.deleteContent(id);
            return id;
        }
            return null;

    }

    /**
     * update content by contentId
     *
     * @param id
     * @param contentDTO
     */
    public void updateContent(long id,ContentDTO contentDTO) {

        Contenet contenet =  contentDao.find(id);
        if(contenet != null){

            contenet.setName(contentDTO.getName());
            contenet.setDisplayName(contentDTO.getDisplayName());
            contenet.setContent(contentDTO.getContent().getBytes());
            contenet.setUpdatedDate(new Date());

            contentDao.updateContent(id,contenet);
        }

    }


    /**
     * create content
     *
     * @param contentDTO
     */
    public void createContent(ContentDTO contentDTO) {
        Contenet contenet = new Contenet();

            contenet.setId(contentDTO.getId());
            contenet.setName(contentDTO.getName());
            contenet.setDisplayName(contentDTO.getDisplayName());
            contenet.setContent(contentDTO.getContent().getBytes());
            contenet.setCreatedDate(new Date());
            contenet.setStatus(contentDTO.getStatus());
            contenet.setVersion(contentDTO.getVersion());

            contentDao.createContent(contenet);
        }

    }

