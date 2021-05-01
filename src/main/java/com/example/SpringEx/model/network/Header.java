package com.example.SpringEx.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//통신시 통신의 결과를 보여주는 headr 객체
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {
	
	//api 통신시간
	private LocalDateTime transactionTime;
	
	//api 응답 코드
	private String resultCode;
	
	//api 부가 설명
	private String description;
	
	
	// 받을 DATE
	private T data;
	
	
	// OK
	public static <T> Header<T> OK() {
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}
	
	
	// DATA OK
	
	public static <T> Header<T> OK(T data) {
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.data(data)
				.build();
	}
	
	// error
	
	public static <T> Header<T> ERROR(String description) {
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("ERROR")
				.description(description)
				.build();
	}
	
}
