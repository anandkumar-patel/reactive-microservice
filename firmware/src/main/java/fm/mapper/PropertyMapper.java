package fm.mapper;


import fm.entity.PropertyEntity;
import fm.model.House;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    House toModel(PropertyEntity entity);
    PropertyEntity toEntity(House model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true) // Prevents updating `id`
    void updateEntityFromModel(House model, @MappingTarget PropertyEntity entity);
}

