package com.azure.sample.sprintbootsimpleactivedirectory.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser {
    private String fullName;
    private List<String> roles;

    @Override
    public String toString() {
        return "Current User{" +
                "fullName='" + fullName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
