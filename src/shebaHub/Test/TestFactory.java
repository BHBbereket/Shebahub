package shebaHub.Test;

import shebaHub.main.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestFactory {
    static public Address createAddress(String city,String zipCode){
        Address address = new Address(city,zipCode);
        return address;
    }
    static public User createUser(Long personId, String firstName,String lastName,String email,String userName){
        Person person = Person.getInstance(personId,firstName,lastName,email,userName);
        User user = new User();
        user.setPerson(person);
        user.setPosts(new ArrayList<>());
        person.getRoles().add(user);
        return user;
    }
    static public Question createQuestion(Long postId, String content, LocalDateTime postedDate, User user){

        Question question = new Question(postId,content,postedDate,user);
        question.setVotes(new ArrayList<Vote>());
        return question;

    }
    static public Answer createAnswer(Long postId, String content, LocalDateTime postedDate, User user, Question question){

        Answer answer = new Answer(postId,content,postedDate,user,question);
        answer.setVotes(new ArrayList<Vote>());
        return answer;
    }

    static public Vote createVote(Long voteId,User user,Post post){
        Vote vote = new Vote(voteId,user,post);
        return vote;
    }


}
