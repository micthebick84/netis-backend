package com.example.netisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HealthController {

    private final DataSource postgresDataSource;
    private final DataSource oracleDataSource;
    private final JdbcTemplate clickHouseJdbcTemplate;

    @GetMapping("/actuator/health")
    public Map<String, Object> health() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", "UP");

        Map<String, Object> components = new LinkedHashMap<>();
        components.put("postgres", checkDataSource(postgresDataSource, "SELECT 1"));
        components.put("oracle", checkDataSource(oracleDataSource, "SELECT 1 FROM DUAL"));
        components.put("clickhouse", checkClickHouse());

        boolean allUp = components.values().stream()
                .allMatch(c -> "UP".equals(((Map<?, ?>) c).get("status")));
        result.put("status", allUp ? "UP" : "DOWN");
        result.put("components", components);

        return result;
    }

    private Map<String, String> checkDataSource(DataSource ds, String query) {
        Map<String, String> status = new LinkedHashMap<>();
        try (Connection conn = ds.getConnection()) {
            conn.createStatement().execute(query);
            status.put("status", "UP");
        } catch (Exception e) {
            status.put("status", "DOWN");
            status.put("error", e.getMessage());
        }
        return status;
    }

    private Map<String, String> checkClickHouse() {
        Map<String, String> status = new LinkedHashMap<>();
        try {
            clickHouseJdbcTemplate.queryForObject("SELECT 1", Integer.class);
            status.put("status", "UP");
        } catch (Exception e) {
            status.put("status", "DOWN");
            status.put("error", e.getMessage());
        }
        return status;
    }
}
