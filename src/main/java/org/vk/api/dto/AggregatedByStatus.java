package org.vk.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
@Setter
@Getter
public class AggregatedByStatus implements RowMapper<AggregatedByStatus> {
    private boolean status;
    private int number;
    @Override
    public AggregatedByStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        AggregatedByStatus result = new AggregatedByStatus();
        result.setStatus(rs.getBoolean("is_auth"));
        result.setNumber(rs.getInt("number"));
        return result;
    }
}
