package pl.morecraft.dev.settler.service.abstractService.singleFilters;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;
import pl.morecraft.dev.settler.domain.QUser;
import pl.morecraft.dev.settler.service.abstractService.prototype.AbstractServiceSingleFilter;
import pl.morecraft.dev.settler.service.abstractService.prototype.BaseSingleFilter;
import pl.morecraft.dev.settler.service.abstractService.prototype.SingleFilterApplicableTypes;

@Component
@BaseSingleFilter(types = @SingleFilterApplicableTypes(filterType = String.class, qObjectType = QUser.class))
public class CustomStringUserSingleFilter extends AbstractServiceSingleFilter {

    @Override
    public BooleanExpression predicate(Object filterValue, Object qObjectValue) {
        return ((QUser) qObjectValue).firstName
                .concat(" ")
                .concat(((QUser) qObjectValue).lastName)
                .concat(" (")
                .concat(((QUser) qObjectValue).login)
                .concat(")")
                .contains((String) filterValue);
    }

}
