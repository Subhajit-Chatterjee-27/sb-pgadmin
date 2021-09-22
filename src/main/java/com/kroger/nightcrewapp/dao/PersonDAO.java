package com.kroger.nightcrewapp.dao;

import java.util.List;
import com.kroger.nightcrewapp.model.ImageInfo;
import com.kroger.nightcrewapp.model.Person;
import com.kroger.nightcrewapp.model.StoreImageDetails;

public interface PersonDAO {
	Person getPersonById(Long id);

	List<Person> getAllPersons();

	boolean deletePerson(Person person);

	boolean updatePerson(Person person);

	boolean createPerson(Person person);
	
	int createImage(ImageInfo imageInfo);
	
	int createImageInfo(StoreImageDetails storeImageDetails);
	
	ImageInfo getImageById(Integer imageId);
	
	StoreImageDetails getStoredImageById(Integer imageId);
}
