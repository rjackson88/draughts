import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
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
  templateUrl: 'board-page.html'
})
export class BoardPage {

  checkersBoard : jsonInterface = new jsonInterface(new startingBoard);
  
       
  constructor( public navCtrl: NavController, public navParams: NavParams, public moveService: MoveService, public http: Http) {
 
}

  startGame(){
 this.http.get("http://localhost:8080/newGame").
 subscribe(res =>{ this.checkersBoard = new jsonInterface(res.json()); console.log(this.checkersBoard)})

  
  }

  isValid(position: number){

    if(this.checkersBoard.board[position] == 0)
    return false;
    else
    return true;
  }


fetchMoveService(){
       this.http.post("http://localhost:8080/movePiece", this.checkersBoard ).subscribe(res => {this.checkersBoard
       = new jsonInterface(res.json()); console.log(this.checkersBoard)})
        };

  populatePosition(piece: number) : string{
      if(piece == 1){
        return '../../assets/BlackRealistic.png'

      }
      else if(piece == -1){

        return '../../assets/RedRealistic.png'
      }
      else if(piece == 3){

        return '../../assets/transparency.png'
      }

      else if(piece == 0){
        return '../../assets/clear.png'
      }

     else return ' '
  }

  moveSelection(position:number){

      if(this.checkersBoard.positionFrom == 0){
      this.checkersBoard.positionFrom = position;
      this.http.post("http://localhost:8080/checkMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json())}
      )
    }

    else if(this.checkersBoard.positionFrom == position){
          this.checkersBoard.positionFrom = 0;
           this.http.post("http://localhost:8080/clearMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json());}
        )
    }

    else if(this.checkersBoard.board[position] == 3){
      this.checkersBoard.positionTo = position;
      this.http.post("http://localhost:8080/movePiece", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json()); console.log(this.checkersBoard)}
        )

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
       blackPieceCount: number;
       whitePieceCount: number;
       whiteWinner: boolean;
       blackWinner: boolean;
       id: number;
}

export class startingBoard {
 board : number[] = [1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1];
       positionTo: number;
       positionFrom: number = 0;
       blackPieceCount: number;
       whitePieceCount: number;
       whiteWinner: boolean;
       blackWinner: boolean;
       id: number;

}





