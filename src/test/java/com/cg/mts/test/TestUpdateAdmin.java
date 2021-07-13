package com.cg.mts.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.AdminNotFoundException;
import com.cg.mts.Repository.IAdminRepository;
import com.cg.mts.Service.AdminServiceImp;
import com.cg.mts.Service.IAdminService;
import com.cg.mts.dto.AdminDto;
import com.cg.mts.entities.Admin;

@SpringBootTest
public class TestUpdateAdmin {
	@Mock
	private IAdminRepository adminDao;

	@InjectMocks
	private IAdminService adminService = new AdminServiceImp();

	@BeforeEach
	public void berforeEach() {
		when(adminDao.findById(1)).thenReturn(Optional.of(new Admin()));
		when(adminDao.findById(2)).thenReturn(Optional.empty());
		when(adminDao.save(any(Admin.class))).thenReturn(new Admin());

	}

	@Test
	public void testUpdateAdmin1() throws AdminNotFoundException {
		AdminDto dto = new AdminDto(1, "jyothsna", "jyothsna@13", "7893403126", "jyothsna@gmail.com", "hyderabad");

		assertNotNull(adminService.updateAdmin(dto));

	}

	@Test
	public void testUpdateAdmin2() throws AdminNotFoundException {
		AdminDto dto = new AdminDto(2, "jyothsna", "jyothsna@13", " ", "jyothsna@gmail.com", "hyderabad");
		assertThrows(AdminNotFoundException.class, () -> adminService.updateAdmin(dto));

	}

}