import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { BoardPage } from '../pages/board-page/board-page';
import { MoveService } from '../services/move-service';
import { DragulaModule, DragulaService } from 'ng2-dragula'
import {  NavController, NavParams} from "ionic-angular";
@NgModule({
  declarations: [
    MyApp,
    BoardPage
  ],
  imports: [
    IonicModule.forRoot(MyApp),
    DragulaModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    BoardPage
  ],
  providers: [{provide: ErrorHandler, useClass: IonicErrorHandler}, MoveService, DragulaService]
})
export class AppModule {}
