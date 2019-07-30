import { Component, OnInit } from '@angular/core';
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
    this.loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
    });
    
  }

  signout(){
    //TODO:Figure out authentication services with angular
    //sessionStorage.clear();
  }

}
