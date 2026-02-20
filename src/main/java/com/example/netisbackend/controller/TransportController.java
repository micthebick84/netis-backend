package com.example.netisbackend.controller;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.dto.transport.*;
import com.example.netisbackend.dto.transport.stats.*;
import com.example.netisbackend.service.TransportAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transport")
@RequiredArgsConstructor
public class TransportController {

    private final TransportAnalyticsService transportService;

    @GetMapping("/daily")
    public ApiResponse<List<DailySummaryResponse>> getDailySummary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getDailySummary(startDate, endDate));
    }

    @GetMapping("/hourly")
    public ApiResponse<List<HourlySummaryResponse>> getHourlySummary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getHourlySummary(startDate, endDate));
    }

    @GetMapping("/stations")
    public ApiResponse<List<StationDailyResponse>> getStationDaily(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getStationDaily(startDate, endDate));
    }

    @GetMapping("/routes")
    public ApiResponse<List<RouteDailyResponse>> getRouteDaily(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getRouteDaily(startDate, endDate));
    }

    @GetMapping("/lines/top-stations")
    public ApiResponse<List<LineTopStationResponse>> getLineTopStations(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getLineTopStations(startDate, endDate));
    }

    @GetMapping("/boarding-stations")
    public ApiResponse<List<BoardingStationResponse>> getBoardingStations(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getBoardingStations(startDate, endDate));
    }

    @GetMapping("/cards")
    public ApiResponse<List<CardDailyResponse>> getCardDaily(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getCardDaily(startDate, endDate));
    }

    @GetMapping("/day-lines")
    public ApiResponse<List<DayLineResponse>> getDayLines(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getDayLines(startDate, endDate));
    }

    @GetMapping("/tickets/daily")
    public ApiResponse<List<DateTicketResponse>> getDateTickets(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getDateTickets(startDate, endDate));
    }

    @GetMapping("/tickets/hourly")
    public ApiResponse<List<HourTicketResponse>> getHourTickets(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getHourTickets(startDate, endDate));
    }

    // ===== Stats endpoints =====

    @GetMapping("/stats/day-of-week")
    public ApiResponse<List<DayOfWeekStatsResponse>> getDayOfWeekStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getDayOfWeekStats(startDate, endDate));
    }

    @GetMapping("/stats/hourly")
    public ApiResponse<List<HourlyStatsResponse>> getHourlyStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getHourlyStats(startDate, endDate));
    }

    @GetMapping("/stats/ticket-type")
    public ApiResponse<List<TicketTypeStatsResponse>> getTicketTypeStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getTicketTypeStats(startDate, endDate));
    }

    @GetMapping("/stats/card-type")
    public ApiResponse<List<CardTypeStatsResponse>> getCardTypeStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getCardTypeStats(startDate, endDate));
    }

    @GetMapping("/stats/top-boarding-stations")
    public ApiResponse<List<TopBoardingStationStatsResponse>> getTopBoardingStationStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getTopBoardingStationStats(startDate, endDate));
    }

    @GetMapping("/stats/station-imbalance")
    public ApiResponse<List<StationImbalanceStatsResponse>> getStationImbalanceStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getStationImbalanceStats(startDate, endDate));
    }

    @GetMapping("/stats/route-efficiency")
    public ApiResponse<List<RouteEfficiencyStatsResponse>> getRouteEfficiencyStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getRouteEfficiencyStats(startDate, endDate));
    }

    @GetMapping("/stats/hour-ticket-cross")
    public ApiResponse<List<HourTicketCrossResponse>> getHourTicketCrossStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getHourTicketCrossStats(startDate, endDate));
    }

    @GetMapping("/stats/free-fare")
    public ApiResponse<List<FreeFareStatsResponse>> getFreeFareStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getFreeFareStats(startDate, endDate));
    }

    @GetMapping("/stats/raw-summary")
    public ApiResponse<RawDataSummaryResponse> getRawDataSummary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ApiResponse.success(transportService.getRawDataSummary(startDate, endDate));
    }
}
