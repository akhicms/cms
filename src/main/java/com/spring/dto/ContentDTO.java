package com.spring.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.model.Contenet;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;

/**
 * Created by mvani on 03/07/17.
 */
@Component
public class ContentDTO {




	private Long id;
	private String name;
	private String displayName;
	private String content;
	private String status;
	private int version;
	private Date createdDate;
	private Date updatedDate;


	public ContentDTO(long id, String name, String displayName, String content, String status,int version,Date createdDate,Date updatedDate) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.content = content;
		this.status = status;
		this.version = version;
		this.createdDate = createdDate;
		this.updatedDate =  updatedDate;
	}

	public ContentDTO() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getContent() {
		return content;
	}

	public String getStatus() {
		return status;
	}

	public int getVersion() {
		return version;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}