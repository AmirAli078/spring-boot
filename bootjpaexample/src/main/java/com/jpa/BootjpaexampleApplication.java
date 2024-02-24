package com.jpa;

import org.springframework.context.ApplicationContext; // Correct import

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.dao.UserRepositry;
import com.jpa.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepositry userRepositry = context.getBean(UserRepositry.class); // No need to cast

		// create a object of user
		//User user = new User();
		/*
		 *                         //insert values into that object
		 *  user.setName("Amir");
		 * user.setCity("Nawabshah"); user.setStatus("Java developer");
		 * 
		 * //create another object for saving the another data User user1 = new User();
		 * user1.setName("Ubaid"); user1.setCity("karachi");
		 * user1.setStatus("Python developer");
		 * 
		 * 
		 * User user1 = userRepositry.save(user); System.out.println(user1);
		 * 
		 * 
		 * User user2 = new User(); user2.setName("Inam"); user2.setCity("larkana");
		 * user2.setStatus("Web developer"); //to save the record at once you need to
		 * pass the list to the save List<User> users=List.of(user,user1,user2); //save
		 * all will save the all records. Iterable<User> result
		 * =userRepositry.saveAll(users); for (User use : result) {
		 * System.out.println(use); }
		 */
		
		
		                    //update the record at the given id
//	    Optional<User> optionl=	userRepositry.findById(52);
//		User user1=optionl.get();
//		System.out.println(user1);
//		user1.setName("Saqib");
//	   User result	=userRepositry.save(user1);
//	   System.out.println(result);	
		
		//get the record. you can get the whole record or single record too
		
		//get single record 
//	Optional<User> optional=userRepositry.findById(52);
//	  System.out.println(optional.get());
	  
		//get all records 
		
//		Iterable<User> itr=userRepositry.findAll();
		
		/*
		 * //old way to get the record Iterator<User> iterator=itr.iterator();
		 * while(iterator.hasNext()) { User user=iterator.next();
		 * System.out.println(user); }
		 */
		
		// new way to get the record 
//		itr.forEach(user->{System.out.println(user);});
		
		//delete the record you can delete the whole record or single record too
		
		//delete the single record 
		userRepositry.deleteById(52);
		System.out.println("Record is deleted..");
		
	}
}
