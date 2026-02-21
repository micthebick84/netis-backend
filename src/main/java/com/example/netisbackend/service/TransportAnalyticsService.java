package com.example.netisbackend.service;

import com.example.netisbackend.dto.transport.*;
import com.example.netisbackend.dto.transport.stats.*;
import com.example.netisbackend.mapper.transport.TransportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportAnalyticsService {

    private final TransportMapper transportMapper;

    // ===== 기존 원본 데이터 조회 =====

    public List<DailySummaryResponse> getDailySummary(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectDailySummary(startDate, endDate);
    }

    public List<HourlySummaryResponse> getHourlySummary(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectHourlySummary(startDate, endDate);
    }

    public List<StationDailyResponse> getStationDaily(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectStationDaily(startDate, endDate);
    }

    public List<RouteDailyResponse> getRouteDaily(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectRouteDaily(startDate, endDate);
    }

    public List<LineTopStationResponse> getLineTopStations(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectLineTopStations(startDate, endDate);
    }

    public List<BoardingStationResponse> getBoardingStations(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectBoardingStations(startDate, endDate);
    }

    public List<CardDailyResponse> getCardDaily(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectCardDaily(startDate, endDate);
    }

    public List<DayLineResponse> getDayLines(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectDayLines(startDate, endDate);
    }

    public List<DateTicketResponse> getDateTickets(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectDateTickets(startDate, endDate);
    }

    public List<HourTicketResponse> getHourTickets(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectHourTickets(startDate, endDate);
    }

    // ===== Stats 집계 =====

    public List<DayOfWeekStatsResponse> getDayOfWeekStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectDayOfWeekStats(startDate, endDate);
    }

    public List<HourlyStatsResponse> getHourlyStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectHourlyStats(startDate, endDate);
    }

    public List<TicketTypeStatsResponse> getTicketTypeStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectTicketTypeStats(startDate, endDate);
    }

    public List<CardTypeStatsResponse> getCardTypeStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectCardTypeStats(startDate, endDate);
    }

    public List<TopBoardingStationStatsResponse> getTopBoardingStationStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectTopBoardingStationStats(startDate, endDate);
    }

    public List<StationImbalanceStatsResponse> getStationImbalanceStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectStationImbalanceStats(startDate, endDate);
    }

    public List<RouteEfficiencyStatsResponse> getRouteEfficiencyStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectRouteEfficiencyStats(startDate, endDate);
    }

    public List<HourTicketCrossResponse> getHourTicketCrossStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectHourTicketCrossStats(startDate, endDate);
    }

    public List<FreeFareStatsResponse> getFreeFareStats(LocalDate startDate, LocalDate endDate) {
        return transportMapper.selectFreeFareStats(startDate, endDate);
    }

    public RawDataSummaryResponse getRawDataSummary(LocalDate startDate, LocalDate endDate) {
        RawDataSummaryResponse result = transportMapper.selectRawDataSummary(startDate, endDate);
        return result != null ? result
                : RawDataSummaryResponse.builder()
                        .totalCnt(0L).tradeDateCnt(0L).stationCnt(0L).routeCnt(0L).cardCnt(0L)
                        .build();
    }
}
