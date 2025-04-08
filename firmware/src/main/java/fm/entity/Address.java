package fm.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Address {
    @Id
    private long homeNo;
    private String street;
    private AddressDetail detail;
}
