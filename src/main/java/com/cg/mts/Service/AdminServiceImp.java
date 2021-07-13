package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.Exception.AdminNotFoundException;
import com.cg.mts.Repository.IAdminRepository;
import com.cg.mts.dto.AdminDto;
import com.cg.mts.entities.Admin;
import com.cg.mts.util.AdminConstants;
import com.cg.mts.util.ValidateConstants;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;

	/*
	 * Method Name : insertAdmin Parameter : admindto Return Type : Admin Author
	 * Name: Aarthi Myadam Created Date : 23-05-2021
	 */
	@Override
	public Admin insertAdmin(AdminDto adminDto) throws AdminNotFoundException {
		validateAdmin(adminDto);
		Admin admin = new Admin();
		admin.setAdminId(adminDto.getAdminId());
		admin.setUsername(adminDto.getUsername());
		admin.setPassword(adminDto.getPassword());
		admin.setMobileNumber(adminDto.getMobileNumber());
		admin.setEmail(adminDto.getEmail());
		admin.setAddress(adminDto.getAddress());

		return adminRepository.save(admin);

	}

	/*
	 * Method Name : updateAdmin Parameter : adminDto Return Type : Admin Author
	 * Name: Aarthi Myadam Created Date : 26-05-2021
	 */
	@Override
	public Admin updateAdmin(AdminDto adminDto) throws AdminNotFoundException {
		validateAdmin(adminDto);
		Optional<Admin> optAdmin = adminRepository.findById(adminDto.getAdminId());
		if (!optAdmin.isPresent())
			throw new AdminNotFoundException(AdminConstants.ADMIN_NOT_FOUND);
		Admin admin = optAdmin.get();
		admin.setAdminId(adminDto.getAdminId());
		admin.setUsername(adminDto.getUsername());
		admin.setPassword(adminDto.getPassword());
		admin.setMobileNumber(adminDto.getMobileNumber());
		admin.setEmail(adminDto.getEmail());
		admin.setAddress(adminDto.getAddress());
		return adminRepository.save(admin);

	}

	/*
	 * Method Name : validateAdmin Parameter : adminDto Return Type : boolean Author
	 * Name: Aarthi Myadam Created Date : 28-05-2021
	 */
	public boolean validateAdmin(AdminDto adminDto) throws AdminNotFoundException {
		if (!adminDto.getUsername().matches(ValidateConstants.USERNAME_PATTERN))
			throw new AdminNotFoundException(AdminConstants.USERNAME_CANNOT_BE_EMPTY);
		if (!adminDto.getEmail().matches(ValidateConstants.EMAIL_PATTERN))
			throw new AdminNotFoundException(AdminConstants.INVALID_EMAIL_PATTERN);
		if (!adminDto.getMobileNumber().matches(ValidateConstants.MOBILENUMBER_PATTERN))
			throw new AdminNotFoundException(AdminConstants.INVALID_MOBILE);

		return true;

	}

	/*
	 * Method Name : getAllAdmin Parameter : No Parameter Return Type : List Author
	 * Name: Aarthi Myadam Created Date : 24-05-2021
	 */
	@Override
	public List<Admin> getAllAdmin() throws AdminNotFoundException {
		List<Admin> adminlist = adminRepository.findAll();
		if (adminlist.isEmpty())
			throw new AdminNotFoundException(AdminConstants.ADMIN_IS_EMPTY);
		return adminlist;

	}

}