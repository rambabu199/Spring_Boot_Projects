package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Owner;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.services.OwnerServicesInterface;

public class OwnerServiceImpl implements OwnerServicesInterface{
	
	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public String addownerdeatils(Owner owner) {
		ownerRepo.save(owner);
		return "owner details added successfully";
	}

	@Override
	public String updateownerdetails(Owner owner, int id) {
		if(ownerRepo.existsById(id))
		{
			Owner exsitedowner=ownerRepo.findById(id).get();
			exsitedowner.setAddress(owner.getAddress());
			exsitedowner.setCompanyname(owner.getCompanyname());
			exsitedowner.setOwnermobile(owner.getOwnermobile());
			exsitedowner.setOwnername(owner.getOwnername());
			ownerRepo.save(exsitedowner);
			return "owner details with "+id+" updated successfully";
		}
		else
		return "no owner records found with id number:"+id;
	}

}
