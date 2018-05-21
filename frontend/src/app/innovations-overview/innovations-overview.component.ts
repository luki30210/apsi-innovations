import { Component, OnInit } from '@angular/core';
import {Idea, IdeaService} from '../_service/idea.service';

@Component({
  selector: 'app-innovations-overview',
  templateUrl: './innovations-overview.component.html',
  styleUrls: ['./innovations-overview.component.scss']
})
export class InnovationsOverviewComponent implements OnInit {

  addNew = 'Dodaj nowy pomysł';
  submitedIdeas = 'Zgłoszone pomysły ';
  added = 'Dodano: ';
  keywordsLab = 'Słowa kluczowe: ';

  ideas1; // TODO: info dla testera: trzeba zakomentowac to gowno pod spodem i podmienic nazwe po lewej od komentarza na 'ideas'
  ideas = [{'title' : 'Jeden', 'addition_date': '21.05.2018', 'keywords' : ['1st', '2nd']}
    , {'title' : 'Dwa', 'addition_date': '20.05.2018', 'keywords' : ['1st', '2nd']}
    , {'title' : 'Trzy', 'addition_date': '19.05.2018' , 'keywords' : ['1st', '2nd']}];
  constructor(private _ideaService: IdeaService) { }

  ngOnInit() {
    this.getIdea();
  }


  getIdea() {
    this._ideaService.getIdea().subscribe(
      // TODO: info dla testera: trzeba podmienic pod spodem this.ideas1 na this.ideas
      data => { this.ideas1 = data; },
      err => console.error(err),
      () => console.log('done loading ideas')
    );
  }

}
