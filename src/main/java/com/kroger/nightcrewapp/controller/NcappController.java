package com.kroger.nightcrewapp.controller;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kroger.nightcrewapp.model.ImageInfo;
import com.kroger.nightcrewapp.model.Person;
import com.kroger.nightcrewapp.model.StoreImageDetails;
import com.kroger.nightcrewapp.service.PersonService;

@RestController
@RequestMapping("/postgressApp")
public class NcappController {
	
	private static final Logger logger = LoggerFactory.getLogger(NcappController.class);

	@Resource 
	PersonService personService;
	
	@GetMapping(value = "/employeeList")
	public List<Person> getEmployees() {
		return personService.findAll();
	}
	
	@PostMapping(value = "/createEmp")
	public void createEmployee(@RequestBody Person emp) {
		personService.insertEmployee(emp);
	
	}
	
	@PostMapping(value = "/createImage")
	public void createImage(@RequestBody ImageInfo imageInfo) {
		personService.insertImage(imageInfo);
	
	}
	
	@GetMapping("/fetchImage/{imageId}")
	public ImageInfo getImage(@PathVariable int imageId) {
		return personService.getImageById(imageId);
	}
	
	//Working controller for to post image details
	@PostMapping("/saveImageDetails/{imageId}/{createdBy}/{createdDate}")
    public void saveMultipartImage(@PathVariable("file") MultipartFile file,
    		@PathVariable("imageId") Integer imageId,
    		@PathVariable("createdBy") String createdBy,
    		@PathVariable("createdDate") Timestamp createdDate) {
		personService.saveImageToDB(file, imageId, createdBy, createdDate);
    }
	
	//working controller to fetch image details
	@GetMapping("/fetchStoredImage/{imageId}")
	public StoreImageDetails getStoredImageById(@PathVariable Integer imageId) {
		return personService.getStoredImageById(imageId);
	}
	
	//Not supporting multipart file insertion
	@PostMapping("/saveImageDetails2")
    public void saveMultipartImage2(@PathVariable("file") MultipartFile file,
    		@RequestBody StoreImageDetails storeImageDetails) {
		personService.saveImageToDB2(file, storeImageDetails);
    }
	
	@PutMapping(value = "/updateEmp")
	public void updateEmployee(@RequestBody Person emp) {
		personService.updateEmployee(emp);
	
	}
	
	@DeleteMapping(value = "/deleteEmpById")
	public void deleteEmployee(@RequestBody Person emp) {
		personService.deleteEmployee(emp);
	
	}
	
	@GetMapping("/employees/{id}")
	public Person getEmployeeById(@PathVariable long id) {
		return personService.fetchEmployeeById(id);
	}
	
}


