package com.example.ddakdae.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Parking {
    @JsonProperty("PKLT_NM")
    private String parkingName;

    @JsonProperty("ADDR")
    private String address;

    @JsonProperty("PKLT_CD")
    private String parkingCode;

    @JsonProperty("PKLT_KND_NM")
    private String typeName;

    @JsonProperty("TELNO")
    private String phone;

    @JsonProperty("TPKCT")
    private int totalSpaces;

    @JsonProperty("LAT")
    private double latitude;

    @JsonProperty("LOT")
    private double longitude;

    // …필요한 다른 필드도 같은 방식으로
}
