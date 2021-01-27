import { Comentario } from "./Comentario"
import { Postagem } from "./Postagem"

export class Usuario{
    public usuarioID: number
    public nome: string
    public email: string
    public senha: string
    public imagemPerfilURL: string
    public papel: string
    public descricao: string
    public cidade: string
    public idadeMin: number
    public idadeMax: number
    public comentarioObj: Comentario[]
    public postagemObj: Postagem[]
}