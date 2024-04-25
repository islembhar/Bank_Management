package com.bank.model.dto;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class BaseDto {
	private long id;
	private LocalDateTime createAt;

}