import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { TaskClass } from './task-class.model';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'todo-list';
  tasks : any;
  value : string ; 
  description : string ;
  previous_valueT : string ; 
  previous_valueD : string ; 
  saved : boolean = false ;
  constructor(public http : HttpClient) {

  }

}
