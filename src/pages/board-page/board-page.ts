import { Component } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import { MoveService } from '../../services/move-service';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';





/*
  Generated class for the BoardPage page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-board-page',
 templateUrl: 'board-page.html',

  
})
export class BoardPage {

  checkersBoard : jsonInterface = new jsonInterface(new startingBoard);
  type: number;
  
       
  constructor(private alertCtrl: AlertController, public navCtrl: NavController, public navParams: NavParams, public moveService: MoveService, public http: Http) {
 
}

aiEasy(){
  this.checkersBoard.difficulty = "EASY";
}

aiMedium(){
  this.checkersBoard.difficulty = "MEDIUM";
}

winAlert(){
  let alert = this.alertCtrl.create({
    title: 'YOU WIN! :D',
    subTitle: 'Good job!',
    buttons: [{
      text: 'New Game',
      handler: () => {this.newGame()}
    }] 
  })
  alert.present();
}

loseAlert(){
  let alert = this.alertCtrl.create({
    title: 'LOSE WIN! :(',
    subTitle: 'Nice Try!',
    buttons: [{
      text: 'New Game',
      handler: () => {this.newGame()}
    }] 
  })
  alert.present();
}

loadAlert() {
  let alert = this.alertCtrl.create({
    title: 'Game Loaded',
    subTitle: 'Game state successfully loaded!',
    buttons: ['Dismiss']
  });
  alert.present();
}

saveAlert() {
  let alert = this.alertCtrl.create({
    title: 'Game Saved!',
    subTitle: 'Game state successfully saved',
    buttons: ['Dismiss']
  });
  alert.present();
}

  newGame(){
 this.http.get("https://warm-spire-37520.herokuapp.com/newGame").
 subscribe(res =>{ this.checkersBoard = new jsonInterface(res.json()); console.log(this.checkersBoard)})

  
  }

  isValid(position: number){

    if(this.checkersBoard.board[position] <= 0 && this.checkersBoard.board[position] != -3)
    return false;
    else
    return true;
  }

  loadGame(){
    this.http.get("https://warm-spire-37520.herokuapp.com/load").subscribe(res => {this.checkersBoard = new jsonInterface(res.json()); this.loadAlert()})
  }

saveGame(){

  this.http.put("https://warm-spire-37520.herokuapp.com/save",this.checkersBoard).subscribe(res=>{console.log(res); this.saveAlert()})
}


  populatePosition(piece: number) : string{
     
     
     if(piece == 5){{
       return '/assets/blackPick.png'
     }}
     
    else if(piece == 1){
        return '/assets/BlackRealistic.png'

      }
      else if(piece == -1){

        return '/assets/RedRealistic.png'
      }
      else if(piece == -3){

        return '/assets/transparency.png'
      }

      else if(piece == 0){
        return '/assets/clear.png'
      }

     else if(piece == 2){
       return '/assets/BlackRealisticKing.png'
     }

     else if(piece == -2){
       return '/assets/RedRealisticKing.png'
     }

      
    
  }

aiMove(){
  setTimeout(() => this.http.post("https://warm-spire-37520.herokuapp.com/aiMove", this.checkersBoard).subscribe(res => {
    (this.checkersBoard = new jsonInterface(res.json()));this.setCount();
    this.checkWinner(); console.log(this.checkersBoard)}), 1500);
  
}

  moveSelection(position:number){

this.checkersBoard.click = true;
    //position 0
    if(this.checkersBoard.positionFrom == 0 && position == 0){

      if(this.checkersBoard.board[position] == -3 || this.checkersBoard.board[position] == -3){
         this.checkersBoard.click = false;
         this.http.post("https://warm-spire-37520.herokuapp.com/clearMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json()); console.log(this.checkersBoard)}
        )
      }
     else
      this.http.post("https://warm-spire-37520.herokuapp.com/checkMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json()); }
      )
    }


      //chceck possible moves
      else if( (this.checkersBoard.positionFrom != position && this.checkersBoard.board[position] >= 0 )){
      this.checkersBoard.positionFrom = position;
      this.type = this.checkersBoard.board[position];
      this.http.post("https://warm-spire-37520.herokuapp.com/checkMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json());this.checkersBoard.board[position] = 5}
      )
    }
    //clear shown moves
    else if((this.checkersBoard.positionFrom == position && this.checkersBoard.board[position] >= 0)){
          this.checkersBoard.click = false;
          this.checkersBoard.positionFrom = 0;
           this.http.post("https://warm-spire-37520.herokuapp.com/clearMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json()); this.checkersBoard.board[position] = this.type}
        )
    }
    //move piece to selected position
    else if(this.checkersBoard.board[position] == -3){
      this.checkersBoard.click = false;
      this.checkersBoard.board[this.checkersBoard.positionFrom] = this.type;
      this.checkersBoard.positionTo = position;
      this.http.post("https://warm-spire-37520.herokuapp.com/movePiece", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json());this.setCount();
          this.checkWinner();this.aiMove()}
        )

    }
  }

  setCount(){
    this.checkersBoard.whiteCount = 0;
    this.checkersBoard.blackCount = 0;
    for(let i of this.checkersBoard.board ){
        if(i  > 0){
          this.checkersBoard.blackCount++;
        }
      else if(i < 0){
          this.checkersBoard.whiteCount++;
        }  
    }
  }

  checkWinner(){
  if (this.checkersBoard.blackCount == 0){
    this.loseAlert();
  } if (this.checkersBoard.whiteCount == 0){
    this.winAlert();
  }
}


}



export class jsonInterface {
       constructor(jsonStr: any) {
        let jsonObj: any = (jsonStr);
        for (let prop in jsonObj) {
            this[prop] = jsonObj[prop];
        }
    }
    
       board : number[];
       positionTo: number;
       positionFrom: number;
       blackCount: number;
       whiteCount: number;
       whiteWinner: boolean;
       blackWinner: boolean;
       difficulty: any;
       id: number;
       click: boolean;
}

export class startingBoard {
 board : number[] = [1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1];
       positionTo: number;
       positionFrom: number = 0;
       blackCount: number = 12;
       whiteCount: number =12;
       whiteWinner: boolean = this.blackCount == 0;
       blackWinner: boolean = this.whiteCount == 0;
       difficulty: any = "EASY";
       id: number = 1;
       click: boolean;

}







