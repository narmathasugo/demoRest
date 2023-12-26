package com.sigma.demo.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.sigma.demo.dto.ItemDto;
import com.sigma.demo.exception.ValidationException;

@Component
public class ItemUtil {
	
	 public void validateOrderMandatoryInputValues(ItemDto itemDto) throws ValidationException {

		    if (itemDto.getName() == null) {
		        throw new ValidationException("0001","Missing Item Name information");
		    }
		    if (itemDto.getPrice() == null) {
		        throw new ValidationException("0002","Missing Item Price information");

		    }else if(itemDto.getPrice().compareTo(BigDecimal.ZERO) == -1) {
		        throw new ValidationException("0003","Item Price Must be greater than zero");

		    }
		    if (itemDto.getDescription() == null) {
		        throw new ValidationException("0004","Missing Item Description information");

		    }
		    }

}
