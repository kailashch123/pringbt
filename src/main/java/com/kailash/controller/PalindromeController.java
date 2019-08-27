package com.kailash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PalindromeController {
	
	@GetMapping
	public String noInput() {
		return "No input available";
	}

	@GetMapping(value = "/{inputString}")
	public String isPalindrome(@PathVariable String inputString) {
		String res = "PALINDROME:";
		if((inputString == null) || (inputString.length() == 0)) {
			res = "No Input";
		} else {
			String original, reverse = "";
			original = inputString;
			int length = original.length();
			for (int i = length - 1; i >= 0; i--) {
				reverse = reverse + original.charAt(i);
			}
			if (original.equals(reverse)) {
				res = res + "TRUE";
			} else {
				res = res + "FALSE";
			}
		}
		return res;
	}
}
