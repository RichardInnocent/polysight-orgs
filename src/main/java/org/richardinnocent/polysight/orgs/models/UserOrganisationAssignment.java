package org.richardinnocent.polysight.orgs.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment.Meta;

/**
 * Contains details regarding which users have access to which organisations.
 */
@Entity
@Table(
    name = Meta.TABLE_NAME
)
public class UserOrganisationAssignment {

  @Id
  @Column(name = Meta.ID_COLUMN_NAME, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = Meta.USER_ID_COLUMN_NAME, nullable = false)
  private long userId;

  @OneToMany
  @JoinColumn(name = "id")
  private Set<Organisation> organisations;

  /**
   * Gets the ID of the assignment.
   * @return The ID of the assignment.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the ID of the assignment.
   * @param id The ID of the assignment.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the ID of the user.
   * @return The ID of the user.
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the ID of the user.
   * @param userId The ID of the user.
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Gets the organisations that the user has access to.
   * @return The organisation that the user has access to.
   */
  public Set<Organisation> getOrganisations() {
    return organisations;
  }

  /**
   * Sets the organisations that the user has access to.
   * @param organisations The organisations that the user has access to.
   */
  public void setOrganisations(Set<Organisation> organisations) {
    this.organisations = organisations;
  }

  public static final class Meta {
    public static final String TABLE_NAME = "user_organisation_assignment";
    public static final String ID_COLUMN_NAME = "user_organisation_assignment_id";
    public static final String USER_ID_COLUMN_NAME = "user_id";

    private Meta() {}
  }

}
