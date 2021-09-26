package jp.co.project.planets.earthly.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("sample")
public class SampleRestController {

    @GetMapping
    public Map<String, String> get() {
        return Map.of("message", "hoge");
    }
}
