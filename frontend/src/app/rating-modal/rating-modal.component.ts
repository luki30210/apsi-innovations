import { Component, OnInit, Output } from '@angular/core';
import {MatDialog} from '@angular/material';
import {IdeaDetailsComponent} from '../idea-details/idea-details.component';
import {Idea} from '../_model/idea';
import {ActivatedRoute} from '@angular/router';
import {IdeaService} from '../_service/idea.service';
import {Input} from '@angular/core';
import {ViewChild} from '@angular/core';
import {MatDialogModule, MatDialogClose, MatDialogRef} from '@angular/material/dialog';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RatingService } from '../_service/rating.service';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-rating-modal',
  templateUrl: './rating-modal.component.html',
  styleUrls: ['./rating-modal.component.scss']
})
export class RatingModalComponent implements OnInit {
  rateIdea = 'Oceń pomysł';
  @Input() idea: Idea;
  rating;
  textOpinion;
  constructor(private _ratingService: RatingService, public dialog: MatDialog) {
   }


  ngOnInit() {
  }

  openDialog() {
    const dialogRef = this.dialog.open(DialogContentComponent, {
      height: '350px',
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}` + this.idea.id);
      this._ratingService.rateIdea(result[0], result[1], this.idea.id);

    });
  }

}

@Component({
  selector: 'app-rating-modal-content',
  templateUrl: 'rating-modal-content.component.html',
  styleUrls: ['./rating-modal-content.component.scss']

})
export class DialogContentComponent {

  oceny = [1, 2, 3, 4, 5];
  textOpinion;
  rating;
  id = 2;
  payload;
  constructor(private _ratingService: RatingService, private dialogRef: MatDialogRef<DialogContentComponent>) {}

  onClickSubmitButton() {
    if (this.textOpinion !== undefined) {
      console.log('przeslano opinie' + this.rating + this.textOpinion);
     // this._ratingService.createIdea(this.rating, this.textOpinion, this.id);
      this.payload = [this.rating, this.textOpinion]
      this.dialogRef.close(this.payload);
    } else {
      console.log('przeslano opinie' + this.rating );
     // this._ratingService.createIdea(this.rating, this.textOpinion, this.id);
      this.dialogRef.close(this.rating);

    }
  }



}
