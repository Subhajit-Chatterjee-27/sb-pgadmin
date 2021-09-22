package com.kroger.nightcrewapp.service;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.kroger.nightcrewapp.model.ImageInfo;
import com.kroger.nightcrewapp.model.Person;
import com.kroger.nightcrewapp.model.StoreImageDetails;

public interface PersonService {

	List<Person> findAll();

	void insertEmployee(Person emp);
	
	void insertImage(ImageInfo imageInfo);
	
	void saveImageToDB(MultipartFile file,Integer imageId,String createdBy,Timestamp createdDate);
	
	void saveImageToDB2(MultipartFile file, StoreImageDetails imageDetails);

	void updateEmployee(Person emp);

	void executeUpdateEmployee(Person emp);

	void deleteEmployee(Person emp);
	
	Person fetchEmployeeById(Long empId);
	
	ImageInfo getImageById(Integer imageId);
	
	StoreImageDetails getStoredImageById(Integer imageId);
}
