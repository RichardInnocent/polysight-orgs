package org.richardinnocent.polysight.orgs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.joda.time.DateTime;

/**
 * Represents a grouping of cameras within an organisation. The intention here is to allow multiple
 * camera groups to be defined for an organisation, allowing organisations to focus their reporting
 * on particular areas. This could eventually be expanded such that organisations have full control
 * over the IAM for their users relating to each group.
 */
@Entity
@Table(name = CameraGroup.Meta.TABLE_NAME)
public class CameraGroup {

  @Id
  @Column(name = Meta.ID_COLUMN_NAME, nullable = false)
  private long id;

  @ManyToOne
  private Organisation organisation;

  @Column(name = Meta.NAME_COLUMN_NAME, nullable = false)
  private String name;

  @Column(name = Meta.DATE_CREATED_COLUMN_NAME, nullable = false)
  private DateTime dateCreated;

  /**
   * Gets the ID of the camera group.
   * @return The ID of the camera group.
   */
  public long getId() {
    return id;
  }

  /**
   * Gets the ID of the camera group.
   * @param id The ID of the camera group.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the organisation that this camera group belongs to.
   * @return The organisation that this camera group belongs to.
   */
  public Organisation getOrganisation() {
    return organisation;
  }

  /**
   * Sets the organisation that this camera group belongs to.
   * @param organisation The organisation that this camera group belongs to.
   */
  public void setOrganisation(Organisation organisation) {
    this.organisation = organisation;
  }

  /**
   * Gets the name of the camera group.
   * @return The name of the camera group.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the camera group.
   * @param name The name of the camera group.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the date and time at which this camera group was created.
   * @return The date and time that this camera group was created.
   */
  public DateTime getDateCreated() {
    return dateCreated;
  }

  /**
   * Sets the date and time at which this camera group was created.
   * @param dateCreated The date and time at which this camera group was created.
   */
  public void setDateCreated(DateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public static class Meta {
    public static final String TABLE_NAME = "camera_group";

    public static final String ID_COLUMN_NAME = "camera_group_id";

    public static final String ORGANISATION_ID_COLUMN_NAME = "organisation_id";

    public static final String NAME_COLUMN_NAME = "name";

    public static final String DATE_CREATED_COLUMN_NAME = "date_created";
  }

}
