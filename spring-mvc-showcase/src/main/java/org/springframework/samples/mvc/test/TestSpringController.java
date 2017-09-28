package org.springframework.samples.mvc.test;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/**")
public class TestSpringController {

	private static final Logger logger = LoggerFactory.getLogger(TestSpringController.class);
	
	@RequestMapping(value = "/post1",method = RequestMethod.POST)
	@ResponseBody
	public String post1(){
		logger.info("test post1---access");
		return "hello hah";
	}
	
	@PostMapping("/post/mapping1")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>  postMapping1(){
		Map<String,Object> ret = new HashMap<>();
		ret.put("name", "chenhong");
		return new ResponseEntity<Map<String,Object>>(ret,HttpStatus.OK);
//		return ResponseEntity.ok(ret);
	}
	
	@GetMapping("/get1/{color:red|blue}")
	public String get1(@PathVariable String color,Model model){
		model.addAttribute("color",color);
		return "test/get1";
	}
	
	
}
