import { Component, OnInit } from '@angular/core';
import {Idea, IdeaService} from '../_service/idea.service';
import {PagingService} from '../_service/PagingService';

@Component({
  selector: 'app-innovations-overview',
  templateUrl: './innovations-overview.component.html',
  styleUrls: ['./innovations-overview.component.scss']
})
export class InnovationsOverviewComponent implements OnInit {

  // TODO: pagination ustawia liczbe pomyslow na strone paginacji (?) - dla wstepnych testow ustawilem na 2,
  // pozniej na jakies 10 czy 15 trzeba bedzie zmienic
  ideasPerPage = 2;
  firstPage = 'Pierwsza';
  lastPage = 'Ostatnia';
  paging: any = {};
  pagedIdeas: any[];

  addNew = 'Dodaj nowy pomysł';
  submitedIdeas = 'Zgłoszone pomysły ';
  added = 'Dodano: ';
  keywordsLab = 'Słowa kluczowe: ';

  ideas1; // TODO: info dla testera: trzeba zakomentowac to gowno pod spodem i podmienic nazwe po lewej od komentarza na 'ideas'
  ideas = [{'title' : 'Jeden', 'addition_date': '21.05.2018', 'keywords' : ['1st', '2nd']}
    , {'title' : 'Dwa', 'addition_date': '20.05.2018', 'keywords' : ['1st', '2nd']}
    , {'title' : 'Trzy', 'addition_date': '19.05.2018' , 'keywords' : ['1st', '2nd']}
    , {'title' : '4-ry', 'addition_date': '20.05.2018', 'keywords' : ['1st', '2nd']}
    , {'title' : '5-c', 'addition_date': '19.05.2018' , 'keywords' : ['1st', '2nd']}
    , {'title' : '6-c', 'addition_date': '20.05.2018', 'keywords' : ['1st', '2nd']}
    , {'title' : '7-m', 'addition_date': '19.05.2018' , 'keywords' : ['1st', '2nd']}];

  constructor(private _ideaService: IdeaService, private pagingService: PagingService) { }

  ngOnInit() {
   // this.getIdea(); //TODO: odkomentowac przy testach
    this.setPage(1);
  }


  getIdea() {
    this._ideaService.getIdea().subscribe(
      // TODO: info dla testera: trzeba podmienic pod spodem this.ideas1 na this.ideas
      data => { this.ideas1 = data; },
      err => console.error(err),
      () => console.log('done loading ideas')
    );
  }

  setPage(page: number) {
    this.paging = this.pagingService.getPaging(this.ideas.length, page, this.ideasPerPage);
    this.pagedIdeas = this.ideas.slice(this.paging.startIndex, this.paging.endIndex + 1);
  }

}
