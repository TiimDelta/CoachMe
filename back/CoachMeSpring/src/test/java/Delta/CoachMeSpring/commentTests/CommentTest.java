package Delta.CoachMeSpring.commentTests;
import Delta.CoachMeSpring.comment.Comment;
import Delta.CoachMeSpring.comment.CommentRepository;
import Delta.CoachMeSpring.training.Training;
import Delta.CoachMeSpring.training.TrainingRepository;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CommentTest {
    private Comment com;
    private List<Comment> commentList;


    @Before
    public void setUp(){
        com = new Comment("See on kommentaar" );
        entityManager.merge(com);
        entityManager.flush();
        commentList = commentRepository.findAll();
    }

    @After
    public void tearDown(){
        com = null;
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void textTest(){
        int lenght = commentList.size();
        String text = commentList.get(lenght -1).text;
        assertEquals(text, com.text);
    }
}