package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;
import uzdigitl.one.springbootappsupermarket.service.DashBoardService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/dashboard")
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @RequestMapping(value = "/income_data_range", method = RequestMethod.POST)
    public ResponseEntity<?> getIncomeDataRange(@RequestParam("start") LocalDate startData,
                                             @RequestParam("end") LocalDate endData,
                                             @RequestParam("type")InputOutputType type){

        LocalDateTime start = startData.atStartOfDay();
        LocalDateTime end = endData.atStartOfDay().plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.SECONDS);
        return dashBoardService.getIncomeByDataRange(start,end, type);
    }
    @RequestMapping(value = "/income_data_range/top10", method = RequestMethod.POST)
    public ResponseEntity<?> getIncomeDataRangeTop10(@RequestParam("start") LocalDate startData,
                                       @RequestParam("end") LocalDate endData,
                                       @RequestParam("type")InputOutputType type){

        LocalDateTime start = startData.atStartOfDay();
        LocalDateTime end = endData.atStartOfDay().plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.SECONDS);
        return dashBoardService.getTop10InputOutputByDataRange(start,end, type);
    }

    @GetMapping("/expire_data/list")
    public ResponseEntity<?> getExperiDataList(){
        return dashBoardService.getAllExpireDataSoonProducts();
    }

}
