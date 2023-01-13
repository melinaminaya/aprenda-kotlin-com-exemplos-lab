// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { 
    static int BASICO = 0, 
    static int INTERMEDIARIO = 1,
    static int DIFICIL = 2
}

data class Usuario(val nome: String, val email: String, val id: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

}
class UsuarioDao {

    // "Initialize" with a few users
    // This demonstrates type inference, map-literals and named parameters
    val inscritos = hashMapOf(
            0 to User(name = "Alice", email = "alice@alice.kt", id = 0),
            1 to User(name = "Bob", email = "bob@bob.kt", id = 1),
            2 to User(name = "Carol", email = "carol@carol.kt", id = 2),
            3 to User(name = "Dave", email = "dave@dave.kt", id = 3)
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    fun matricular(nome: String, email: String) {
        val id = lastId.incrementAndGet()
        inscritos[id] = Usuario(nome = nome, email = email, id = id)
    }

    fun buscarPorId(id: Int): Usuario? {
        return inscritos[id]
    }

    fun buscarPorEmail(email: String): Usuario? {
        return inscritos.values.find { it.email == email } // == is equivalent to java .equals() (referential equality is checked by ===)
    }

    fun atualizar(id: Int, usuario: Usuario) {
        inscritos[id] = Usuario(nome = usuario.nome, email = usuario.email, id = id)
    }

    fun deletar(id: Int) {
        inscritos.remove(id)
    }

}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
   // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
   val userDao = userDao()

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setValuesToViews()

        addAlunoButton.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
            startActivityForResult(intent,1)
        }
    }
    val addAlunoButton = findViewById<Button>(R.id.addAlunoButton)
        addAlunoButton.setOnClickListener {
        // Return note text to the NotesActivity
        //val data = Intent()
        matricular("Pedro")
        setResult(Activity.RESULT_OK, data)
        // Close current window
        onBackPressed()
    }
    private fun setValuesToViews() {
        inscritos.nome = intent.getStringExtra("nome")
        inscritos.email = intent.getStringExtra("email")
    }
    

}
