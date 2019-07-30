import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username = "";
  password = "";
  login(){
    this.authService.login(this.username, this.password);
  }

  constructor(private authService:AuthService) { }

  ngOnInit() {

  }

}