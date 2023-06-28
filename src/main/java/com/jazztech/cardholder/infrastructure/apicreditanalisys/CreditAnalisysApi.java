package com.jazztech.cardholder.infrastructure.apicreditanalisys;

import com.jazztech.cardholder.infrastructure.apicreditanalisys.dto.CreditAnalisysDto;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "creditAnalisysApi", url = "http://localhost:8081/api/v1/credits/analysis")
public interface CreditAnalisysApi {

    @GetMapping("/search?clientId={clientid}")
    List<CreditAnalisysDto> getCreditAnalisysById(@PathVariable("clientid") UUID clientid);
}
