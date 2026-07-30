package com.mbc.mtps;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//웹에서 데이터를 가져갈 수 있도록 접속 허가
@Configuration // <- 설정
public class WebConfigurer implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		// 모든 접속(접근)을 허용
		registry.addMapping("/**").allowedOrigins("*");
		
		// 헤당 주소에서만 접속 허용
		// registry.addMapping("/**").allowedOrigins("http://localhost:9000");
	}

}