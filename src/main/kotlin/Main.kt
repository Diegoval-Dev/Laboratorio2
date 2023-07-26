val listaPerfiles = mutableListOf<PerfilUsuario>()
fun main(args: Array<String>) {
    init()

    var opcion = menu()

    do{
        when(opcion){
            1 -> {
                listaPerfiles.add(crearPerfil())
            }
            2 -> {
                print("Ingrese el nombre, apellido:")
                val buscador = readln()
                val usuario = buscarUsuario(buscador)
                if(usuario != null){
                    print(usuario.toString())
                }
            }
            3 -> {
                println("Eliminar Usuario por ID \n Ingresar ID del ususario ")
                val idEliminar = readln().toInt()
                if(buscarUsuario(idEliminar) != null){
                    listaPerfiles.remove(buscarUsuario(idEliminar))
                    println("Usuario eliminado exitosamente")
                }
            }
            4 -> {
                println("Ingrese el nombre del usuario a Agregar un nuevo hobbie")
                val buscador = readln()
                val usuario = buscarUsuario(buscador)
                if(usuario != null){
                    print("$usuario.to\n Ingrese el nuevo hobbie: ")
                    usuario.Hobbies = createHobby(usuario.Hobbies)
                    println("Los nuevos hobbies del usuario son: \n ${usuario.Hobbies}")
                }
            }
            5 -> printList()
        }
        opcion = menu()
    }while (opcion != 6)
}
fun buscarUsuario(buscador: String): PerfilUsuario?{
    for (usuario in listaPerfiles){
        if (usuario.Nombres == buscador || usuario.Apellidos == buscador ){
            return usuario
        }
    }
    println("Ese Usuario no existe")
    return null
}
fun buscarUsuario(buscador: Int): PerfilUsuario?{
    for (usuario in listaPerfiles){
        if (usuario.ID == buscador){
            return usuario
        }

    }
    println("Ese Usuario no existe")
    return null
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
    val regexNombeApellido = Regex("^[a-zA-Zá-úÁ-Ú]+\$")
    val regexCorreo = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
    var nombre: String?
    var apellido: String?
    do {
        println("Ingrese el nombre: ")
        nombre = readLine()
        if (nombre != null && !regexNombeApellido.matches(nombre)) {
            println("Nombre no válido.")
        }
    }while (nombre == null || !regexNombeApellido.matches(nombre))
    do {
        println("Ingrese el apellido: ")
        apellido = readLine()
        if (apellido != null && !regexNombeApellido.matches(apellido)) {
            println("Apellido no válido.")
        }
    }while (apellido == null || !regexNombeApellido.matches(apellido))
    println("Ingrese la URL de la foto")
    val urlFoto = readLine()
    var edad: Int?
    do {
        println("Ingrese la edad: ")
        edad = readLine()?.toIntOrNull()
        if (edad == null || edad !in 1..120) {
            println("Edad no válida.")
        }
    }while (edad == null || edad !in 1..120)
    var correo: String?
    do {
        println("Ingrese el correo: ")
        correo = readLine()
        if (correo != null && !regexCorreo.matches(correo)) {
            println("Correo no válido.")
        }
    }while (correo == null || !regexCorreo.matches(correo))

    val listHobbies = mutableListOf<Hobby>()
    var estado = Estado.Pendiente
    do{
        println("Ingrese el numero del estado: \n1.Activo \n1.Pendiente \n3.Inactivo")
        val op = readln().toInt()
        when(op){
            1 -> estado = Estado.Activo
            2 -> estado = Estado.Pendiente
            3 -> estado = Estado.Inactivo
            else -> println("Opcion incorrecta, seleccione un numero entre 1 y 3")
        }
    }while (op != 1 && op != 2 && op !=3)
    return PerfilUsuario(nombre,apellido,urlFoto,edad.toInt(),correo,estado,createHobby(listHobbies))
}
fun createHobby(listaHobbies: MutableList<Hobby> ): MutableList<Hobby> {
    println("--Creacion de hobbie--")

    do {
        println("Ingrese el titulo:")
        val titulo = readln()
        println("Ingrese la descripcion:")
        val descripcion = readln()
        println("Ingrese la url de una foto:")
        val urlFoto = readln()

        listaHobbies.add(Hobby(titulo, descripcion, urlFoto))

        println("Desea agregar un nuevo Hobbie? s/n")
        val op = readln()
    } while (op != "n")
    return listaHobbies
}
fun menu(): Int{
    println("---Menú--- \nseleccione la opcion a ingresar: \n1. Crear Perfil \n2. Buscar Perfil por nombre/ID \n3. Eliminar perfil \n4. Agregar hobby \n5.imprimir lista de usuarios" +
            "\n6. Salir")
    val regexNumeros = Regex("^[1-6]\$")
    val opcion = readLine()
    if ((opcion != null && regexNumeros.matches(opcion))) {
        return opcion.toInt()
    } else {
        println("Opcion no valida. Eliga una opcion del 1 al 6")
        menu()
    }
    return 0
}
