package com.cmc.gdp05.group4.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cmc.gdp05.group4.entity.Role;
import com.cmc.gdp05.group4.repository.RoleRepository;



@Component
public class RoleValidation implements Validator {

	@Autowired
	private RoleRepository roleRepository;

	public boolean supports(Class<?> clazz) {
		return Role.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Role role = (Role) target;
		if (role.getName() == null || role.getName().length() == 0) {
			errors.rejectValue("name", "role.name.required", "Tên không được để trống");

		}
		List<Role> listRole = roleRepository.findByName(role.getName());
		if (!listRole.isEmpty()) {
			errors.rejectValue("name", "role.name.duplication", "Tên đã tồn tại");
		}

	}

	public void validateUpdate(Object target, Errors errors) {

		Role role = (Role) target;
		if (role.getName() == null || role.getName().length() == 0) {
			errors.rejectValue("name", "role.name.required", "Tên không được để trống");

		}
		List<Role> listRole= roleRepository.findByIdNotAndName(role.getId(),role.getName());
				//(role.getId(),role.getName());
		if (listRole.size() != 0) {
			errors.rejectValue("name", "role.name.duplication", "Tên đã tồn tại");
		}

	}

}
