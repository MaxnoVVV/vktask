package org.vk.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
public class AggregatedByEvents implements RowMapper<AggregatedByEvents> {
    private String event;
    private int number;

    @Override
    public AggregatedByEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
        AggregatedByEvents result = new AggregatedByEvents();
        result.setEvent(rs.getString("name"));
        result.setNumber(rs.getInt("number"));
        return result;
    }


}
