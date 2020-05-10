package org.richardinnocent.polysight.orgs.persistence.dao;

import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * Allows easier JPA searching for {@link UserOrganisationAssignment} entities.
 */
@Component
public interface UserOrganisationAssignmentRepository extends
    JpaRepository<UserOrganisationAssignment, Long>,
    JpaSpecificationExecutor<UserOrganisationAssignment> {

}
