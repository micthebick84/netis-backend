package com.example.netisbackend.mapper.transport;

import com.example.netisbackend.dto.transport.*;
import com.example.netisbackend.dto.transport.stats.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TransportMapper {

    // ===== 기존 원본 데이터 조회 =====

    List<DailySummaryResponse> selectDailySummary(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<HourlySummaryResponse> selectHourlySummary(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<StationDailyResponse> selectStationDaily(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<RouteDailyResponse> selectRouteDaily(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<LineTopStationResponse> selectLineTopStations(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<BoardingStationResponse> selectBoardingStations(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<CardDailyResponse> selectCardDaily(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<DayLineResponse> selectDayLines(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<DateTicketResponse> selectDateTickets(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<HourTicketResponse> selectHourTickets(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    // ===== Stats 집계 쿼리 =====

    List<DayOfWeekStatsResponse> selectDayOfWeekStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<HourlyStatsResponse> selectHourlyStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<TicketTypeStatsResponse> selectTicketTypeStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<CardTypeStatsResponse> selectCardTypeStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<TopBoardingStationStatsResponse> selectTopBoardingStationStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<StationImbalanceStatsResponse> selectStationImbalanceStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<RouteEfficiencyStatsResponse> selectRouteEfficiencyStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<HourTicketCrossResponse> selectHourTicketCrossStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    List<FreeFareStatsResponse> selectFreeFareStats(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    RawDataSummaryResponse selectRawDataSummary(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );
}
