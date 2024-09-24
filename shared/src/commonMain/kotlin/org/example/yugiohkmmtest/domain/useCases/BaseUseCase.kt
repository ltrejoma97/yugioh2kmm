package org.example.yugiohkmmtest.domain.useCases

data class BaseResponse(
    val data : ResponseData?,
    val success : Boolean = true
){
    inline fun <reified T> asData() : T? {
        if( data is T)
            return data
        return null
    }
    companion object{
        fun <T> success(data : T): BaseResponse {
            return BaseResponse(ResponseData.SuccessData(data))
        }

        fun error(generalError: GeneralError): BaseResponse {
            return BaseResponse(ResponseData.ErrorData(generalError),false)
        }
    }
}

sealed class ResponseData {

    data class SuccessData<T>(val data : T) : ResponseData()

    data class ErrorData(val generalError : GeneralError = GeneralError.UnknownError()) : ResponseData()

}


sealed class GeneralError {

    data class UnknownError(val errorCause : GeneralErrorCause = GeneralErrorCause.UNKNOWN) : GeneralError()
    data class KnownError(val error :String) : GeneralError()
    data class ResourceError(val error :Int) : GeneralError()
}

enum class GeneralErrorCause  {
    NO_NETWORK, BAD_REQUEST, UNAUTHORIZED , UNKNOWN, WRONG_FORM
}


class UseCaseResponse<T>(
    val success : Boolean = true,
    val data : T? = null,
    val error : GeneralError? = null
) {
    companion object{
        fun <T> success(data : T): UseCaseResponse<T> {
            return UseCaseResponse(data = data)
        }

        fun <T> error(generalError : GeneralError?): UseCaseResponse<T> {
            return UseCaseResponse(success = false,data = null,error = generalError)
        }
    }
}