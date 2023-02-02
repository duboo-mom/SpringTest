package com.duboomom.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duboomom.spring.test.ajax.bo.BookingBO;
import com.duboomom.spring.test.ajax.model.Booking;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/list";
	}
	
	// 삭제 api
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingBO.deleteBooking(id);
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return "ajax/booking/main";
	}
	
	// 데이터 전달받고 저장하는 api
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name") String name
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// {"result":"success"}
		// {"result":"fail"}
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "ajax/booking/input";
	}
	
	// 이름 전화번호 전달 받고, 일치하는 결과 하나를 json 형태로 변환해서 리스펀스에 담는다.
	@GetMapping("/find")
	@ResponseBody
	public Map<String, Object> findBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.findBooking(name, phoneNumber);
		
		Map<String, Object> status = new HashMap<>(); 
		
		Map<String, Object> map = new HashMap<>();		
		if(booking != null) {			
			map.put("name", booking.getName());
			map.put("date", booking.getDate());
			map.put("day", booking.getDay());
			map.put("headcount", booking.getHeadcount());
			map.put("state", booking.getState());		
		} else {
			map.put("result", "fail");
		}
				
		return map;	
		
	}
	
}
