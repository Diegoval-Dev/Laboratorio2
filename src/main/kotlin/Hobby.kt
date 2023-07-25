data class Hobby(val Titulo: String, val Descripcion: String,val UrlPhoto: String?){
    override fun toString(): String {
        return "Titulo: ${this.Titulo} \n Descripcion: ${this.Descripcion} \n Url foto: ${this.UrlPhoto}"
    }
}