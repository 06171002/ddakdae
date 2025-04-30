package com.example.ddakdae.service;

import com.example.ddakdae.dto.ParkingResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class ParkingService {
    private final RestTemplate restTemplate;

    @Value("${seoul.api.base-url}")
    private String baseUrl;            // ex: http://openapi.seoul.go.kr:8088
    @Value("${seoul.api.key}")
    private String apiKey;            // 발급받은 인증키
    @Value("${seoul.api.format}")
    private String format;            // xml 또는 json
    @Value("${seoul.api.service}")
    private String serviceName;

    /**
     * 공영주차장 정보 조회
     * @param start  시작 인덱스
     * @param end    끝 인덱스
     * @param gu     (선택) 행정구명
     * @param code   (선택) 주차장 코드
     */
    public ParkingResponse getParkings(int start, int end, String gu, String code) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .pathSegment(apiKey, format, serviceName,
                        String.valueOf(start), String.valueOf(end));

        // 선택 파라미터 추가
        if (gu != null && !gu.isBlank()) {
            builder.pathSegment(gu);
        } else {
            builder.path("");  // 빈 세그먼트로 구 위치 유지
        }
        if (code != null && !code.isBlank()) {
            builder.pathSegment(code);
        }

        String url = builder.encode().toUriString();
        return restTemplate.getForObject(url, ParkingResponse.class);
    }
}
