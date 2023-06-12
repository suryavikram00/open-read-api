package com.api.open.read.api.controller;


import com.api.open.read.api.constants.OpenReadEndPoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.api.open.read.api.constants.OpenReadEndPoints.GET_API_HEALTH_STATUS;

@RestController
@RequestMapping(OpenReadEndPoints.ENDPOINT_OPEN_READ_PREFIX)
public class OpenReadHealthCheckController {

    @GetMapping(GET_API_HEALTH_STATUS)
    public ResponseEntity<String> getHealthStatus() {
        return new ResponseEntity<>("Healthy", HttpStatus.OK);
    }

}
