package com.example.ddakdae.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParkingResponse {
    @JsonProperty("GetParkInfo")
    private GetParkInfo getParkInfo;
}