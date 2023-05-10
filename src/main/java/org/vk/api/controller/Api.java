package org.vk.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vk.api.dto.Event;
import org.vk.api.repository.jdbc.UsersRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Api {

    private final UsersRepository usersRepository;

    @PostMapping("/users")
    public ResponseEntity addUser(HttpServletRequest request, @RequestParam("event") String event, @RequestParam("is_auth") boolean is_auth) {
        usersRepository.add(event, request.getRemoteHost(), is_auth, LocalDate.now());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity getStats(@RequestParam(value = "date", required = false) String date, @RequestParam(value = "event", required = false) String name, @RequestParam("by") String AggregateBy) {
        String filter = "";
        if (date != null || name != null) {
            filter = "WHERE ";
            if (date != null) {
                filter += "date = " + "'" + date + "'" + " ";
                if (name != null) {
                    filter += "AND ";
                }
            }
            if (name != null) {
                filter += "name = " + "'" + name + "'";
            }
        }

        if (AggregateBy.equals("events")) {
            return new ResponseEntity(usersRepository.groupByEvents(filter), HttpStatus.OK);
        } else if (AggregateBy.equals("status")) {
            return new ResponseEntity(usersRepository.groupByStatus(filter), HttpStatus.OK);
        } else if (AggregateBy.equals("ip")) {
            return new ResponseEntity(usersRepository.groupByIp(filter), HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
