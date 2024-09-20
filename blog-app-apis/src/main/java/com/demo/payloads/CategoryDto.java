package com.demo.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotBlank
	@Size(min = 10, max = 100, message = "the min titile is size is 10 chracter and max is 100")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "The min size of description is 10")
	private String categoryDescription;

}
