package com.cmc.gdp05.group4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cmc.gdp05.group4.entity.Permission;
import com.cmc.gdp05.group4.entity.Role;
import com.cmc.gdp05.group4.entity.RolePermission;
import com.cmc.gdp05.group4.service.impl.PermissionServiceImpl;
import com.cmc.gdp05.group4.service.impl.RoleServiceImpl;
import com.cmc.gdp05.group4.validation.RoleValidation;

@Controller
public class RoleController {

	@Autowired
	private PermissionServiceImpl permissionService;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@Autowired
	private RoleValidation roleValidation;

	@Autowired
	private MessageSource messageSource;

	public RoleController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping(value = "/role/list")
	public String list(Model model) {
		List<Role> roles = roleServiceImpl.findAll();
		model.addAttribute("roles", roles);

		return "admin/roles/list";
	}

	@GetMapping(value = "/role/create")
	public String create(ModelMap modelMap) {

		List<Permission> permissions = permissionService.getListAllPermission();
		modelMap.addAttribute("permissions", permissions);
		modelMap.addAttribute("role", new Role());
		return "admin/roles/add";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/role/create")
	public String store(@ModelAttribute("role") Role role, @PathParam("permission_id") String[] permission_id,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		roleValidation.validate(role, bindingResult);
		if (bindingResult.hasErrors()) {

			// redirectAttributes.addFlashAttribute(bindingResult);
			return "redirect:/role/create";
		}

		List<RolePermission> permissions = null;
		if (permission_id != null) {
			permissions = new ArrayList<>();
			for (int i = 0; i < permission_id.length; i++) {
				RolePermission permiss = new RolePermission();
				permiss.setPermissionID(Integer.parseInt(permission_id[i]));
				permissions.add(permiss);

			}
		}
		boolean isSuccess = roleServiceImpl.insertRole(role, permissions);
		String message = messageSource.getMessage("role.error.create", null, "", null);
		if (isSuccess) {
			message = messageSource.getMessage("role.success.create", null, "", null);
		}

		redirectAttributes.addFlashAttribute("messages", message);
		return "redirect:/role/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/role/edit/{id}")
	public String edit(ModelMap modelMap, @PathVariable("id") String id) {

		Role role = roleServiceImpl.getByCode(Integer.parseInt(id));
		modelMap.addAttribute("role", role);
		List<Permission> permissions = permissionService.getListAllPermission();
		modelMap.addAttribute("permissions", permissions);
		return "admin/roles/edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/role/update")
	public String update(@ModelAttribute("role") Role role, @PathParam("permission_id") String[] permission_id,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		roleValidation.validateUpdate(role, bindingResult);
		if (bindingResult.hasErrors()) {

			redirectAttributes.addFlashAttribute(bindingResult.getModel());
			return "redirect:/role/edit/" + role.getId();
		}

		List<RolePermission> permissions = null;
		if (permission_id != null) {
			permissions = new ArrayList<>();
			for (int i = 0; i < permission_id.length; i++) {
				RolePermission permiss = new RolePermission();
				permiss.setPermissionID(Integer.parseInt(permission_id[i]));
				permissions.add(permiss);

			}
		}
		boolean isSuccess = roleServiceImpl.updateRole(role, permissions);
		String message = messageSource.getMessage("role.error.update", null, "", null);
		if (isSuccess)
			message = messageSource.getMessage("role.success.update", null, "", null);
		redirectAttributes.addFlashAttribute("messages", message);
		return "redirect:/role/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/role/delete/{id}")
	public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {

		boolean isSuccess = roleServiceImpl.deleteRole(Integer.parseInt(id));
		String message = "";
		if (isSuccess) {
			message = messageSource.getMessage("role.success.delete", null, "", null);
		} else {
			message = messageSource.getMessage("role.error.delete", null, "", null);
		}
		redirectAttributes.addFlashAttribute("messages", message);
		return "redirect:/role/list";
	}
}
