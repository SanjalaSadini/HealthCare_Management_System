package com;

import model.Doctor;

import view.DoctorAppointment;

import java.sql.Time;

//For REST Service 
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*; 

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Doctors")

public class DoctorService {
	
Doctor docObj = new Doctor();
	
//Update doctor details
	@PUT 
	@Path("/updateProfile") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateDoctor(String docData) 
	{  
		//Convert the input string to a JSON object  
		JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		int d_id = docObject.get("doc_id").getAsInt();
		String nic = docObject.get("doc_nic").getAsString();  
		String fname = docObject.get("doc_fname").getAsString();  
		String lname = docObject.get("doc_lname").getAsString(); 
		String email = docObject.get("doc_email").getAsString();
		String gender = docObject.get("doc_gender").getAsString();
		String liscen = docObject.get("liscen_no").getAsString();
		String special = docObject.get("specialization").getAsString();
		String phone = docObject.get("phone").getAsString();
		String charge = docObject.get("doc_charge").getAsString();
		String userId = docObject.get("user_user_id").getAsString();
		 
		String output = docObj.updateDoctor(d_id, nic, fname, lname, email, gender, liscen, special, phone, charge, userId); 
		 
		return output; 
	}
	
	// View appointment by doctor id
			@GET
			@Path("/{doctor_doc_id}")
			// @Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			public DoctorAppointment ShowAppointmentByDocId(@PathParam("doctor_doc_id") int id) {
				
				return docObj.ShowAppointmentByDocId(id);
			}
	

	
	

}