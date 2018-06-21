package pl.pw.elka.apsi.innovations.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pw.elka.apsi.innovations.application.RatingService;
import pl.pw.elka.apsi.innovations.webui.dto.RatingDto;

import javax.validation.Valid;

/**
 * Created by Łukasz on 2018-05-13.
 */
@Controller
@RequestMapping(path = "/api/idea/{ideaId}/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/addRating")
    public @ResponseBody
    ResponseEntity<RatingDto> addNewRating(@PathVariable(value = "ideaId") long ideaId, @Valid @RequestBody RatingDto ratingDto) {
        ratingDto.setIdeaId(ideaId);
        return ResponseEntity.ok(ratingService.addRating(ratingDto));
    }

    @GetMapping("mean")
    public ResponseEntity<Double> getMeanRating(@PathVariable Long ideaId) {
        Double meanRating = ratingService.getMeanRatingForIdea(ideaId);
        return ResponseEntity.ok(meanRating);
    }
}

