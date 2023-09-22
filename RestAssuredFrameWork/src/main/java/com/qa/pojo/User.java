package com.qa.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    /***
     * {
     *     "id": 5183876,
     *     "name": "Himanshu Kumar",
     *     "email": "himanshu@kumar.com",
     *     "gender": "male",
     *     "status": "active"
     * }
     */

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private  String email;

    @JsonProperty("status")
    private String status;

    @JsonProperty("gender")
    private String gender;

}
