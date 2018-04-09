package Delta.CoachMeSpring.comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController (CommentService commentService){this.commentService = commentService;}

    @RequestMapping(value="/comments/add", method=RequestMethod.POST,
            consumes = "application/json")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @RequestMapping(value="/comments", method=RequestMethod.GET)
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

}


