import { Evento } from './../Modelos/Evento';
import { Component, OnInit } from '@angular/core';
import {Consultas} from '../Servicios/Consultas/consultas.service'

@Component({
  selector: 'app-main-event',
  templateUrl: './main-event.page.html',
  styleUrls: ['./main-event.page.scss'],
})
export class MainEventPage implements OnInit {

  public listaEventos : Evento[];

  constructor(private consultas: Consultas) { }

  ngOnInit() {
  }


  public consultarEventos(){
       this.consultas.ListarEventos().subscribe(
      eventos => {
          this.listaEventos = eventos;
        },
        error => {
          console.log(error);
        } 
    );    
    console.log('resultado servicio Eventos ' + this.listaEventos);
  }
}
