package com.api.open.read.api.generic.controller;


import com.api.open.read.api.generic.constants.GenericEndPoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.api.open.read.api.generic.constants.GenericEndPoints.GET_API_HEALTH_STATUS;

@RestController
@RequestMapping(GenericEndPoints.ENDPOINT_OPEN_READ_PREFIX)
public class GenricHealthCheckController {

    @GetMapping(GET_API_HEALTH_STATUS)
    public ResponseEntity<String> getHealthStatus() {
        return new ResponseEntity<>("Healthy", HttpStatus.OK);
    }

}
