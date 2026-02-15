package com.example.netisbackend.service;

import com.example.netisbackend.dto.transport.*;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportAnalyticsService {

    private final JdbcTemplate clickHouseJdbcTemplate;

    public List<DailySummaryResponse> getDailySummary(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_DAILY FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> DailySummaryResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .dayOfWeekNum(rs.getInt("day_of_week_num"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .stationCnt(rs.getInt("station_cnt"))
                .routeCnt(rs.getInt("route_cnt"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .boardingPct(rs.getBigDecimal("boarding_pct"))
                .revenuePerTransaction(rs.getBigDecimal("revenue_per_transaction"))
                .avgTransactionsPerStation(rs.getBigDecimal("avg_transactions_per_station"))
                .avgTransactionsPerRoute(rs.getBigDecimal("avg_transactions_per_route"))
                .build(), startDate, endDate);
    }

    public List<HourlySummaryResponse> getHourlySummary(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_HOURLY FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, hour_range
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> HourlySummaryResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .hourRange(rs.getInt("hour_range"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .hourUsagePct(rs.getBigDecimal("hour_usage_pct"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .boardingPct(rs.getBigDecimal("boarding_pct"))
                .revenueSharePct(rs.getBigDecimal("revenue_share_pct"))
                .build(), startDate, endDate);
    }

    public List<StationDailyResponse> getStationDaily(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_STN_DAILY FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, station_no
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> StationDailyResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .stationNo(rs.getString("station_no"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .boardingAlightingDiffPct(rs.getBigDecimal("boarding_alighting_diff_pct"))
                .netPassengerFlow(rs.getLong("net_passenger_flow"))
                .avgFare(rs.getInt("avg_fare"))
                .totalRev(rs.getLong("total_rev"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .boardingPct(rs.getBigDecimal("boarding_pct"))
                .alightingPct(rs.getBigDecimal("alighting_pct"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .build(), startDate, endDate);
    }

    public List<RouteDailyResponse> getRouteDaily(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_ROUTE_DAILY FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, route_no
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> RouteDailyResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .routeNo(rs.getString("route_no"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .stationCnt(rs.getInt("station_cnt"))
                .usageSharePct(rs.getBigDecimal("usage_share_pct"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .revenuePerTransaction(rs.getBigDecimal("revenue_per_transaction"))
                .revenueSharePct(rs.getBigDecimal("revenue_share_pct"))
                .revenuePerStation(rs.getBigDecimal("revenue_per_station"))
                .avgTransactionsPerStation(rs.getBigDecimal("avg_transactions_per_station"))
                .boardingAlightingRatio(rs.getBigDecimal("boarding_alighting_ratio"))
                .build(), startDate, endDate);
    }

    public List<LineTopStationResponse> getLineTopStations(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_LINE_STN FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, line_no, station_rank
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> LineTopStationResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .lineNo(rs.getInt("line_no"))
                .stationNo(rs.getString("station_no"))
                .stationRank(rs.getInt("station_rank"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .build(), startDate, endDate);
    }

    public List<BoardingStationResponse> getBoardingStations(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_BRD_STN_DAILY FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, boarding_station_no
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> BoardingStationResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .boardingStationNo(rs.getString("boarding_station_no"))
                .totalBoardingCnt(rs.getLong("total_boarding_cnt"))
                .usageSharePct(rs.getBigDecimal("usage_share_pct"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .revenuePerBoarding(rs.getBigDecimal("revenue_per_boarding"))
                .revenueSharePct(rs.getBigDecimal("revenue_share_pct"))
                .build(), startDate, endDate);
    }

    public List<CardDailyResponse> getCardDaily(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_CARD_DAILY FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, card_type
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> CardDailyResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .cardType(rs.getString("card_type"))
                .totalCnt(rs.getLong("total_cnt"))
                .avgFare(rs.getInt("avg_fare"))
                .totalRev(rs.getLong("total_rev"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .build(), startDate, endDate);
    }

    public List<DayLineResponse> getDayLines(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_DAY_LINE FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, day_of_week_num, line_no
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> DayLineResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .dayOfWeekNum(rs.getInt("day_of_week_num"))
                .dayOfWeekName(rs.getString("day_of_week_name"))
                .lineNo(rs.getInt("line_no"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .build(), startDate, endDate);
    }

    public List<DateTicketResponse> getDateTickets(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_DATE_TICKET FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, ticket_type
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> DateTicketResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .ticketType(rs.getString("ticket_type"))
                .totalCnt(rs.getLong("total_cnt"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .alightingCnt(rs.getLong("alighting_cnt"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .paidCnt(rs.getLong("paid_cnt"))
                .freeCnt(rs.getLong("free_cnt"))
                .paidPct(rs.getBigDecimal("paid_pct"))
                .build(), startDate, endDate);
    }

    public List<HourTicketResponse> getHourTickets(LocalDate startDate, LocalDate endDate) {
        String sql = """
                SELECT * FROM busan_bigdata.GENTRDT_COMP_HOUR_TICKET FINAL
                WHERE trade_dt BETWEEN ? AND ?
                ORDER BY trade_dt, hour_range, ticket_type
                """;
        return clickHouseJdbcTemplate.query(sql, (rs, rowNum) -> HourTicketResponse.builder()
                .tradeDt(rs.getDate("trade_dt").toLocalDate())
                .hourRange(rs.getInt("hour_range"))
                .ticketType(rs.getString("ticket_type"))
                .boardingCnt(rs.getLong("boarding_cnt"))
                .totalRev(rs.getLong("total_rev"))
                .avgFare(rs.getInt("avg_fare"))
                .build(), startDate, endDate);
    }
}
