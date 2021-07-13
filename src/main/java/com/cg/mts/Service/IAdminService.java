package com.cg.mts.Service;

import java.util.List;

import com.cg.mts.Exception.AdminNotFoundException;
import com.cg.mts.dto.AdminDto;
import com.cg.mts.entities.Admin;

public interface IAdminService {
	public List<Admin> getAllAdmin() throws AdminNotFoundException;

	public Admin insertAdmin(AdminDto admindto) throws AdminNotFoundException;

	public Admin updateAdmin(AdminDto admindto) throws AdminNotFoundException;

}
