import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  username="";
  password="";
  firstName="";
  lastName="";
  email="";
  constructor(private authService:AuthService) { }

  signup(){
    this.authService.signup(this.username, this.password, this.firstName, this.lastName, this.email)
  }
  ngOnInit() {
  }

}
