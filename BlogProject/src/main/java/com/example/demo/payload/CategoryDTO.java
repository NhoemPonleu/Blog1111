package com.example.demo.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
   private Integer categoryID;
   @NotBlank
   @Size(min = 4)
   private String categoryTitle;
   @NotBlank
   @Size(max = 10)
   private String categoryDescription;
}
