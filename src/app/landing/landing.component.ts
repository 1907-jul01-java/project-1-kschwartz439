import { Component, OnInit } from '@angular/core';
import { Session } from 'inspector';
import { AuthService } from '../auth/auth.service';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})

export class LandingComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private AuthService: AuthService,
    private formBuilder: FormBuilder,
    ) { }

  ngOnInit() {
    this.AuthService.logout();
    this.loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
    });
  }

  signout(){
    //TODO:Figure out authentication services with angular
    this.AuthService.logout()
  }

}
