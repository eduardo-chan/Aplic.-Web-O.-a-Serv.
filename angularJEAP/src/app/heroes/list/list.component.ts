import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: []
})
export class ListComponent implements OnInit {

  constructor() {
    console.log('constructor')
  }
  ngOnInit(): void {
    console.log('ngOnInit')
  }

}
