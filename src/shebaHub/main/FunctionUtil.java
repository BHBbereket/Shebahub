package shebaHub.main;

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





}
