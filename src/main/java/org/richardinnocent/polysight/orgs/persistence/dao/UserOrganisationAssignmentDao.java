package org.richardinnocent.polysight.orgs.persistence.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment;
import org.richardinnocent.polysight.orgs.persistence.EntityDao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

/**
 * Finds all users that have been assigned to specific organisations and vice versa.
 */
@Transactional
@Repository
public class UserOrganisationAssignmentDao extends EntityDao<UserOrganisationAssignment> {

  private final UserOrganisationAssignmentRepository userOrganisationAssignmentRepo;

  public UserOrganisationAssignmentDao(
      UserOrganisationAssignmentRepository userOrganisationAssignmentRepo) {
    super(UserOrganisationAssignment.class);
    this.userOrganisationAssignmentRepo = userOrganisationAssignmentRepo;
  }

  /**
   * Gets all organisation assignments for the user with the given ID.
   * @param userId The ID of the user.
   * @return All organisation assignments for the user.
   */
  public List<UserOrganisationAssignment> findAssignmentsForUserId(long userId) {
    return userOrganisationAssignmentRepo.findAll(hasUserId(userId));
  }

  private Specification<UserOrganisationAssignment> hasUserId(long userId) {
    return (role, cq, cb) -> cb.equal(role.get("userId"), userId);
  }

}
