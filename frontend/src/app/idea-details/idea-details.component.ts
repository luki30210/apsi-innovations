import { Component, OnInit } from '@angular/core';
import {Idea} from '../_model/idea';
import {ActivatedRoute} from '@angular/router';
import {IdeaService} from '../_service/idea.service';
import {Observable} from 'rxjs/index';

@Component({
  selector: 'app-idea-details',
  templateUrl: './idea-details.component.html',
  styleUrls: ['./idea-details.component.scss']
})
export class IdeaDetailsComponent implements OnInit {
  idea: Idea;
  isLoaded = false;
  ideaService: IdeaService;
  descriptionHead = 'Opis pomysłu';
  constructor(private route: ActivatedRoute, private _ideaService: IdeaService) {
    this.route.params.subscribe(params =>
        _ideaService.getIdea(params['id']).subscribe(idea => {
            this.idea = idea;
            this.isLoaded = true;
          }
        )
      );
    }
  ngOnInit() {
  }

}
