package miterrunhoriv.data.model

class Admin(id: Long, nombre: String, dni: String, telefono: String, mail: String, direccion: String) :
    Usuario(id,nombre,dni,telefono,mail,direccion) {
}