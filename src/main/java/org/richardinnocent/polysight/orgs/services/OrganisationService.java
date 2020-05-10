package org.richardinnocent.polysight.orgs.services;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.richardinnocent.polysight.orgs.models.Organisation;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment;
import org.richardinnocent.polysight.orgs.persistence.dao.UserOrganisationAssignmentDao;
import org.springframework.stereotype.Service;

@Service
public class OrganisationService {

  private final UserOrganisationAssignmentDao userOrganisationAssignmentDAO;

  public OrganisationService(UserOrganisationAssignmentDao userOrganisationAssignmentDAO) {
    this.userOrganisationAssignmentDAO = userOrganisationAssignmentDAO;
  }

  public Set<Organisation> getAllOrganisationsForUserWithId(long userId) {
    List<UserOrganisationAssignment> assignments =
        userOrganisationAssignmentDAO.findAssignmentsForUserId(userId);
    if (assignments == null || assignments.isEmpty()) {
      return Collections.emptySet();
    }
    return assignments.stream()
                      .filter(Objects::nonNull)
                      .map(UserOrganisationAssignment::getOrganisation)
                      .filter(Objects::nonNull)
                      .collect(Collectors.toSet());
  }

}
