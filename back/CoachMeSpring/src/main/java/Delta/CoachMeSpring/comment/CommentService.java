package Delta.CoachMeSpring.comment;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){this.commentRepository = commentRepository;}

    Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getTrainingComments(String training) {
        return commentRepository.findByTrainingOrderByTimePostedAsc(training);
    }
}
