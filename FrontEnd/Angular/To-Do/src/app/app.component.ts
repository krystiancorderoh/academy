import { Component } from '@angular/core';
import {FormControl , FormGroup} from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';

class Todo{
  title : string;
  description : string;
  status: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  newTodoForm;
  todoList=[];
  columnsToDisplay : string[] = ['title', 'description', 'action'];
  dataSource: MatTableDataSource<Todo>;
  constructor(){
    this.dataSource = new MatTableDataSource(this.todoList);
    this.newTodoForm  = new FormGroup({
      title: new FormControl(),
      description: new FormControl()
    })


    
  }
  addTodo(formValue){
    console.log(formValue);
    this.todoList.push(formValue);
    this.newTodoForm.reset();

    this.dataSource.data = this.todoList;
    console.log(this.dataSource.data);
  }
  removeTodo(index){
    console.log(index);
    this.todoList.splice(index,1);
    this.dataSource = new MatTableDataSource(this.todoList);
  }
}