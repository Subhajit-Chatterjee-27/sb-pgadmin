package com.kroger.nightcrewapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class ImageInfoMapper implements RowMapper<ImageInfo>{

	private static final Logger logger = LoggerFactory.getLogger(ImageInfoMapper.class);
	public ImageInfo mapRow(ResultSet resultSet, int i) throws SQLException {

		System.out.println("Inside Image info mapper class");
		ImageInfo imageInfo = new ImageInfo();
		imageInfo.setImageId(resultSet.getInt("image_id"));
		imageInfo.setImage(resultSet.getBytes("image"));
		imageInfo.setCreatedBy(resultSet.getString("created_by"));
		imageInfo.setCreatedDate(resultSet.getTimestamp("created_date"));
		System.out.println("Image details from database: "+imageInfo.toString());
		return imageInfo;
	}
}
