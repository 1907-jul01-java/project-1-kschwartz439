import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { ReimbursementComponent } from './reimbursement/reimbursement.component';
import { UploadComponent } from './upload/upload.component';
import { LandingComponent } from './landing/landing.component';




const routes: Routes = [

    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'signup',
        component: SignupComponent
    },
    {
        path: 'reimbursement',
        component: ReimbursementComponent
    },
    {
        path: 'upload',
        component: UploadComponent
    },
    {
        path: 'landing',
        component: LandingComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }