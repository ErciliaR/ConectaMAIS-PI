import { Comentario } from "./Comentario";
import { Usuario } from "./Usuario";

export class Postagem {
    // atributos de postagem
    public postagemID: number;
    public titulo: string;
    public conteudoPostagem: string;
    public tema: string;
    public dataCriacaoPostagem: Date;
    public dataAtualizacaoPostagem: Date;
    // relacoes entre tabelas
    public instituicaoObj: Usuario;
    public comentarioObj: Comentario;
}