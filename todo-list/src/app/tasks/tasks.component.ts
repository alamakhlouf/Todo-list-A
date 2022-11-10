import { NumberInput } from '@angular/cdk/coercion';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent implements OnInit {
  value : string;
  description : string ; 
  constructor(public http : HttpClient) { }
  tasks : any ; 
  id : number ;
  show : boolean = true ;
  
  ngOnInit(): void {
    this.getAllTask() ;
  }
  getAllTask() {
    let url  = "http://localhost:8080/tasks/AllTasks"
    let res = this.http.get(url) ;
    res.subscribe((data) =>{console.log(data); this.tasks=data}) 
  }

  postTask(task : string , desc : string) {
    let newTask = {taskName:task,taskDescription:desc} ;
    let url  = "http://localhost:8080/tasks/task"
    let ress= this.http.post(url,newTask,{responseType: 'Text' as 'json'}) ;
    ress.subscribe((data)=>console.log(data)) ;
    this.value=' ';
    this.description=' ';
   // this.getAllTask() ;
    location.reload() ;
  }
  save(taskName:string,taskDescription:string){
    let url  = "http://localhost:8080/tasks/task/add" ; 
    let newTask = {id:this.id,taskName:taskName,taskDescription:taskDescription} ;
    let result = this.http.put(url,newTask).subscribe() ;
    this.value=' ' ;
    this.description=' ';
    //this.getAllTask() ;
    this.show=true ;
    location.reload() ;

  }

  delete(value : string, desc : string , id : string ) {
    this.id = Number(id) ; 
    let url  = "http://localhost:8080/tasks/employee" ; 
    let newTask = {id:this.id,taskName:value,taskDescription:desc} ;
    let res = this.http.request('delete',url,{body:newTask}) ;
    res.subscribe() ;
    //this.getAllTask() ;
    location.reload() ;
  }

  edit(value : string , desc : string, id : string ) {
    this.value = value ; 
    this.description = desc ;
    this.id = Number(id) ; 
    this.show = false ;
  }

}
