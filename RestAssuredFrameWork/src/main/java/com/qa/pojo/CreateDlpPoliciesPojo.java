package com.qa.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDlpPoliciesPojo {

    /*
 *     {
        "id": 1,
        "title": "Confidential1235",
        "hex_colour_code": "ff454f",
        "enabled": true
    }
 */
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("enabled")
    private  boolean enabled;
}
