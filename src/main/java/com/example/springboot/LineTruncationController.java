package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays; 
import java.util.Comparator; 
import java.util.ArrayList;
import java.util.List;

@RestController
public class LineTruncationController {

	@RequestMapping("/linetruncation/")
	public String index(@RequestParam("line") String lineData) {

		String strOutput = lineData;

		if(lineData.length() > 25)
		{	
			String[] arrFilter = {"allee", "allee.", "alley", "alley.", "ally", "ally.", "aly."};

			String strWords = lineData.trim().replaceAll("\\s{2,}", " ");
			String[] arrWords = strWords.split(" ", 0);

			List<String> listOutput = new ArrayList<String>(); 
			List<String> listFilters = Arrays.asList(arrFilter);


			String strWord = "";
			for(int i = 0; i < arrWords.length; i++)
			{
				strWord = arrWords[i];
				if(listFilters.contains(strWord)){
					strWord = "aly";
				}
				listOutput.add(strWord);
			}
			strOutput = String.join(" ", listOutput);
		}

		return strOutput;
	}
}
