package com.mbtc_empr_app.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mbtc_empr_app.api.dto.DeveloperDTO;
import com.mbtc_empr_app.api.entity.Developer;
import com.mbtc_empr_app.api.repositroy.DepartmentRepository;
import com.mbtc_empr_app.api.repositroy.DeveloperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {
    @Autowired 
    private DeveloperRepository developerRepository;

    @Autowired 
    private DepartmentRepository departmentRepository;

    public List<DeveloperDTO> getDevelopers() {
      return this.DevDTOListConversion(this.developerRepository.findAll());
    }

    public DeveloperDTO getDeveloper(Integer developerID) { 
      if(developerID <= 0) throw new IllegalStateException("Invalid id " + developerID);
      DeveloperDTO foundDeveloperDTO = DevDTOConversion(this.developerRepository.findById(developerID).orElseThrow(
        () -> new IllegalStateException("Developer with id " + developerID + " does not exist")
      ));
      return foundDeveloperDTO;
    }

    public void saveDeveloper(DeveloperDTO developerDTO){
      this.developerRepository.save(DevEntityConversion(developerDTO));
    }

    public void deleteDeveloper(Integer developerID) { 
      DeveloperDTO foundDeveloperDTO = this.getDeveloper(developerID);
      foundDeveloperDTO.IsActive = 0;
      this.saveDeveloper(foundDeveloperDTO);
    }

    public DeveloperDTO DevDTOConversion(Developer developer){
		  DeveloperDTO developerDTO = new DeveloperDTO();
      developerDTO.DeveloperID = developer.getDeveloperID();
      developerDTO.EmployeeID = developer.getEmployeeID();
      developerDTO.FirstName = developer.getFirstName();
      developerDTO.MiddleName = developer.getMiddleName();
      developerDTO.LastName = developer.getLastName();
      developerDTO.DateHire = developer.getDateHire();
      developerDTO.IsActive = developer.getIsActive();
      developerDTO.MetrobankEmail = developer.getMetrobankEmail();
      developerDTO.HomeAddress = developer.getHomeAddress();
      developerDTO.CityProvince = developer.getCityProvince();
      developerDTO.ContactNumber = developer.getContactNumber();
      developerDTO.DepartmentID = developer.getDepartmentID();
      developerDTO.SupervisorID = developer.getSupervisorID();
      developerDTO.DateCreated = developer.getDateCreated();
      developerDTO.CreatedBy = developer.getCreatedBy();
      developerDTO.DateModified = developer.getDateModified();
      developerDTO.ModifiedBy = developer.getModifiedBy();
      if (developer.getDepartmentID() != null) 
        developerDTO.DepartmentName = this.departmentRepository.findById(developer.getDepartmentID()).get().getDepartmentName();
      if (developer.getSupervisorID() != null) 
        developerDTO.SupervisorName = this.developerRepository.findById(developer.getSupervisorID()).get().getFullName();
		  return developerDTO;
	}
  public List<DeveloperDTO> DevDTOListConversion(List<Developer> developers){
      return developers.stream().map(developer -> DevDTOConversion(developer)).collect(Collectors.toList());
  }

  public Developer DevEntityConversion(DeveloperDTO developerDTO){
      Developer developer = new Developer();
      developer.setDeveloperID(developerDTO.DeveloperID);
      developer.setEmployeeID(developerDTO.EmployeeID);
      developer.setFirstName(developerDTO.FirstName);
      developer.setMiddleName(developerDTO.MiddleName);
      developer.setLastName(developerDTO.LastName);
      developer.setDateHire(developerDTO.DateHire);
      developer.setIsActive(developerDTO.IsActive);
      developer.setMetrobankEmail(developerDTO.MetrobankEmail);
      developer.setHomeAddress(developerDTO.HomeAddress);
      developer.setCityProvince(developerDTO.CityProvince);
      developer.setContactNumber(developerDTO.ContactNumber);
      developer.setDepartmentID(developerDTO.DepartmentID);
      developer.setSupervisorID(developerDTO.SupervisorID);
      developer.setDateCreated(developerDTO.DateCreated);
      developer.setCreatedBy(developerDTO.CreatedBy);
      developer.setDateModified(developerDTO.DateModified);
      developer.setModifiedBy(developerDTO.ModifiedBy);
      return developer;
	}
	public List<Developer> DevEntityListConversion(List<DeveloperDTO> developersDTO){
		  return developersDTO.stream().map(developer -> DevEntityConversion(developer)).collect(Collectors.toList());
	}
}
