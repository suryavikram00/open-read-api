/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.generic.controller.angular;

import static com.api.open.read.api.generic.constants.GenericEndPoints.GET_API_HEALTH_STATUS;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.api.open.read.api.generic.constants.GenericEndPoints.ENDPOINT_OPEN_READ_PREFIX;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author NMSLAP570
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Slf4j
@Controller
public class AngularController {

    @RequestMapping({ENDPOINT_OPEN_READ_PREFIX, "/" + ENDPOINT_OPEN_READ_PREFIX + "/**"})
    public String angularApp(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return "forward:/static" + requestURI;
    }

    @GetMapping(ENDPOINT_OPEN_READ_PREFIX + "/" + GET_API_HEALTH_STATUS)
    public ResponseEntity<String> getHealthStatus() {
        return new ResponseEntity<>("Crud API Healthy", HttpStatus.OK);
    }

}
