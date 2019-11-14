import { Persona } from './Persona';
import { Categoria } from './Categoria';
export interface Evento{
    idEvento : number | string;
    tituloE: string;
    descripcionE : string;
    fInicioE : string;
    fFinalE : string;
    imagenE : string;
    lugarE : string;
    categoria : Categoria;
    persona : Persona;
}