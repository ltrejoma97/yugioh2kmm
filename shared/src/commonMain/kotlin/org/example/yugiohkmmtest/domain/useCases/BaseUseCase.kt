package org.example.yugiohkmmtest.domain.useCases

// Clase abstracta BaseUseCase
abstract class BaseUseCase<in Params, Result> {



    // Manejo de errores
    protected fun handleError(error: String): String {
        // Aquí puedes implementar la lógica para manejar el error
        // Por ejemplo, podrías lanzar una excepción o devolver un resultado específico
        return  error
//        throw Exception(error)
    }
}

// Clase para manejar respuestas y errores en los casos de uso
sealed class BaseUseCaseResponse<out T> {
    data class Success<out T>(val data: T) : BaseUseCaseResponse<T>()
    data class Error(val message: String) : BaseUseCaseResponse<Nothing>()


}