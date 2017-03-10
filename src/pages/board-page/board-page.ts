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
      "01" : "BlackMan",
      "02" : "BlackMan",
      "03" : "BlackMan",
      "04" : "BlackMan",
      "05" : "BlackMan",
      "06" : "BlackMan",
      "07" : "BlackMan",
      "08" : "BlackMan",
      "09" : "BlackMan",
      "10" : "BlackMan",
      "11" : "BlackMan",
      "12" : "BlackMan",
      "13" : "Empty",
      "14" : "Empty",
      "15" : "Empty",
      "16" : "Empty",
      "17" : "Empty",
      "18" : "Empty",
      "19" : "Empty",
      "20" : "Empty",
      "21" : "WhiteMan",
      "22" : "WhiteMan",
      "23" : "WhiteMan",
      "24" : "WhiteMan",
      "25" : "WhiteMan",
      "26" : "WhiteMan",
      "27" : "WhiteMan",
      "28" : "WhiteMan",
      "29" : "WhiteMan",
      "30" : "WhiteMan",
      "31" : "WhiteMan",
      "32" : "WhiteMan",
      }]
  }

  ngOnInit(){

      this.data = [{}];
      

  }

  initGame(){


  }


  populatePosition(position: string){
      if(position == "BlackMan"){
        return '../../assets/BlackRealistic.png'

      }
      else if(position == "WhiteMan"){

        return '../../assets/WhiteRealistic.png'
      }
      else if(position == "Moveable"){

        return '../../assets/transparency.png'
      }
  }

  }





