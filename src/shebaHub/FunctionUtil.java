package shebaHub;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class FunctionUtil {
    static Function<List<Person>,List<User>> personToUser=(people)
            ->people.stream().flatMap(person -> person.getRoles().stream())
            .filter(role -> role instanceof User)
            .map(role -> (User) role)
            .collect(Collectors.toList());
    static Function<User,String> getAdress= user -> user.getPerson().getAddress().getCity();
    static BiFunction<List<Person>,String,List<String>> getUsersWithTopVotedAnswer=(persons, city)->
            personToUser.apply(persons).stream()
                    .filter(user -> getAdress.apply(user).equals(city))
                    .flatMap(user -> user.getPosts().stream())
                    .filter(post -> post instanceof Answer)
}
