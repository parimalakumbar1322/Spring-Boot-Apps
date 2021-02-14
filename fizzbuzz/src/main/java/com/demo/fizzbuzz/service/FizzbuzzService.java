package com.demo.fizzbuzz.service;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

import com.demo.fizzbuzz.domain.Fizzbuzz;

@Service
public class FizzbuzzService {

	public ArrayList<Fizzbuzz> generateFizzbuzz(long startRange, long stopRange) {
		
		ArrayList<Fizzbuzz> fizzbuzzList= new ArrayList<Fizzbuzz>();
		
		LongStream.rangeClosed(startRange, stopRange)
	    .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? fizzbuzzList.add(new Fizzbuzz(i,"fizzbuzz")) : fizzbuzzList.add(new Fizzbuzz(i,"fizz"))) : (i % 5 == 0 ? fizzbuzzList.add(new Fizzbuzz(i,"buzz")) : fizzbuzzList.add(new Fizzbuzz(i,Long.toString(i)))))
		.forEach(System.out::println);
		return fizzbuzzList;
	}
}
