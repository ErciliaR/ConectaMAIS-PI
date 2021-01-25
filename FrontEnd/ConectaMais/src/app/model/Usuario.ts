import { Comentario } from "./Comentario";
import { Postagem } from "./Postagem";

export class Usuario {
    // atributos de usuario
    public usuarioID: number;
    public nome: string;
    public email: string;
    public senha: string;
    public imagemPerfilURL: string;
    public papel: string;
    public descricao: string;
    public cidade: string;
    public idadeMin: number;
    public idadeMax: number;
    public escolaridadeMin: string;
    public generoSelecao: string;
    public tipo: string;
    // relacoes entre tabelas
    public comentarioObj: Comentario;
    public postagemObj: Postagem;



}