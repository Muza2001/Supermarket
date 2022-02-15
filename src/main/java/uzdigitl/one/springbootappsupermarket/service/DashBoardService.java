package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.Response;

import java.time.LocalDateTime;

public interface DashBoardService {

    Response getIncomeByDataRange(LocalDateTime start, LocalDateTime end);
}
