package com.akshay.resources;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourceController {

	private ResourcesRepository resourcesRepository;

	public ResourceController(ResourcesRepository resourceRepository) {
		this.resourcesRepository = resourceRepository;
	}

	@PreAuthorize("hasAnyRole('STANDARD', 'ADMIN')")
	@PostMapping
	public void addResource(@RequestBody Resource resource) {
		resourcesRepository.save(resource);
	}

	@PreAuthorize("hasAnyRole('STANDARD', 'ADMIN')")
	@GetMapping
	public List<Resource> getResource() {
		return resourcesRepository.findAll();
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void editResource(@PathVariable long id, @RequestBody Resource resouce) {
		Resource existingResource = resourcesRepository.findById(id).get();
		Assert.notNull(existingResource, "Resource not found");
		existingResource.setDescription(resouce.getDescription());
		resourcesRepository.save(existingResource);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTask(@PathVariable long id) {
		Resource taskToDel = resourcesRepository.findById(id).get();
		resourcesRepository.delete(taskToDel);
	}
}