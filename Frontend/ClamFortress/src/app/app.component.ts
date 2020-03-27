import { Component } from '@angular/core';
import { GameService } from './game.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ClamFortress';
  world = 'World';
  gameData;
  constructor(private gameService:GameService){

  }

  ngOnInit(){
    console.log(this.gameService);
    this.gameService.getGame().subscribe((gameData)=>{
        this.gameData = gameData;
    });
  }
}
