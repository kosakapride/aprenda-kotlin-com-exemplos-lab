// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarInscritos(): List<Usuario> {
        return inscritos
    }

    fun cancelarMatricula(usuario: Usuario) {
        inscritos.remove(usuario)
    }
}

fun main() {
    // Criando alguns objetos para teste
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120, Nivel.INTERMEDIARIO)
    
    val formacao = Formacao("Curso de Kotlin", listOf(conteudo1, conteudo2))
    
    // Matricular usuários
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    // Listar inscritos
    val inscritos = formacao.listarInscritos()
    println("Inscritos na formação:")
    for (inscrito in inscritos) {
        println(inscrito.nome)
    }
    
    // Cancelar matrícula
    formacao.cancelarMatricula(usuario1)
    
    // Listar inscritos novamente
    val inscritosAtualizados = formacao.listarInscritos()
    println("\nInscritos na formação (após cancelamento):")
    for (inscrito in inscritosAtualizados) {
        println(inscrito.nome)
    }
}
