import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {

  counter = 0;

  constructor() { }

  ngOnInit(): void {
  }

  onIncreaseCount(){
    this.counter = this.counter + 1;
  }

}
