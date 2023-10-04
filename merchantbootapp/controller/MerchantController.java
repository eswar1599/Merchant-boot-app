package org.jsp.merchantbootapp.controller;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class MerchantController 
{
	@Autowired
	private MerchantService service;
	
	@PostMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
        return service.saveMerchant(merchant); 
	}
	
	
	@PutMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
        return service.updateMerchant(merchant);
	}
	
	
	@GetMapping("/merchant/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable int id ) {
		return service.findById(id);
	}
	
	
	@DeleteMapping("/merchant/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	@PostMapping("/merchant/verify-by-phone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone, @RequestParam String password) {
		return service.verifyMerchant(phone, password);
	}
	@PostMapping("/merchant/verify-by-name")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam String name, @RequestParam String password) {
		return service.verifyMerchant(name, password);
	}
	@PostMapping("/merchant/verify-by-id")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam int id, @RequestParam String password) {
		return service.verifyMerchant(id, password);
	}
	@PostMapping("/merchant/verify-by-email")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchantbyemail(@RequestParam String email, @RequestParam String password) {
		return service.verifyMerchantbyemail(email, password);
	}
}
