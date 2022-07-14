package shebaHub.main;

import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class FunctionUtil {


    public static Function<List<User>,List<Question>> userToQuestion =
            (users) -> users.stream()
                    .flatMap(user -> user.getPosts().stream())
                    .filter(post -> post instanceof  Question)
                    .map(post -> (Question)post)
                    .collect(Collectors.toList());



    public static Function<List<User>,List<Answer>> userToAnswer =
            (users) -> users.stream()
                    .flatMap(user -> user.getPosts().stream())
                    .filter(post -> post instanceof  Answer)
                    .map(post -> (Answer)post)
                    .collect(Collectors.toList());


    public static QuadFunction<List<Question>,Long , Integer,Category, List<String>> topKHighRatedQuestionInGivenYear =
            (questions,year,limit,category) ->
                    questions.stream()
                            .filter(question -> question.getPostedDate().getYear() == year)
                            .filter(question -> question.getCategories().contains(category))
                            .sorted((question1,question2)->(int)(question2.getVotes().size()-question1.getVotes().size()))
                            .limit(limit)
                            .map(question -> question.getUser().getPerson().getFirstName())
                            .collect(Collectors.toList());
    public static QuadFunction<List<Answer>,Long , Integer,Category, List<String>> topKHighRatedAnswersInGivenYear =
            (answers,year,limit,category) ->
                    answers.stream()
                            .filter(answer -> answer.getPostedDate().getYear() == year)
                            .filter(answer -> answer.getQuestion().getCategories().contains(category))
                            .sorted((answer1,answer2)->(int)(answer2.getVotes().size()-answer1.getVotes().size()))
                            .limit(limit)
                            .map(answer -> answer.getUser().getPerson().getFirstName())
                            .collect(Collectors.toList());

    public static BiFunction<List<Question>,Category,List<String>> topQuestionProvidersInCategory =
        (questions, category) -> questions.stream()
                .filter(question -> question.getCategories().contains(category))
                .collect(Collectors.groupingBy(question -> question.getUser(),Collectors.counting()))
                .entrySet().stream()
                .sorted((u1,u2) -> (int)(u2.getValue()- u1.getValue()))
                .map(userQuestionCount ->userQuestionCount.getKey().getPerson().getEmail() )
                .collect(Collectors.toList());



    public static BiFunction<List<User>,Long,Optional<Category>> topCategoryOfYear =
            (users, year)-> userToQuestion.apply(users).stream()
                    .filter(question -> question.getPostedDate().getYear() == year)
                    .flatMap(question -> question.getCategories().stream())
                    .collect(Collectors.groupingBy(category ->category,Collectors.counting()))
                    .entrySet().stream()
                    .sorted((c1,c2)->(int)(c2.getValue()- c1.getValue()))
                    .map(categoryLongEntry -> categoryLongEntry.getKey())
                    .findFirst();

    public static BiFunction<List<User>,Long ,Optional<String>> topAnswererOfAYear =
            (users, year) -> userToAnswer.apply(users).stream()
                    .filter(answer -> answer.getPostedDate().getYear() == year)
                    .collect(Collectors.groupingBy(answer -> answer.getUser(),Collectors.counting()))
                    .entrySet().stream()
                    .sorted((u1,u2) -> (int)(u2.getValue() - u1.getValue()))
                    .findFirst()
                    .map(userLongEntry -> userLongEntry.getKey().getPerson().getEmail());


    public static BiFunction<List<Question>,Long,List<Question>> topKQuestionsWithHighestAnswers =
            (questions, k) ->
                    questions.stream()
                            .flatMap(question -> question.getAnswers().stream())
                            .collect(Collectors.groupingBy(answer -> answer.getQuestion(),Collectors.counting()))
                            .entrySet().stream()
                            .sorted((q1,q2) -> (int)(q2.getValue() - q1.getValue()))
                            .map(questionLongEntry -> questionLongEntry.getKey())
                            .limit(k)
                            .collect(Collectors.toList());


    /**
     * JERRY
     * */

    static Function<List<Person>,List<User>> personToUser=
            persons -> persons.stream()
                    .flatMap(person -> person.getRoles().stream())
                    .filter(role -> role instanceof User)
                    .map(role -> (User) role)
                    .collect(Collectors.toList());

//    static Function<List<User>,List<Question>> userToQuestion=
//            users -> users.stream()
//                    .flatMap(user -> user.getPosts().stream())
//                    .filter(post -> post instanceof Question)
//                    .map(post -> (Question)post)
//                    .collect(Collectors.toList());

    static Function<List<Post>,List<Answer>> postToAnswer=posts -> posts.stream()
            .filter(post -> post instanceof Answer)
            .map(post -> (Answer) post)
            .collect(Collectors.toList());

    static Function<List<Post>,List<Question>> postToQuestion=posts -> posts.stream()
            .filter(post -> post instanceof Question)
            .map(post -> (Question) post)
            .collect(Collectors.toList());


    static TriFunction<List<Person>,String,Long, List<Answer>> firstKAnswersForGivenQuestion=
            (person,questionId,k) -> personToUser.apply(person).stream()
                    .flatMap(user -> userToQuestion.apply(personToUser.apply(person)).stream())
                    .filter(question -> question.getPostId().equals(questionId))
                    .flatMap(question -> question.getAnswers().stream())
                    .sorted(Comparator.comparing(Post::getPostedDate))
                    .limit(k)
                    .collect(Collectors.toList());


    static TriFunction<List<Person>,Integer,String,String> getMostRatedQuestionGivenMonthAndCity=(person,month,city)->
            personToUser.apply(person).stream()
                    .flatMap(user -> postToAnswer.apply(user.getPosts()).stream())
                    .filter(answer -> answer.getUser().getPerson().getAddress().equals(city) && answer.getPostedDate().getMonth().equals(month))
                    .collect(Collectors.toMap(Answer::getQuestion,answer -> answer.getVotes().stream().count()))
                    .entrySet().stream()
                    .sorted((p1,p2)->(int)(p2.getValue()- p1.getValue()))
                    .findFirst().map(q->q.getKey()).toString();












    /**
     * Beki
     * */


    static Function<User,String> getAddress= user -> user.getPerson().getAddress().getCity();
//    static Function<List<Post>,List<Answer>> postToAnswer=posts -> posts.stream()
//            .filter(post -> post instanceof Answer)
//            .map(post -> (Answer) post)
//            .collect(Collectors.toList());
//    static Function<List<Post>,List<Question>> postToQuestion=posts -> posts.stream()
//            .filter(post -> post instanceof Question)
//            .map(post -> (Question) post)
//            .collect(toList());

    static TriFunction<List<Person>,String, Month,List<String>> getUsersWithTopVotedAnswer=(persons, city, month)->
            personToUser.apply(persons).stream()
                    .filter(user -> getAddress.apply(user).equals(city))
                    .flatMap(user -> postToAnswer.apply(user.getPosts()).stream())
                    .filter(answer -> answer.getPostedDate().getMonth()==month)
                    .collect(Collectors.groupingBy(Answer::getUser,Collectors.summingLong(r->r.getVotes().stream().count())))
                    .entrySet().stream()
                    .sorted((c,c2)->(int)(c2.getValue()-c.getValue()))
                    .map(userLongEntry -> userLongEntry.getKey().getPerson().getFirstName())
                    .collect(Collectors.toList());
    static Function<List<Post>,Long> getTotalNumber=posts ->
            posts.stream().count();

    static QuadFunction<List<Person>,Integer,Integer,Integer,List<String>> getUsersWithKQuestionAndAnswers=
            (peaples,year,k,n)->personToUser.apply(peaples).stream()
                    .collect(Collectors.toMap(user -> user.getPerson().getFirstName(),user -> getTotalNumber.apply(user.getPosts())))
                    .entrySet().stream()
                    .filter(stringLongEntry -> stringLongEntry.getValue()>=n)
                    .sorted((p1,p2)->(int) (p2.getValue()-p1.getValue()))
                    .limit(k)
                    .map(stringLongEntry -> stringLongEntry.getKey())
                    .collect(Collectors.toList());
    static BiFunction<List<Person>,Integer,String> getMostUpVotedSolutionInAMonth=(person,month)->
            personToUser.apply(person).stream()
                    .flatMap(user -> postToAnswer.apply(user.getPosts()).stream())
                    .filter(answer -> answer.getPostedDate().getMonthValue()==month)
                    .collect(Collectors.toMap(Answer::getUser,answer -> answer.getVotes().stream().count()))
                    .entrySet().stream()
                    .sorted((p1,p2)->(int)(p2.getValue()- p1.getValue()))
                    .findFirst().map(userLongEntry -> userLongEntry.getKey()).toString();
    static TriFunction<List<Person>,Integer,Integer,List<String>> getBestCity=(people, year, k) ->
            personToUser.apply(people).stream()
                    .flatMap(user -> user.getPosts().stream())
                    .filter(post -> post.getPostedDate().getYear()==year)
                    .collect(Collectors.groupingBy(post -> post.getUser().getPerson().getAddress().getCity(),Collectors.toList()))
                    .entrySet().stream()
                    .sorted((p1,p2)->(int)(p1.getValue().size()-p2.getValue().size()))
                    .limit(k)
                    .map(stringListEntry -> Arrays.asList(stringListEntry.getKey(),postToQuestion.apply(stringListEntry.getValue()).stream().count(),postToAnswer.apply(stringListEntry.getValue()).stream().count()).toString())
                    .collect(Collectors.toList());


//    public static void topKHighRatedQuestionInGivenYear(List<Question> , long, int Category ) {
//    }
}
