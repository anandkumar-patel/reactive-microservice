MapStruct :
    for mapping entity to model and vice versa.
        example - AutoMobileMapper.java
    @Mapper(componentModel = "spring") this indicates
    you are telling MapStruct to generate a Spring Bean for the UserMapper interface.
    This means you can autowire it into other Spring components (like @Service/@Controller).

@NoArgsConstructor // Required for serialization frameworks
    - frameworks like Jackson to deserialize JSON

Consider Using @Builder for Immutable Object Creation