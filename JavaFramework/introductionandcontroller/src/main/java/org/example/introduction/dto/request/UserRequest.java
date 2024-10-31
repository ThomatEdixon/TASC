package org.example.introduction.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    @Size(min = 3, message = "First Name must be at least 3 characters")
    private String firstName;
    @Size(min = 3, message = "First Name must be at least 3 characters")
    private String lastName;
    private int age;
}
