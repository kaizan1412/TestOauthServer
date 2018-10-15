package co.id.ptap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ComponentScan(basePackages="co.id.ptap.controllers")
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
//		Docket dock = new Docket(DocumentationType.SWAGGER_2);
//		dock.pathMapping("/");
//		dock.pathMapping("/home");
//
//		return dock;
		//Not working
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
		
		//Working Ones
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("co.id.ptap.controllers"))
				.paths(PathSelectors.any())
				.build();
	}
	
	

}
