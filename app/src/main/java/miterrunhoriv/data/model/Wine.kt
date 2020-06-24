package miterrunhoriv.data.model

class Wine(id:Long, name:String, review:String, grape_type:String, brand:String,
           year:String, origin: String, stock:Int, price:Double, image:String) {

    var id: Long= id
    var name: String= name
    var review: String= review
    var grape_type: String= grape_type
    var brand: String= brand
    var year: String= year
    var origin: String= origin
    var stock: Int= stock
    var price: Double =price
    var image:String =image
}