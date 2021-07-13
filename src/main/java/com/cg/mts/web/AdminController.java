package com.cg.mts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Exception.AdminNotFoundException;
import com.cg.mts.Service.AdminServiceImp;
import com.cg.mts.dto.AdminDto;
import com.cg.mts.dto.SuccessMessageDto;
import com.cg.mts.entities.Admin;
import com.cg.mts.util.AdminConstants;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImp adminService;

	/*
	 * Method Name : insertAdmin Parameter : admindto Return Type : Admin Author
	 * Name: Aarthi Myadam Created Date : 23-05-2021
	 */
	@RequestMapping(value = "/addadmin", method = RequestMethod.POST)
	public SuccessMessageDto addAdmin(@RequestBody AdminDto admindto) throws AdminNotFoundException {
		Admin admin = adminService.insertAdmin(admindto);
		return new SuccessMessageDto(AdminConstants.ADMIN_ADDED + admin.getAdminId());
	}

	/*
	 * Method Name : getAllAdmin Parameter : No Parameter Return Type : List Author
	 * Name: Aarthi Myadam Created Date : 24-05-2021
	 */

	@GetMapping("/getalladmin")
	public List<Admin> getAllAdmin() throws AdminNotFoundException {
		return adminService.getAllAdmin();
	}

	/*
	 * Method Name : updateAdmin Parameter : adminDto Return Type : Admin Author
	 * Name: Aarthi Myadam Created Date : 26-05-2021
	 */
	@PutMapping("/updateadmin")
	public SuccessMessageDto updateAdmin(@RequestBody AdminDto admindto) throws AdminNotFoundException {
		Admin admin = adminService.updateAdmin(admindto);
		return new SuccessMessageDto(AdminConstants.ADMIN_UPDATED + admin.getAdminId());
	}

}