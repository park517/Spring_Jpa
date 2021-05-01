package com.example.SpringEx.ifs;

import com.example.SpringEx.model.network.Header;
import com.example.SpringEx.model.network.response.UserApiResponse;

public interface CrudInterface<Req,Res> {

	Header <Res> create(Header<Req> request); //todo request object 추가
	
	Header <Res> read(Long id);
	
	Header <Res> update(Header<Req> request);
	
	Header <Res> delete(Long id);
}
