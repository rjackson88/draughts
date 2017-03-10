import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { BoardPage } from '../pages/board-page/board-page';
import { MoveService } from '../services/move-service';
@NgModule({
  declarations: [
    MyApp,
    BoardPage
  ],
  imports: [
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    BoardPage
  ],
  providers: [{provide: ErrorHandler, useClass: IonicErrorHandler}, MoveService]
})
export class AppModule {}
