package com.app

class TodoApp(existingTodos: List<Todo>) {
    private var id = 1
    private val allList = existingTodos.toMutableList()

    fun add(content: String): Boolean {
        val newTodo = Todo(id,Status.PENDING,content)
        id++
        return allList.add(newTodo)
    }

    fun get(id:Int): Todo? {
        return allList.find { it.id ==id }
    }

    fun getAll(): Todos {
        return Todos(allList)
    }

    fun markDone(id: Int): Boolean {
        val todo:Todo? = get(id)
        allList.remove(todo)
        todo?.status = Status.DONE
        return allList.add(todo!!)
    }
}
