package rest.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.Entities.Role;
import rest.Repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
