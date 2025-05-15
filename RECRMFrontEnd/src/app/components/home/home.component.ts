import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactService } from '../../services/contact.service';
import { Router } from '@angular/router';
import { Contact } from '../../models/contact.model';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  public upcomingBdays: Contact[] = [];


  constructor(private cServe : ContactService, private router : Router) {}
  ngOnInit() : void {
    if(!localStorage.getItem("jwt"))
      this.router.navigate(['login']);

    this.cServe.getUpcomingBirthdays().subscribe(
      response => {
        this.sleep(1500);
        this.upcomingBdays = response;
      },
      error => {
        console.warn("An error has occured");
      }
    );
  }

  sleep(ms: number | undefined) {
    return new Promise((resolve) => {
      setTimeout(resolve, ms);
    });
  }

}
