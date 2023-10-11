package com.app

data class Todo (val id:Int, var status:Status, val item:String ) {
}

data class Todos(val todos:List<Todo>){
    fun printAsString(){
        println("\n--------------------------\n")
        todos.forEach {println("${it.id} : ${it.status} : ${it.item}")  }
        println("\n--------------------------\n")
    }
}