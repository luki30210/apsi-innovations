import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  loggedUserName: string = undefined;

  constructor() { }

  ngOnInit() {
  }

  onLoginClicked() {
    this.loggedUserName = 'Janusz Wklapkach';
  }

  onLogoutClicked() {
    this.loggedUserName = undefined;
  }

}
