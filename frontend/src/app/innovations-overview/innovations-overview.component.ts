import { Component, OnInit } from '@angular/core';
import { Idea, IdeaService } from '../_service/idea.service';
import { PagingService } from '../_service/PagingService';

@Component({
  selector: 'app-innovations-overview',
  templateUrl: './innovations-overview.component.html',
  styleUrls: ['./innovations-overview.component.scss']
})
export class InnovationsOverviewComponent implements OnInit {

  sortByName = 'Sortuj po nazwie';
  sortByDate = 'Sortuj po dacie';
  sortByRating = 'Sortuj po ocenach';

  byName = 'name';
  byDate = 'additionDate';
  byRating = 'rating';

  sortingSetup: any = {};
  sortBy: string;
  sortDir: string;

  rate = 'Średnia ocena: ';
  allIdeas: number;
  ideasPerPage = 20;
  firstPage = 'Pierwsza';
  lastPage = 'Ostatnia';
  paging: any = {};

  addNew = 'Dodaj nowy pomysł';
  submitedIdeas = 'Zgłoszone pomysły ';
  added = 'Dodano: ';
  keywordsLab = 'Słowa kluczowe: ';

  ideas: Idea[];

  constructor(private _ideaService: IdeaService, private pagingService: PagingService) { }

  private getIdeasPage(pageNumber: number, ideasPerPage: number, sortBy: string= '', sortDir: string= '') {
    this._ideaService.getIdeas(pageNumber, ideasPerPage, sortBy, sortDir)
      .subscribe(ideas => {
        this.ideas = ideas;
        this.getMeanRating();
      });

    if (this.allIdeas != null ) { this.setPage(pageNumber + 1);}
  }

  private  getMeanRating() {
    for (let i = 0; i < this.ideas.length; i++) {
      this._ideaService.getMeanRating(this.ideas[i]).subscribe( mean => {
        this.ideas[i].meanRating = mean;
      });
    }
  }

  private getIdeasCount() {
    this._ideaService.getIdeasCount().subscribe(count => {
      this.allIdeas = count;
      this.setPage(1);
    });

  }

  ngOnInit() {
    this.getIdeasCount();
    this.getIdeasPage(0, this.ideasPerPage, this.sortingSetup.sortBy, this.sortingSetup.sortDir);
  }

  setPage(page: number) {
    this.paging = this.pagingService.getPaging(this.allIdeas, page, this.ideasPerPage);
  }

  changeSorting(sortBy: string) {
    this.sortingSetup = this.pagingService.changeSorting(sortBy, this.sortingSetup.sortDir, this.sortingSetup.sortBy);
    this.getIdeasPage(0, this.ideasPerPage, this.sortingSetup.sortBy, this.sortingSetup.sortDir);
  }

}
