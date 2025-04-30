package com.example.ddakdae.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetParkInfo {
    private int list_total_count;
    private Result RESULT;
    private List<Parking> row;
}
