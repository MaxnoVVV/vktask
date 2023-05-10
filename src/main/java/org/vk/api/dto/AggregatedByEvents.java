package org.vk.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
@Setter
@Getter
public class AggregatedByEvents implements RowMapper<AggregatedByEvents> {
    private String name;
    private int number;
    @Override
    public AggregatedByEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
        AggregatedByEvents result = new AggregatedByEvents();
        result.setName(rs.getString("name"));
        result.setNumber(rs.getInt("number"));
        return result;
    }

    public String toString()
    {
        return name + ":" + number;
    }
}
