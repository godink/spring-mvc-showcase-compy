package org.springframework.samples.mvc.test.convert;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/format")
public class PhoneNumberFormatController {
	
	private Logger logger = LoggerFactory.getLogger(PhoneNumberFormatController.class);
	
	/**
	 *测试url：localhost:12080/format/convert1?totalCount=10000&discount=0.53&sumMoney=10000.128&phoneNumber=010-12345678
	 * 
	 * @param formatModel
	 * @return
	 */
	@GetMapping("/convert1")
	public String phoneNumberFormat1(@ModelAttribute("model") FormatterModel formatModel){
		return "test/convert/format1";
	}
	
	@PostMapping("convert2")
	@ResponseBody
	public ResponseEntity<String> phoneNumberFormat2(@PhoneNumber @RequestParam("phoneNumber") PhoneNumberModel phoneNumber
			,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date date){
		logger.info("phoneNumber:[{}]",phoneNumber);
		logger.info("date:[{}]",date);
		return ResponseEntity.ok("success");
	}
}
