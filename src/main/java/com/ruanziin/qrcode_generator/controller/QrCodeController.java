package com.ruanziin.qrcode_generator.controller;

import com.ruanziin.qrcode_generator.dto.qrcode.QrCodeGenerateRequest;
import com.ruanziin.qrcode_generator.dto.qrcode.QrCodeGenerateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")

public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request){
        return null;
    }
}
