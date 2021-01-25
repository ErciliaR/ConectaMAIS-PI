import { Postagem } from "./Postagem";
import { Usuario } from "./Usuario";

export class Comentario {
    // atributos de comentario
    public comentarioID: number;
    public conteudoComentario: string;
    public dataCriacaoComentario: Date;
    public dataAtualizacaoComentario: Date;
    // relacoes entre tabelas
    public usuarioObj: Usuario;
    public postagemObj: Postagem;


}