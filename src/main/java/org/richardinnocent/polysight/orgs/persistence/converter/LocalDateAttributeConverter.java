package org.richardinnocent.polysight.orgs.persistence.converter;

import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

  @Override
  public Date convertToDatabaseColumn(LocalDate localDate) {
    return localDate == null ? null : Date.valueOf(constructDateString(localDate));
  }

  private String constructDateString(LocalDate localDate) {
    return localDate.getYear() + "-" + localDate.getMonthOfYear() + '-' + localDate.getDayOfMonth();
  }

  @Override
  public LocalDate convertToEntityAttribute(Date sqlDate) {
    return sqlDate == null ? null : new LocalDate(sqlDate.toString());
  }
}
