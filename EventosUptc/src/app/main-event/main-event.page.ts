import { TipoPersona } from './../Modelos/TipoPersona';
import { Persona } from './../Modelos/Persona';
import { Categoria } from './../Modelos/Categoria';
import { Evento } from './../Modelos/Evento';
import { Component, OnInit } from '@angular/core';
import {Consultas} from '../Servicios/Consultas/consultas.service'

@Component({
  selector: 'app-main-event',
  templateUrl: './main-event.page.html',
  styleUrls: ['./main-event.page.scss'],
})
export class MainEventPage implements OnInit {

  public listaEventos : Array<Evento>;

  lista:string[]=["cat1","cat2","cat3","catN"];

  public evento1 : Evento;
  public evento2 : Evento;

  public categoria : Categoria;
  public persona : Persona;
  public tipoPersona : TipoPersona;


  constructor(private consultas: Consultas) {
    this.categoria = new Categoria;
    this.persona = new Persona;
    this.tipoPersona = new TipoPersona;
    this.evento1 = new Evento;

    this.listaEventos = new Array;
    
   }

  ngOnInit() {
  }

  /**
   * initEventos
   */
  public initEventos() {
    this.categoria.idCategoria == 1;
    this.categoria.nombreC = "catN";
    this.tipoPersona.tituloTp="admin";
    this.persona.nombreP = "UserAdmin"
    this.persona.tipoPersona = this.tipoPersona;

    this.evento1.idEvento = 1;
    this.evento1.tituloE = "Evento 1";
    this.evento1.descripcionE = "desc evento 1";
    this.evento1.fInicioE = null;
    this.evento1.fFinalE = null;
    this.evento1.imagenE = null;
    this.evento1.categoria = this.categoria;
    this.evento1.persona = this.persona;

    console.log(this.evento1.idEvento + " "+ this.evento1.tituloE+ " "+this.evento1.categoria.nombreC);

    this.listaEventos.push(this.evento1);
    //this.listaEventos.push(this.evento2);

  }

  /*
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
  }*/
}
