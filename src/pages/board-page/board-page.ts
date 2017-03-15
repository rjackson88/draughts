import { Component } from '@angular/core';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import { MoveService } from '../../services/move-service';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { DragulaService} from "../../../node_modules/ng2-dragula/ng2-dragula"




/*
  Generated class for the BoardPage page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-board-page',
 templateUrl: 'board-page.html',
 providers: [DragulaService]
  
})
export class BoardPage {

  checkersBoard : jsonInterface = new jsonInterface(new startingBoard);
  
       
  constructor(private alertCtrl: AlertController, public navCtrl: NavController, public navParams: NavParams, public moveService: MoveService, public http: Http, private DragulaService: DragulaService) {
 
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
 this.http.get("https://evening-earth-96180.herokuapp.com/newGame").
 subscribe(res =>{ this.checkersBoard = new jsonInterface(res.json()); console.log(this.checkersBoard)})

  
  }

  isValid(position: number){

    if(this.checkersBoard.board[position] <= 0 && this.checkersBoard.board[position] != -3)
    return false;
    else
    return true;
  }

  loadGame(){
    this.http.get("https://evening-earth-96180.herokuapp.com/load").subscribe(res => {this.checkersBoard = new jsonInterface(res.json()); this.loadAlert()})
  }

saveGame(){

  this.http.put("https://evening-earth-96180.herokuapp.com/save",this.checkersBoard).subscribe(res=>{console.log(res); this.saveAlert()})
}

fetchMoveService(){
       this.http.post("https://evening-earth-96180.herokuapp.com/movePiece", this.checkersBoard ).subscribe(res => {this.checkersBoard
       = new jsonInterface(res.json()); console.log(this.checkersBoard)})
        };

  populatePosition(piece: number) : string{
      if(piece == 1){
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



  moveSelection(position:number){

    //position 0
    if(this.checkersBoard.positionFrom == 0 && position == 0){

      if(this.checkersBoard.board[4] == -3 || this.checkersBoard.blackPieceCount[5] == -3){
         this.http.post("https://evening-earth-96180.herokuapp.com/clearMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json());}
        )
      }
     else
      this.http.post("https://evening-earth-96180.herokuapp.com/checkMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json())}
      )
    }


      //chceck possible moves
      else if( (this.checkersBoard.positionFrom != position && this.checkersBoard.board[position] >= 0 )){
      this.checkersBoard.positionFrom = position;
      this.http.post("https://evening-earth-96180.herokuapp.com/checkMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json())}
      )
    }
    //clear shown moves
    else if((this.checkersBoard.positionFrom == position && this.checkersBoard.board[position] >= 0)){
          this.checkersBoard.positionFrom = 0;
           this.http.post("https://evening-earth-96180.herokuapp.com/clearMoves", this.checkersBoard).subscribe(
        res => {this.checkersBoard = new jsonInterface(res.json());}
        )
    }
    //move piece to selected position
    else if(this.checkersBoard.board[position] == -3){
      this.checkersBoard.positionTo = position;
      this.http.post("https://evening-earth-96180.herokuapp.com/movePiece", this.checkersBoard).subscribe(
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
       id: number = 1;

}







