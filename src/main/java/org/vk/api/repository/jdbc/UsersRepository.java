package org.vk.api.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.vk.api.dto.*;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class UsersRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    public void add(String name, String ip, boolean isAuth, LocalDate date)
    {
        jdbcTemplate.update("INSERT INTO vk VALUES (?,?,?,?)",name,isAuth,ip,date);
    }
    public List<AggregatedByEvents> groupByEvents(String filter)
    {
        return jdbcTemplate.query("SELECT name, COUNT(*) as NUMBER FROM " + tableName + " " + filter + " GROUP BY " + "name", new AggregatedByEvents());
    }

    public List<AggregatedByStatus> groupByStatus(String filter)
    {
        return jdbcTemplate.query("SELECT is_auth, COUNT(*) as NUMBER FROM " + tableName + " " + filter + " GROUP BY " + "is_auth", new AggregatedByStatus());
    }

    public List<AggregatedByIp> groupByIp(String filter)
    {
        return jdbcTemplate.query("SELECT ip, COUNT(*) as NUMBER FROM " + tableName + " " + filter + " GROUP BY " + "ip", new AggregatedByIp());
    }

}
