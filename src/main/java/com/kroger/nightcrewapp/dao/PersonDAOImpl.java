package com.kroger.nightcrewapp.dao;

import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.kroger.nightcrewapp.constants.NightCrewQueryConstants;
import com.kroger.nightcrewapp.model.ImageInfo;
import com.kroger.nightcrewapp.model.ImageInfoMapper;
import com.kroger.nightcrewapp.model.Person;
import com.kroger.nightcrewapp.model.PersonMapper;
import com.kroger.nightcrewapp.model.StoreImageDetails;
import com.kroger.nightcrewapp.model.StoreImageMapper;

@Component
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Person getPersonById(Long id) {
		return jdbcTemplate.queryForObject(NightCrewQueryConstants.SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
	}

	public List<Person> getAllPersons() {
		return jdbcTemplate.query(NightCrewQueryConstants.SQL_GET_ALL, new PersonMapper());
	}

	public boolean deletePerson(Person person) {
		return jdbcTemplate.update(NightCrewQueryConstants.SQL_DELETE_PERSON, person.getId()) > 0;
	}

	public boolean updatePerson(Person person) {
		return jdbcTemplate.update(NightCrewQueryConstants.SQL_UPDATE_PERSON, person.getFirstName(), person.getLastName(), person.getAge(),
				person.getId()) > 0;
	}

	public boolean createPerson(Person person) {
		return jdbcTemplate.update(NightCrewQueryConstants.SQL_INSERT_PERSON, person.getId(), person.getFirstName(), person.getLastName(),
				person.getAge()) > 0;
	}
	
	public int createImage(ImageInfo imageInfo) {
		return jdbcTemplate.update(NightCrewQueryConstants.SQL_INSERT_IMAGE, imageInfo.getImageId(), imageInfo.getImage(), imageInfo.getCreatedBy(), imageInfo.getCreatedDate());
	}

	@Override
	public ImageInfo getImageById(Integer imageId) {
		return jdbcTemplate.queryForObject(NightCrewQueryConstants.SQL_FIND_IMAGE, new Object[] { imageId }, new ImageInfoMapper());
		//return (ImageInfo) jdbcTemplate.queryForMap(NightCrewQueryConstants.SQL_FIND_IMAGE, new Object[] { imageId }, new ImageInfoMapper());
	}

	@Override
	public int createImageInfo(StoreImageDetails storeImageDetails) {
		return jdbcTemplate.update(NightCrewQueryConstants.SQL_STORE_IMAGE, storeImageDetails.getImageId(), storeImageDetails.getImage(), storeImageDetails.getCreatedBy(), storeImageDetails.getCreatedDate());
	}

	@Override
	public StoreImageDetails getStoredImageById(Integer imageId) {
		return jdbcTemplate.queryForObject(NightCrewQueryConstants.SQL_FETCH_STORED_IMAGE, new Object[] { imageId }, new StoreImageMapper());
	}

}

