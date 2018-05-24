import { Component, OnInit } from '@angular/core';
import { Idea, IdeaService } from '../_service/idea.service';
import { PagingService } from '../_service/PagingService';

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

  ideas: Idea[];

  constructor(private _ideaService: IdeaService, private pagingService: PagingService) { }

  private getIdeasPage(pageNumber: number, ideasPerPage: number) {
    this._ideaService.getIdeas(pageNumber, ideasPerPage)
      .subscribe(ideas => this.ideas = ideas);
  }

  ngOnInit() {
    this.getIdeasPage(0, 20);
    // this.setPage(1);
  }

  setPage(page: number) {
    this.paging = this.pagingService.getPaging(this.ideas.length, page, this.ideasPerPage);
    this.pagedIdeas = this.ideas.slice(this.paging.startIndex, this.paging.endIndex + 1);
  }

}
