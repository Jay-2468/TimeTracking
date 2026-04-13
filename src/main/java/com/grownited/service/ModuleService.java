package com.grownited.service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.ModuleEntity;
import com.grownited.repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepo;

	public void archiveModule(Long moduleId) {
		Optional<ModuleEntity> opModule = moduleRepo.findById(moduleId);
		if (opModule.isPresent()) {
			ModuleEntity module = opModule.get();
			module.setIsArchived(true);
			moduleRepo.save(module);
		}
	}

	public ModuleEntity findById(Long moduleId) {
		Optional<ModuleEntity> opModule = moduleRepo.findById(moduleId);
		ModuleEntity module = null;
		if (opModule.isPresent()) {
			module = opModule.get();
		}
		return module;
	}

	public void updateModule(ModuleEntity updatedModule) {

		ModuleEntity existing = moduleRepo.findById(updatedModule.getModuleId()).orElse(null);

		if (existing != null) {

			existing.setModuleName(updatedModule.getModuleName());
			existing.setProject(updatedModule.getProject());
			existing.setDescription(updatedModule.getDescription());

			moduleRepo.save(existing);
		}
	}

	public ModuleEntity getModuleById(Long moduleId) {

		ModuleEntity module = moduleRepo.findById(moduleId)
				.orElseThrow(() -> new RuntimeException("Module not found"));

		// Prevent Lazy Load issues
		module.getProject().getProjectName();
		module.getCreatedBy().getFirstName();

		if (module.getUpdatedBy() != null) {
			module.getUpdatedBy().getFirstName();
		}

		return module;
	}

	public List<ModuleEntity> findAll() {
		return moduleRepo.findAll();
	}
}
