package com.sigma.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sigma.demo.dto.APIResonseStatus;
import com.sigma.demo.dto.APIResponse;
import com.sigma.demo.dto.ItemDto;
import com.sigma.demo.exception.ValidationException;
import com.sigma.demo.model.Item;
import com.sigma.demo.service.ItemService;
import com.sigma.demo.util.ItemUtil;


//creating RestController
@RequestMapping("/item")
@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemUtil itemUtil;
	
	//creating post mapping that post the item detail in the database
	@PostMapping
	public ResponseEntity<String> createFromJson(@RequestBody ItemDto itemDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		  APIResponse response = null; 

		try {
			itemUtil.validateOrderMandatoryInputValues(itemDto);
			itemService.saveOrUpdate(itemDto);
			response = new APIResponse(APIResonseStatus.success.toString(),"Item Created");

			return new ResponseEntity<String>(response.toJson(),headers, HttpStatus.CREATED);	
		} catch (Exception e)
		{
			if(e instanceof ValidationException){
				response = new APIResponse(APIResonseStatus.fail.toString(), e.getMessage());
				return new ResponseEntity<String>(response.toJson(), HttpStatus.BAD_REQUEST);	
			}
			
			response = new APIResponse(APIResonseStatus.fail.toString(), e.getMessage());
			return new ResponseEntity<String>(response.toJson(), HttpStatus.INTERNAL_SERVER_ERROR);	
			
		}
	}
	
	//creating post mapping that post List of items detail in the database
	@RequestMapping(value = "/postAll",method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJsonArray(@RequestBody List<Item> itemList) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		  APIResponse response = null; 

		try {		
			itemService.saveAllItems(itemList);
			response = new APIResponse(APIResonseStatus.success.toString(),"Items Created");

			return new ResponseEntity<String>(response.toJson(),headers, HttpStatus.CREATED);	
		} catch (Exception e)
		{
			if(e instanceof ValidationException){
				response = new APIResponse(APIResonseStatus.fail.toString(), e.getMessage());
				return new ResponseEntity<String>(response.toJson(), HttpStatus.BAD_REQUEST);	
			}
			
			response = new APIResponse(APIResonseStatus.fail.toString(), e.getMessage());
			return new ResponseEntity<String>(response.toJson(), HttpStatus.INTERNAL_SERVER_ERROR);	
			
		}
	}
	
	//creating a get mapping that retrieves the detail of a specific item
	@GetMapping("/{id}")
	public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			Item item = itemService.getItemById(id);
			if (item == null) {
				return new ResponseEntity<String>(headers, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<String>(item.toJson(), headers, HttpStatus.OK);
		}  catch (Exception e) {
			return new ResponseEntity<String>("{\"ERROR\":" + e.getMessage() + "\"}", headers,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//creating a get mapping that retrieves the detail of all items in the table
	@GetMapping
	public ResponseEntity<String> listJson() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			List<Item> result = itemService.findAllItem();
			return new ResponseEntity<String>(Item.toJsonArray(result), headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("{\"ERROR\":" + e.getMessage() + "\"}", headers,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
