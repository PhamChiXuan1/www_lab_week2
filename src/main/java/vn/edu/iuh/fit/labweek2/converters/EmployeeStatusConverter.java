package vn.edu.iuh.fit.labweek2.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.labweek2.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus status) {
        if(status == null){
            return null;
        }
        return status.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer integer) {
        if(integer == null){
            return null;
        }
        return Stream.of(EmployeeStatus.values()).filter(c->c.getValue()==integer).findFirst().orElseThrow(IllegalAccessError::new);
    }
}
