import { Component, OnInit } from '@angular/core';
import { MatChipInputEvent } from '@angular/material';
import { ENTER, COMMA } from '@angular/cdk/keycodes';
import { HttpErrorResponse } from '@angular/common/http';
import { IdeaService, Idea } from '../_service/idea.service';
import { SubjectService, Subject } from '../_service/subject.service';

@Component({
  selector: 'app-innovations-creation',
  templateUrl: './innovations-creation.component.html',
  styleUrls: ['./innovations-creation.component.scss']
})
export class InnovationsCreationComponent implements OnInit {

  selectable = true;
  removable = true;
  addOnBlur = true;
  separatorKeysCodes = [ENTER, COMMA];

  title = 'Dodaj nowy pomysł';
  idea_name = 'Nazwa pomysłu: ';
  idea_description = 'Opis pomysłu: ';
  idea_subject = 'Temat pomysłu: ';
  idea_costs = 'Szacowany koszt: ';
  idea_keywords = 'Słowa kluczowe / Tagi: ';
  idea_benefits = 'Korzyści wynikające z pomysłu: ';
  name_req = 'Musisz podać nazwę pomysłu!';
  desc_req = 'Musisz podać opis pomysłu!';
  idea: Idea = {
    id: null, name: '', description: '', subject: { id: null, name: '' }, keywords: [], benefits: '', costs: '', additionDate: new Date(),
    meanRating: null
  };
  subjects: Subject[];
  constructor(private _ideaService: IdeaService, private _subjectService: SubjectService) { }

  ngOnInit() {
    this.getSubjects();
  }

  onSubmit() {
    if (this.idea.id == null) { this.createIdea(this.idea); } else { this.updateIdea(this.idea); }
  }

  createIdea(idea) {
    this._ideaService.createIdea(idea)
      .subscribe(
        data => true,
        error => this.handleError(error),
        () => console.log('creating idea done')
      );
  }

  updateIdea(idea) {
    this._ideaService.updateIdea(idea).subscribe(
      data => true,
      error => this.handleError(error),
      () => console.log('updating idea done')
    );
  }

  removeChip(keyword: any): void {
    const ind = this.idea.keywords.indexOf(keyword);
    if (ind >= 0) { this.idea.keywords.splice(ind, 1); }
  }

  addChip(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;
    if ((value || '').trim()) {
      this.idea.keywords.push(value.trim());
    }
    if (input) { input.value = ''; }
  }

  private getSubjects() {
    this._subjectService.getSubjects()
      .subscribe(
        subjects => this.subjects = subjects,
        error => this.handleError(error)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
  }

}
