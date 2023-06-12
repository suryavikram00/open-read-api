/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author NMSLAP570
 */
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenReadEndPoints {
    
    public static final String ENDPOINT_OPEN_READ_PREFIX = "open-read";
    public static final String GET_API_HEALTH_STATUS = "/status";
    
}
