import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { MoveService } from '../../services/move-service';
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


public firstSelection: any; 
public possibleMoves: any;
public data: any; 



  constructor(public navCtrl: NavController, public navParams: NavParams, public moveService: MoveService) {



    this.data = [{
      "one" : "BlackMan",
      "two" : "BlackMan",
      "three" : "BlackMan",
      "four" : "BlackMan",
      "five" : "BlackMan",
      "six" : "BlackMan",
      "seven" : "BlackMan",
      "eight" : "BlackMan",
      "nine" : "BlackMan",
      "ten" : "BlackMan",
      "eleven" : "BlackMan",
      "twelve" : "BlackMan",
      "thirteen" : "Empty",
      "fourteen" : "Empty",
      "fifteen" : "Empty",
      "sixteen" : "Empty",
      "seventeen" : "Empty",
      "eighteen" : "Empty",
      "nineteen" : "Empty",
      "twenty" : "Empty",
      "twentyone" : "WhiteMan",
      "twentytwo" : "WhiteMan",
      "twentythree" : "WhiteMan",
      "twentyfour" : "WhiteMan",
      "twentyfive" : "WhiteMan",
      "twentysix" : "WhiteMan",
      "twentyseven" : "WhiteMan",
      "twentyeight" : "WhiteMan",
      "twentynine" : "WhiteMan",
      "thirty" : "WhiteMan",
      "thirtyone" : "WhiteMan",
      "thirtytwo" : "WhiteMan"
      }]
  }


  initGame(){


  }

  fetchMoveService(){
        this.moveService.getInitialState().subscribe(response => {
            this.data = response.json();
        });;
  }


  populatePosition(position: string) : string{
      if(position == "BlackMan"){
        return '../../assets/BlackRealistic.png'

      }
      else if(position == "WhiteMan"){

        return '../../assets/RedRealistic.png'
      }
      else if(position == "Moveable"){

        return '../../assets/transparency.png'
      }

      else return ' '
  }

  }





