import { Component, OnInit } from '@angular/core';
import { Idea, IdeaService } from '../_service/idea.service';
import { PagingService } from '../_service/PagingService';

@Component({
  selector: 'app-innovations-overview',
  templateUrl: './innovations-overview.component.html',
  styleUrls: ['./innovations-overview.component.scss']
})
export class InnovationsOverviewComponent implements OnInit {

  allIdeas: number;
  ideasPerPage = 2;
  firstPage = 'Pierwsza';
  lastPage = 'Ostatnia';
  paging: any = {};

  addNew = 'Dodaj nowy pomysł';
  submitedIdeas = 'Zgłoszone pomysły ';
  added = 'Dodano: ';
  keywordsLab = 'Słowa kluczowe: ';

  ideas: Idea[];

  constructor(private _ideaService: IdeaService, private pagingService: PagingService) { }

  private getIdeasPage(pageNumber: number, ideasPerPage: number) {
    this._ideaService.getIdeas(pageNumber, ideasPerPage)
      .subscribe(ideas => this.ideas = ideas);

    if (this.allIdeas != null ) { this.setPage(pageNumber + 1); }
  }

  private getIdeasCount() {
    this._ideaService.getIdeasCount().subscribe(count => {
      this.allIdeas = count;
      this.setPage(1);
    });

  }

  ngOnInit() {
    this.getIdeasCount();
    this.getIdeasPage(0, this.ideasPerPage);
  }

  setPage(page: number) {
    this.paging = this.pagingService.getPaging(this.allIdeas, page, this.ideasPerPage);
  }

}
