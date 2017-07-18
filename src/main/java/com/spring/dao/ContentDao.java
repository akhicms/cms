package com.spring.dao;

import com.spring.model.Contenet;



import java.util.List;

public interface ContentDao {
 
public void createContent(Contenet contenet);
 
public void updateContent( long id,Contenet contenet);
 
public void deleteContent(long contenetId);
 
public Contenet find(long contenetId);
 
public List < Contenet > findAll();
}