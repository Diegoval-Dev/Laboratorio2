class PerfilUsuario(val Nombres: String, val Apellidos: String, val UrlPhoto: String?, val Edad: Int, val Correo: String, val Estado: Estado,val Hobbies: MutableList<Hobby>) {
    val ID: Int = contadorID()
    companion object {
        private var contador: Int = 0
        fun contadorID(): Int {
            return ++contador
        }
    }
    override fun toString(): String {
        return "ID: ${this.ID},\n Nombres: ${this.Nombres},\n Apellidos: ${this.Apellidos},\n URLPhoto: ${this.UrlPhoto}," +
                "\n Edad: ${this.Edad},\n Correo: ${this.Correo}," +
                "\n Estado: ${this.Estado},\n Hobbies: ${this.Hobbies}"
    }
}