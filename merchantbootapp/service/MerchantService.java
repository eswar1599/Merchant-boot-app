package org.jsp.merchantbootapp.service;

import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.exception.IdNotFoundException;
import org.jsp.merchantbootapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class MerchantService 
{
	@Autowired
	private MerchantDao dao;
	
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
        merchant= dao.saveMerchant(merchant);
        structure.setData(merchant);
        structure.setMessage("Mercahnt registered succesfully");
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
	
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
        merchant= dao.updateMerchant(merchant);
        structure.setData(merchant);
        structure.setMessage("Mercahnt updated succesfully");
        structure.setStatusCode(HttpStatus.ACCEPTED.value());
        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}
	
	
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable int id ) {
		Optional<Merchant> recMerchant = dao.findById(id);
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			  structure.setData(recMerchant.get());
		        structure.setMessage("Mercahnt Found");
		        structure.setStatusCode(HttpStatus.OK.value());
		        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		ResponseStructure<String> structure= new ResponseStructure<>();
		boolean deleted = dao.deleteByid(id);
		if (deleted) {
			 structure.setData("merchant deleted");
		        structure.setMessage("Mercahnt Found");
		        structure.setStatusCode(HttpStatus.OK.value());
		        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchant(phone , password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
			}
			throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam String name, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchant(name , password);
		
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam int id, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchant(id , password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();	
	}
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchantbyemail(@RequestParam String email, @RequestParam String password) {
		ResponseStructure<Merchant> structure= new ResponseStructure<>();
		Optional<Merchant> recMerchant = dao.verifyMerchantbyemail(email , password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
	        structure.setMessage("Mercahnt verified");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}
