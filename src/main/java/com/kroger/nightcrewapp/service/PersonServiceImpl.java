package com.kroger.nightcrewapp.service;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.kroger.nightcrewapp.dao.PersonDAO;
import com.kroger.nightcrewapp.model.ImageInfo;
import com.kroger.nightcrewapp.model.Person;
import com.kroger.nightcrewapp.model.StoreImageDetails;

import org.springframework.util.StringUtils;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;

@Component
public class PersonServiceImpl implements PersonService{
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Resource 
	PersonDAO employeeDao;
	
	@Override
	public List<Person> findAll() {
		return employeeDao.getAllPersons();
	}
	
	@Override
	public void insertEmployee(Person emp) {
		logger.info("Creating new employee details: "+ emp.toString());
		employeeDao.createPerson(emp);
		
	}
	
	@Override
	public void insertImage(ImageInfo imageInfo) {
		logger.info("Inserting image details: "+ imageInfo.toString());
		employeeDao.createImage(imageInfo);
		
	}
	
	@Override
	public void updateEmployee(Person emp) {
		logger.info("Updating existing employee details: "+ emp.toString());
		employeeDao.updatePerson(emp);
		
	}

	@Override
	public void deleteEmployee(Person emp) {
		logger.info("Deleting existing employee details: "+ emp.toString());
		employeeDao.deletePerson(emp);
		
	}
	
	@Override
	public Person fetchEmployeeById(Long empId) {
		logger.info("Getting existing employee by id: "+ empId);
		return employeeDao.getPersonById(empId);
	}
	
	@Override
	public ImageInfo getImageById(Integer imageId) {
		return employeeDao.getImageById(imageId);
	}
	
	@Override
	public void executeUpdateEmployee(Person emp) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveImageToDB(MultipartFile file,Integer imageId,String createdBy,Timestamp createdDate) {
		StoreImageDetails imageInfo = new StoreImageDetails();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		
		try {
			imageInfo.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imageInfo.setImageId(imageId);
		imageInfo.setCreatedBy(createdBy);
		imageInfo.setCreatedDate(createdDate);
		employeeDao.createImageInfo(imageInfo);
		
	}
	
	public void saveImageToDB2(MultipartFile file, StoreImageDetails storeImageDetails) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		
		try {
			storeImageDetails.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		employeeDao.createImageInfo(storeImageDetails);
	}

	@Override
	public StoreImageDetails getStoredImageById(Integer imageId) {
		return employeeDao.getStoredImageById(imageId);
	}

}