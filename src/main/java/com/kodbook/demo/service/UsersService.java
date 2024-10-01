package com.kodbook.demo.service;

import com.kodbook.demo.entity.Users;

public interface UsersService 
{
	public boolean getUser(String email, String username);
	
	public String addUser(Users user);

	public Users fetchUser(String email);

}
