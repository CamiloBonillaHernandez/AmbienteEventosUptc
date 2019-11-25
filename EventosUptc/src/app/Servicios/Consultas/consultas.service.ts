import { Evento } from './../../Modelos/Evento';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
//import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';


@Injectable({
    providedIn: 'root'
})
export class Consultas extends AbstractService {


  public evento: Evento;
  

    /**
   * Constructor
   */
  constructor(injector: Injector) {
    super(injector);
  }

  public ListarEventos() : Observable<Evento[]> {
    return this.get<Evento[]>("/RestfullServices", "/Evento/Listar",
    {});
  }
}