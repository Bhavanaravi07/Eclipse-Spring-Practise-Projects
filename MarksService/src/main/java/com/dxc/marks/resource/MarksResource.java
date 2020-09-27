package com.dxc.marks.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.marks.model.Marks;


@RestController
@RequestMapping("/marks")
public class MarksResource{


	@RequestMapping("/{id}")	
	public List<Marks> getMarks(@PathVariable("id")int studid){
		List<Marks> marks = Arrays.asList(
				new Marks(101,501,65,89),
				new Marks(101,502,54,97),
				new Marks(102,501,76,87),
				new Marks(102,502,88,65)
						);
				
		return marks.stream()
				.filter(mark -> mark.getStudid()== studid)
				.collect(Collectors.toList());
		
	}

	

}
