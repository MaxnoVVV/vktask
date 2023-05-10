package org.vk.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
public class AggregatedByIp implements RowMapper<AggregatedByIp> {
    private String ip;
    private int number;

    @Override
    public AggregatedByIp mapRow(ResultSet rs, int rowNum) throws SQLException {
        AggregatedByIp result = new AggregatedByIp();
        result.setIp(rs.getString("ip"));
        result.setNumber(rs.getInt("number"));
        return result;
    }
}
