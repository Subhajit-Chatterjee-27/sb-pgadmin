package com.kroger.nightcrewapp.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class ImageInfo {

	private Integer imageId;
	private byte[] image;
	private String createdBy;
	private Timestamp createdDate; 
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "ImageInfo [imageId=" + imageId + ", image=" + Arrays.toString(image) + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + "]";
	}

}
