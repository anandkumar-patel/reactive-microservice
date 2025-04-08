package fm.mapper;

import fm.entity.AutoMobileEntity;
import fm.model.AutoMobile;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AutoMobileMapper {
    AutoMobile toModel(AutoMobileEntity entity);
    AutoMobileEntity toEntity(AutoMobile model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true) // Prevents updating `id`
    void updateEntityFromModel(AutoMobile model, @MappingTarget AutoMobileEntity entity);
}

