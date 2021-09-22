package com.kroger.nightcrewapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class StoreImageMapper implements RowMapper<StoreImageDetails> {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreImageMapper.class);
	public StoreImageDetails mapRow(ResultSet resultSet, int i) throws SQLException {

		StoreImageDetails storeImageDetails = new StoreImageDetails();
		storeImageDetails.setImageId(resultSet.getInt("image_id"));
		storeImageDetails.setImage(resultSet.getString("image"));
		storeImageDetails.setCreatedBy(resultSet.getString("created_by"));
		storeImageDetails.setCreatedDate(resultSet.getTimestamp("created_date"));
		return storeImageDetails;
	}
}

