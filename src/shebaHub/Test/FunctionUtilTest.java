package shebaHub.Test;


import shebaHub.main.*;
import org.junit.Before;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FunctionUtilTest {
    /**
     *
     * Reference - hotel
     */

    List<User> users ;
    List<Question> questions;

    List<Answer> answers;
    List<Address> addresses;
    List<Vote> votes;
    List<Category> categories;
    List<Admin> admins;

    User ashu,yemane,beki,jerry;

    //users only for vote
//    User voteUser1,voteUser2,voteUser3,voteUser4,voteUser5,voteUser6,voteUser7;
    List<User> voters = new ArrayList<>() ;


    Question question1,question2,question3,question4,question5;
    Answer answer1,answer2,answer3,answer4,answer5,answer6,answer7;

    Vote vote1,vote2,vote3,vote4,vote5,vote6,vote7,vote8,vote9,vote10;

    @Before
    public void setUp(){
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            addresses.add(
                    TestFactory.createAddress("city"+i,"ZipCode_"+i)

            );
        }


        //create user
        ashu = TestFactory.createUser(
                1L,
                "Ashenafi",
                "Mehari",
                "ashenafi@gmail.com",
                "ashuchi"
        );
        ashu.getPerson().setAddress(addresses.get(0));
        yemane = TestFactory.createUser(
                2L,
                "Yemane",
                "Abrha",
                "yemane@gmail.com",
                "yemane"
        );
        yemane.getPerson().setAddress(addresses.get(1));

        beki = TestFactory.createUser(
                3L,
                "Bereket",
                "Haile",
                "bereket@gmail.com",
                "bekiboss"
        );
        beki.getPerson().setAddress(addresses.get(2));

        jerry = TestFactory.createUser(
                2L,
                "Eyerusalem",
                "Hadgu",
                "jerry@gmail.com",
                "jerrayney"
        );
        jerry.getPerson().setAddress(addresses.get(3));


        for (int i = 0; i < 100; i++) {
            User  user = TestFactory.createUser(
                    Long.valueOf(i),
                    "voter"+i,
                    "VoterLastname"+i,
                    "voter"+i+"@gmail.com",
                    "voter"+i+"Username"
            );
            voters.add(user);
        }



        //create admin

        //TODO create question
        question1 = TestFactory.createQuestion(1L,"What is question 1", LocalDateTime.now().minusYears(2L),ashu);
        List<Category> categories1 = new ArrayList<>();
        categories1.add(Category.BIOLOGY);
        categories1.add(Category.CHEMISTRY);
        question1.setCategories(categories1);

        question2 = TestFactory.createQuestion(2L,"What is question 2", LocalDateTime.now().minusYears(3L),jerry);
        List<Category> categories2 = new ArrayList<>();
        categories2.add(Category.MATHEMATICS);
        categories2.add(Category.COMPUTER);
        question2.setCategories(categories1);


        question3 = TestFactory.createQuestion(3L,"What is question 3", LocalDateTime.now().minusYears(1L),jerry);
        List<Category> categories3 = new ArrayList<>();
        categories3.add(Category.GEOGRAHY);
        categories3.add(Category.HISTORY);
        question3.setCategories(categories1);

        question4 = TestFactory.createQuestion(4L,"What is question 4", LocalDateTime.now().minusYears(4L),ashu);
        List<Category> categories4 = new ArrayList<>();
        categories4.add(Category.MATHEMATICS);
        categories4.add(Category.PHYSICS);
        question4.setCategories(categories1);

        question5 = TestFactory.createQuestion(5L,"What is question 5", LocalDateTime.now(),jerry);
        List<Category> categories5 = new ArrayList<>();
        categories5.add(Category.PHYSICS);
        categories5.add(Category.GEOGRAHY);
        question5.setCategories(categories1);



        //create vote
        List<Vote> question1Votes = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            Vote vote = TestFactory.createVote(Long.valueOf(i),voters.get(i),question1);
            question1Votes.add(vote);
        }

        List<Vote> question2Votes = new ArrayList<>();
        for (int i = 90; i < 150; i++) {
            Vote vote = TestFactory.createVote(Long.valueOf(i),voters.get(i-90),question2);
            question2Votes.add(vote);
        }
        List<Vote> question3Votes = new ArrayList<>();
        for (int i = 150; i < 200; i++) {
            Vote vote = TestFactory.createVote(Long.valueOf(i),voters.get(i-150),question3);
            question3Votes.add(vote);
        }

        List<Vote> question4Votes = new ArrayList<>();
        for (int i = 200; i < 240; i++) {
            Vote vote = TestFactory.createVote(Long.valueOf(i),voters.get(i-200),question4);
            question4Votes.add(vote);
        }

        List<Vote> question5Votes = new ArrayList<>();
        for (int i = 240; i < 330; i++) {
            Vote vote = TestFactory.createVote(Long.valueOf(i),voters.get(i-240),question5);
            question5Votes.add(vote);
        }
        List<Vote> answer1Votes = new ArrayList<>();
        for (int i = 330; i < 360; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-330),answer1);
            answer1Votes.add(vote);
        }

        List<Vote> answer2Votes = new ArrayList<>();
        for (int i = 360; i < 390; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-360),answer2);
            answer2Votes.add(vote);
        }

        List<Vote> answer3Votes = new ArrayList<>();
        for (int i = 390; i < 400; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-390),answer3);
            answer3Votes.add(vote);
        }

        List<Vote> answer4Votes = new ArrayList<>();
        for (int i = 400; i < 405; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-400),answer4);
            answer4Votes.add(vote);
        }
        List<Vote> answer5Votes = new ArrayList<>();
        for (int i = 405; i < 450; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-405),answer5);
            answer5Votes.add(vote);
        }

        List<Vote> answer6Votes = new ArrayList<>();
        for (int i = 450; i < 480; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-450),answer6);
            answer6Votes.add(vote);
        }
        List<Vote> answer7Votes = new ArrayList<>();
        for (int i = 480; i < 500; i++) {
            Vote vote = TestFactory.createVote((long) i,voters.get(i-330),answer7);
            answer7Votes.add(vote);
        }

        //Assign votes to question
        question1.setVotes(question1Votes);
        question2.setVotes(question2Votes);
        question3.setVotes(question3Votes);
        question4.setVotes(question4Votes);
        question5.setVotes(question5Votes);




      //Assign votes to answers
        answer1.setVotes(answer1Votes);
        answer2.setVotes(answer2Votes);
        answer3.setVotes(answer3Votes);
        answer4.setVotes(answer4Votes);
        answer5.setVotes(answer5Votes);
        answer6.setVotes(answer6Votes);
        answer7.setVotes(answer7Votes);

        //TODO create answer



//        Answer answer1,answer2,answer3,answer4,answer5,answer6,answer7;

        answer1 = TestFactory.createAnswer(1L,"this is answer 1",LocalDateTime.now().minusYears(1),yemane,question1);
        answer2 = TestFactory.createAnswer(1L,"this is answer 2",LocalDateTime.now().minusYears(1),beki,question1);
        answer3 = TestFactory.createAnswer(1L,"this is answer 3",LocalDateTime.now().minusYears(1),beki,question2);
        answer4 = TestFactory.createAnswer(1L,"this is answer 1",LocalDateTime.now().minusYears(1),yemane,question3);
        answer5 = TestFactory.createAnswer(1L,"this is answer 1",LocalDateTime.now().minusYears(1),beki,question4);
        answer6 = TestFactory.createAnswer(1L,"this is answer 1",LocalDateTime.now().minusYears(1),yemane,question5);
        answer7 = TestFactory.createAnswer(1L,"this is answer 1",LocalDateTime.now().minusYears(1),yemane,question4);


        //TODO CREATE VOTE









    }









}
