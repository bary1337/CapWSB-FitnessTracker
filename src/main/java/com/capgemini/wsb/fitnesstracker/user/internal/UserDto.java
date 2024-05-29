package com.capgemini.wsb.fitnesstracker.user.internal;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(@Nullable Long Id, String firstName, String lastName,
                      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                      String email) {
}
