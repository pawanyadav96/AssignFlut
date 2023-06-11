package com.example.demo.exception;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MyErrorDetails {
	private LocalDateTime timestamp;

	private String name;

	private String description;

}
