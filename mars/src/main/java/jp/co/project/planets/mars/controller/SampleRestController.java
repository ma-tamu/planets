package jp.co.project.planets.mars.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jp.co.project.planets.mars.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * sample rest controller
 */
@RestController
@RequestMapping("sample")
@SecurityRequirement(name = "authorization_code")
public class SampleRestController {

    private final SampleService sampleService;

    public SampleRestController(final SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> get() {
        final var message = sampleService.getMessage();
        return ResponseEntity.ok(Map.of("message", message));
    }
}
