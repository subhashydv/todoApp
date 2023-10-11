import com.app.Command
import com.app.TodoApp
import com.app.Todos
import com.app.exception.InvalidCommandException

fun main(args: Array<String>) {
    val todoApp = TodoApp(listOf())
    while (true) {
        print("Type your command : ")
        val input = readln()
        val splittedInput = input.split(": ")
        val command = findCommand(splittedInput.get(0))!!
        validateCommand(command)

        when(command){
            Command.ADD -> {
                val content = splittedInput.subList(1, splittedInput.size).joinToString(" ")
                todoApp.add(content)
            }
            Command.SHOW -> {
                val allTodo = todoApp.getAll()
                showTodo(allTodo)
            }
            Command.MARKDONE -> {
                val id = splittedInput.get(1).toInt()
                todoApp.markDone(id)
            }
        }
    }
}

fun showTodo(allTodo: Todos) {
    allTodo.printAsString()
}

fun findCommand(value: String): Command? {
    return Command.values().find { it.value.equals(value, ignoreCase = true) }
}

fun validateCommand(command: Command) {
    if(Command.isPresent(command)){
        return
    }
    throw InvalidCommandException("Invalid command ${command}")
}
