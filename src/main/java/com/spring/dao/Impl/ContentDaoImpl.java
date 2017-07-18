package com.spring.dao.Impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.dao.ContentDao;

import com.spring.model.Contenet;
 

@Repository
@Qualifier("ContentDao")
public class ContentDaoImpl implements ContentDao {
 
@Autowired
JdbcTemplate jdbcTemplate;
 
public void createContent(Contenet contenet) {
jdbcTemplate.update("INSERT INTO Content (id, name, displyName, content,status,version,createdDate) VALUES (?, ?, ?, ?, ?, ?, ?)",
        contenet.getId(), contenet.getName(), contenet.getDisplayName(), contenet.getContent(),contenet.getStatus(),contenet.getVersion(),contenet.getCreatedDate());
}
 
public void updateContent( long id,Contenet content) {
jdbcTemplate.update("UPDATE Content SET name = ? , displyName = ? , content = ? , updatedDate = ? WHERE id = ? ",
        content.getName(), content.getDisplayName(), content.getContent(),content.getUpdatedDate(), id);
}
 
public void deleteContent(long id) {
jdbcTemplate.update("DELETE from Content WHERE id = ? ", id);
}
 
public Contenet find(long id) {
    Contenet content = (Contenet) jdbcTemplate.queryForObject("SELECT * FROM Content where id = ? ",
new Object[] { id }, new BeanPropertyRowMapper(Contenet.class));
 
return content;
}
 
public List < Contenet > findAll() {
List < Contenet > contenets = jdbcTemplate.query("SELECT * FROM Content", new BeanPropertyRowMapper(Contenet.class));
    return contenets;
}
}
