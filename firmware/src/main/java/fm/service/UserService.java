package fm.service;


import fm.model.Address;
import fm.model.AddressDetail;
import fm.model.Subject;
import fm.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {
    private static List<User> users;
    static {
        AddressDetail detail1 = new AddressDetail(1112,"UP","India",221545);
        AddressDetail detail2 = new AddressDetail(1222,"MP","India",451545);

        Address address1 = new Address();
        address1.setHomeNo(11);
        address1.setStreet("11/15, hafiza road");
        address1.setDetail(detail1);

        Address address2 = new Address(12,"23/34, dokla", detail2);

        Subject sub11 = new Subject(11,"history",10, 34.56f);
        Subject sub12 = new Subject(12,"physics",20, 94.52f);
        Subject sub13 = new Subject(13,"chemistry",18, 84.95f);

        Subject sub21 = new Subject(10,"hindi",15, 74.55f);
        Subject sub22 = new Subject(11,"history",10, 34.56f);
        Subject sub23 = new Subject(14,"geography",13, 64.56f);

        User user1 = new User(1111, "anand", address1,List.of(sub11,sub12,sub13));
        User user2 = new User(1122, "udham", address2,List.of(sub21,sub22,sub23));

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }


    public Mono<User> getUserById(int id) {
        return users.isEmpty()? Mono.empty():Flux.fromIterable(users).filter(user-> user.getUserId() == id).next();
    }

    public Flux<User> getAllUsers() {
        return  users.isEmpty()? Flux.empty(): Flux.fromIterable(users);
    }

    public Mono<User> saveUser(User user) {
        users.add(user);
        return Flux.fromIterable(users).filter(savedUser-> savedUser.getUserId() == user.getUserId()).next();
    }

    public Mono<Void> deleteUserById(int id) {
        return Mono.empty();
    }
}
