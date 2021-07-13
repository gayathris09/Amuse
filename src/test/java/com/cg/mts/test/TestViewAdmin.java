package com.cg.mts.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.AdminNotFoundException;
import com.cg.mts.Repository.IAdminRepository;
import com.cg.mts.Service.AdminServiceImp;
import com.cg.mts.Service.IAdminService;
import com.cg.mts.entities.Admin;

@SpringBootTest
public class TestViewAdmin {
	@Mock
	private IAdminRepository adminDao;

	@InjectMocks
	private IAdminService adminService = new AdminServiceImp();

	@BeforeEach
	public void berforeEach() {
		when(adminDao.findById(3)).thenReturn(Optional.of(new Admin()));
		when(adminDao.findById(4)).thenReturn(Optional.empty());
	}

	@Test
	public void testViewAdmin1() throws AdminNotFoundException {
		assertThrows(AdminNotFoundException.class, () -> adminService.getAllAdmin());
	}

	@Test
	public void testViewAdmin2() throws AdminNotFoundException {
		assertThrows(AdminNotFoundException.class, () -> adminService.getAllAdmin());
	}

}