package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uzdigitl.one.springbootappsupermarket.dto.Response;
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
    public Response getIncomeDataRange(@RequestParam("start") LocalDate startData,
                                       @RequestParam("end") LocalDate endData){

        LocalDateTime start = startData.atStartOfDay();
        LocalDateTime end = endData.atStartOfDay().plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.SECONDS);
        return dashBoardService.getIncomeByDataRange(start,end);
    }

}
