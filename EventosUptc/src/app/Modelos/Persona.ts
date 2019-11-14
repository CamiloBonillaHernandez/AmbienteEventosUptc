import { TipoPersona } from './TipoPersona';
export interface Persona{
    idPersona : number | string;
    contrasenia : string;
    nombreP : string;
    tipoPersona : TipoPersona;
}