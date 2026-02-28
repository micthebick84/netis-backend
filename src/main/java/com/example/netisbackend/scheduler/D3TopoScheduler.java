package com.example.netisbackend.scheduler;

import com.example.netisbackend.service.topology.DumpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class D3TopoScheduler {

    private final DumpService dumpService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void dailyBackup() {
        log.info("Topology daily backup started");
        dumpService.addDumpBySystem("admin", 1L, "시스템 자동 백업");
        log.info("Topology daily backup completed");
    }
}
