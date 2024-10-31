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
    @Size(min = 3, message = "FIRSTNAME_INVALID")
    private String firstName;
    @Size(min = 3, message = "LASTNAME_INVALID")
    private String lastName;
    private int age;
}
