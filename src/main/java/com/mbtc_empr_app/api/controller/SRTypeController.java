package com.mbtc_empr_app.api.controller;

import java.util.List;

import com.mbtc_empr_app.api.dto.SRTypeDTO;
import com.mbtc_empr_app.api.service.SRTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/SRTypes")
public class SRTypeController {

    @Autowired
    private SRTypeService SRTypeService;

    @GetMapping
	public List<SRTypeDTO> fetchSRTypes() {
		return this.SRTypeService.getSRTypes();
	}

}
