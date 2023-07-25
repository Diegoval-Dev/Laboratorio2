val listaPerfiles = mutableListOf<PerfilUsuario>()
fun main(args: Array<String>) {
    init()
    printList()

    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}
fun init(){
    listaPerfiles.add(PerfilUsuario("Diego","Pablo",null,20,"Diegopablo12@gmail.com", Estado.Activo, mutableListOf(Hobby("Deportista","Hago deporte", null))))
    listaPerfiles.add(PerfilUsuario("Jose","Pablo",null,30,"Jose@gmail.com", Estado.Inactivo, mutableListOf(Hobby("Programador","Me Gusta Programar", null))))
}
fun printList(){
    for(PerfilUsuairo in listaPerfiles){
        println(PerfilUsuairo.toString())
    }
}
fun crearPerfil(): PerfilUsuario{
    var regexNombe = Regex("^[a-zA-Zá-úÁ-Ú]+\$")

}
