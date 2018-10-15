package co.id.ptap.controllers;

import static org.hamcrest.CoreMatchers.allOf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/banking")
@Api(value="Rest Api Banking", description="Open Banking API", basePath="/api/v1/banking")
//@ApiIgnore
public class RestApiBanking {

	@GetMapping("/test")
	public String test() {
		return "This is just test";
	}
	
}
