package com.demo.fizzbuzz.controller;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fizzbuzz.domain.Fizzbuzz;
import com.demo.fizzbuzz.service.FizzbuzzService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "REST Apis related to Fizzbuzz problem!", tags="Fizzbuzz")
@RestController
@RequestMapping("/demo")
public class FizzbuzzController {

	
	@Autowired
	FizzbuzzService fizzbuzzService;
	
	@GetMapping(value="/fizzbuzz", produces={"application/json"})
	public ResponseEntity<ArrayList<Fizzbuzz>> getFizzbuzzList(@RequestParam(name="startRange", required=true)  int startRange,@RequestParam(name="stopRange", required=true) int stopRange) {
		return ResponseEntity.ok(fizzbuzzService.generateFizzbuzz(startRange, stopRange));
	
}
}
