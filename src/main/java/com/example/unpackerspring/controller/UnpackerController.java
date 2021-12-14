package com.example.unpackerspring.controller;

import com.example.unpackerspring.service.UnpackerStringService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/unpack-string")
public class UnpackerController {
    private final UnpackerStringService service;
    @SneakyThrows
    @PostMapping("/unpack")
    public String unpackedString(@RequestBody String input){
        return service.unpack(input);
    }

}
