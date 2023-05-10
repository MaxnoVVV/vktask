package org.vk.api.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Setter
public class Event implements RowMapper<Event> {
    private String name;
    private String ip;
    private boolean isAuth;
    private String date;

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setIp(rs.getString("ip"));
        event.setAuth(rs.getBoolean("is_auth"));
        event.setDate(rs.getString("date"));
        return event;
    }
}
