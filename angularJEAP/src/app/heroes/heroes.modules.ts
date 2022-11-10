import { NgModule } from '@angular/core';
import { HeroesMainPageComponent } from './main-page/main-page.component';


//componentes del modulo
@NgModule({
  declarations:[HeroesMainPageComponent],
  imports:[], //solo se agregan otros modulos
  providers:[], //solo se agregan los servicios
  exports:[HeroesMainPageComponent],

})

export class HeroesModule{

}
