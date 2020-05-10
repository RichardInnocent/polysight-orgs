package org.richardinnocent.polysight.orgs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment.Meta;

/**
 * Contains details regarding which users have access to which organisations.
 */
@Entity
@Table(
    name = Meta.TABLE_NAME,
    uniqueConstraints = {
        @UniqueConstraint(
            name = "user_organisation",
            columnNames = {Meta.USER_ID_COLUMN_NAME, Meta.ORGANISATION_ID_COLUMN_NAME})
    }
)
public class UserOrganisationAssignment {

  @Id
  @Column(name = Meta.ID_COLUMN_NAME, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = Meta.USER_ID_COLUMN_NAME, nullable = false)
  private long userId;

  @ManyToOne
  @JoinColumn(name = Meta.ORGANISATION_ID_COLUMN_NAME, nullable = false)
  private Organisation organisation;

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
   * Gets the organisation that the user has access to.
   * @return The organisation that the user has access to.
   */
  public Organisation getOrganisation() {
    return organisation;
  }

  /**
   * Sets the organisation that the user has access to.
   * @param organisation The organisations that the user has access to.
   */
  public void setOrganisation(Organisation organisation) {
    this.organisation = organisation;
  }

  public static final class Meta {
    public static final String TABLE_NAME = "user_organisation_assignment";
    public static final String ID_COLUMN_NAME = "user_organisation_assignment_id";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String ORGANISATION_ID_COLUMN_NAME = "organisation_id";

    private Meta() {}
  }

}
