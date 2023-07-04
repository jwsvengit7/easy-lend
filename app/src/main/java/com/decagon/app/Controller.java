package com.decagon.app;

import com.decagon.payload.Request;
import com.decagon.payload.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class Controller {

    private static final List<Response> RESPONSE = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody Request request) {
        Response response = new Response(request.getName(), String.format("Email is %s", request.getEmail()), request.getAge());
        RESPONSE.add(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Response>> get() {
        return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
    }
}
