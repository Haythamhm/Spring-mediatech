package com.springhayth.mediatech.Controller;


import com.springhayth.mediatech.Dto.FactureDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("factures")
public class FactureController {

    @PostMapping("")
    public String create(@RequestBody FactureDto factureDto) {
        return "";
    }


}
