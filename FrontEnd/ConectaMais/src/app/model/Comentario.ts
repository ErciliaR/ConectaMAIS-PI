import { Postagem } from "./Postagem"
import { Usuario } from "./Usuario"

export class Comentario{
    public comentarioID: number
    public conteudoComentario: string
    public dataCriacaoComentario: Date
    public dataAtualizacaoComentario: Date
    // relacoes entre tabelas
    public usuarioObj: Usuario
    public postagemObj: Postagem
}