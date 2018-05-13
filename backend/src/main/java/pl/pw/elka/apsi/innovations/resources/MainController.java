package pl.pw.elka.apsi.innovations.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pw.elka.apsi.innovations.domain.attachement.AttachmentRepository;
import pl.pw.elka.apsi.innovations.domain.idea.Idea;
import pl.pw.elka.apsi.innovations.domain.idea.IdeaRepository;
import pl.pw.elka.apsi.innovations.domain.keyword.KeywordRepository;
import pl.pw.elka.apsi.innovations.domain.opinion.Opinion;
import pl.pw.elka.apsi.innovations.domain.opinion.OpinionRepository;
import pl.pw.elka.apsi.innovations.domain.rating.Rating;
import pl.pw.elka.apsi.innovations.domain.rating.RatingRepository;
import pl.pw.elka.apsi.innovations.domain.subject.SubjectRepository;
import pl.pw.elka.apsi.innovations.domain.user.User;
import pl.pw.elka.apsi.innovations.domain.user.UserRepository;

import java.util.Optional;

/**
 * Created by Łukasz on 2018-05-13.
 */
@Controller
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    IdeaRepository ideaRepository;
    @Autowired
    KeywordRepository keywordRepository;
    @Autowired
    OpinionRepository opinionRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping (path = "/addOpinion")
    public @ResponseBody String addNewOpinion(@RequestParam String text, @RequestParam long ideaId, @RequestParam long userId){
        Optional<Idea> idea = ideaRepository.findById(ideaId);
        Optional<User> user = userRepository.findById(userId);
        if(!idea.isPresent() ){
            return "There is no idea with given id";
        }
        else if (!user.isPresent()){
            return "There is no user with given id";
        }

        else{
            Opinion opinion = new Opinion(text, idea.get(), user.get());
            opinionRepository.save(opinion);
            return "saved";
        }

    }

    @PostMapping (path = "/addRating")
    public @ResponseBody String addNewRating(@RequestParam int value, @RequestParam long ideaId, @RequestParam long userId){
        Optional<Idea> idea = ideaRepository.findById(ideaId);
        Optional<User> user = userRepository.findById(userId);
        if(!idea.isPresent() ){
            return "There is no idea with given id";
        }
        else if (!user.isPresent()){
            return "There is no user with given id";
        }

        else{
            Rating rating = new Rating(value, idea.get(), user.get());
            ratingRepository.save(rating);
            return "saved";
        }

    }
}

