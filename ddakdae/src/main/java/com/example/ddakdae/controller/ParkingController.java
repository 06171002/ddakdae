package com.example.ddakdae.controller;

import com.example.ddakdae.dto.Parking;
import com.example.ddakdae.dto.ParkingResponse;
import com.example.ddakdae.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parkings")
@RequiredArgsConstructor
public class ParkingController {
    private final ParkingService parkingService;

    @GetMapping
    public List<Parking> list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="100") int size,
            @RequestParam(required=false) String gu,
            @RequestParam(required=false) String code
    ) {
        int start = (page - 1) * size + 1;
        int end = page * size;
        ParkingResponse resp = parkingService.getParkings(start, end, gu, code);
        return resp.getGetParkInfo().getRow();
    }
}
