package uzdigitl.one.springbootappsupermarket.cron;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.ProductDataDto;
import uzdigitl.one.springbootappsupermarket.service.DashBoardService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CronTask {

    private final DashBoardService dashBoardService;

    @Scheduled(fixedDelay = 86_400_000L, initialDelay = 5000L)
    public void checkExparitionDataProducts(){
        List<ProductDataDto> data = dashBoardService.forGetAllExpireDataSoonProducts();
        for (ProductDataDto dto : data){

        }

    }

}
