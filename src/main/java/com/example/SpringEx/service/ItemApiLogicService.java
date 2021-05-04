package com.example.SpringEx.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringEx.ifs.CrudInterface;
import com.example.SpringEx.model.entity.Item;
import com.example.SpringEx.model.network.Header;
import com.example.SpringEx.model.network.request.ItemApiRequest;
import com.example.SpringEx.model.network.response.ItemApiResponse;
import com.example.SpringEx.repository.ItemRepository;
import com.example.SpringEx.repository.PartnerRepository;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

		ItemApiRequest body = request.getData();
		
		Item item = Item.builder()
				.status(body.getStatus())
				.name(body.getName())
				.title(body.getTitle())
				.content(body.getContent())
				.price(body.getPrice())
				.brandName(body.getBrandName())
				.registeredAt(null)
				.partner(partnerRepository.getOne(body.getPartnerId()))
				.build();
		Item newItem = itemRepository.save(item);
	
		return response(newItem);
	}

	@Override
	public Header<ItemApiResponse> read(Long id) {
		return itemRepository.findById(id)
			.map(item -> response(item)) //map time이 있다면 response에 item을 넣어 반환하고 
			.orElseGet(()-> Header.ERROR("데이터 없음")); //없다면 header에 데이터 없음을 오류 메시지
	}

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
		
		ItemApiRequest itemApiRequest = request.getData();
		return itemRepository.findById(itemApiRequest.getId())
		.map(item -> {
			item.setStatus(itemApiRequest.getStatus())
				.setName(itemApiRequest.getName())
				.setTitle(itemApiRequest.getTitle())
				.setContent(itemApiRequest.getContent())
				.setPrice(itemApiRequest.getPrice())
				.setBrandName(itemApiRequest.getBrandName())
				.setRegisteredAt(itemApiRequest.getRegisteredAt())
				.setUnregisteredAt(itemApiRequest.getUnregisteredAt());
			return item;
		})
		.map(item -> itemRepository.save(item))
		.map(item -> response(item))
		.orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header delete(Long id) {
		Optional<Item> getItem = itemRepository.findById(id);
		return getItem.map(item -> {
			itemRepository.delete(item);
			return Header.OK();
		})
		.orElseGet( () -> Header.ERROR("데이터 없음"));
	}

	private Header<ItemApiResponse> response(Item item) {
		
		ItemApiResponse body = ItemApiResponse.builder()
				.id(item.getId())
				.status(item.getStatus())
				.name(item.getName())
				.title(item.getTitle())
				.content(item.getContent())
				.price(item.getPrice())
				.brandName(item.getBrandName())
				.registeredAt(null)
				.partnerId(item.getPartner().getId())
				.build();
		
		return Header.OK(body);
	}
}
